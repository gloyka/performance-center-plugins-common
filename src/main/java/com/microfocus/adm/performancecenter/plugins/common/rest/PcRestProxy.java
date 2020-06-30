/**
 Copyright 2018 Micro Focus International plc

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.microfocus.adm.performancecenter.plugins.common.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.*;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.Test;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.SimplifiedTest;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.SimplifiedContent;
import com.microfocus.adm.performancecenter.plugins.common.utils.Base64Encoder;
import com.microfocus.adm.performancecenter.plugins.common.utils.ConvertContentStringToTest;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.apache.commons.httpclient.HttpStatus.*;

public class PcRestProxy {

    protected static final String        BASE_PC_API_URL                = "%s://%s/LoadTest/rest";
    protected static final String        BASE_PC_API_AUTHENTICATION_URL = BASE_PC_API_URL + "/authentication-point";
    protected static final String        AUTHENTICATION_LOGIN_URL       = BASE_PC_API_AUTHENTICATION_URL + "/authenticate";
    protected static final String        AUTHENTICATION_LOGOUT_URL      = BASE_PC_API_AUTHENTICATION_URL + "/logout";
    protected static final String        PC_API_RESOURCES_TEMPLATE      = BASE_PC_API_URL + "/domains/%s/projects/%s";
    protected static final String        RUNS_RESOURCE_NAME             = "Runs";
    protected static final String        TESTS_RESOURCE_NAME            = "tests";
    protected static final String        TEST_INSTANCES_NAME            = "testinstances";
    protected static final String        TEST_SETS_NAME                 = "testsets";
    protected static final String        RESULTS_RESOURCE_NAME          = "Results";
    protected static final String        EVENTLOG_RESOURCE_NAME         = "EventLog";
    protected static final String        TREND_REPORT_RESOURCE_NAME     = "TrendReports";
    protected static final String        TREND_REPORT_RESOURCE_SUFFIX     = "data";
    protected static final String        CONTENT_TYPE_XML               = "application/xml";
    protected static final String        SCRIPTS_RESOURCE_NAME          = "Scripts";
    protected static final String        TESTPLAN_RESOURCE_NAME          = "testplan";
    protected static final List<Integer> validStatusCodes = Arrays.asList(SC_OK, SC_CREATED, SC_ACCEPTED, SC_NO_CONTENT);

    public static final String           PC_API_XMLNS                   = "http://www.hp.com/PC/REST/API";

	private String baseURL;
    private String pcServer;
	private String domain;
	private String project;
	private String webProtocol;
	private String proxyScheme;
	private String proxyHostName;
	private int proxyPort;
    private String proxyUser;
    private String proxyPassword;
	private DefaultHttpClient client;
    private HttpContext context;
    private CookieStore cookieStore;
    private String tenantSuffix;

    public PcRestProxy(String webProtocolName, String pcServerName, String almDomain, String almProject, String proxyOutURL, String proxyUser, String proxyPassword) throws PcException {
        String[] lreServerAndTenant = Helper.GetLreServerAndTenant(pcServerName);
        pcServer = lreServerAndTenant[0];
        tenantSuffix = lreServerAndTenant[1];
    	domain = almDomain;
    	project = almProject;
    	webProtocol = webProtocolName;
    	baseURL = String.format(PC_API_RESOURCES_TEMPLATE, webProtocol,pcServer, domain, project);

    	PoolingClientConnectionManager cxMgr = new PoolingClientConnectionManager(SchemeRegistryFactory.createDefault());
    	cxMgr.setMaxTotal(100);
    	cxMgr.setDefaultMaxPerRoute(20);

    	
    	client = new DefaultHttpClient(cxMgr);
        if (proxyOutURL != null && !proxyOutURL.isEmpty()) {
            // Setting proxy
            // we should get the full proxy URL from the user: http(s)://<server>:<port>
            // PAC (proxy auto-config) or Automatic configuration script is not supported (for example our proxy: http://autocache.hpecorp.net/)
            getProxyDataFromURL(proxyOutURL);
            this.proxyUser = proxyUser;
            this.proxyPassword = proxyPassword;
            HttpHost proxy = new HttpHost(proxyHostName, proxyPort, proxyScheme);

            if (proxyUser != null && !proxyUser.isEmpty()) {
                Credentials credentials = new UsernamePasswordCredentials(proxyUser, proxyPassword);
                AuthScope authScope = new AuthScope(proxyHostName, proxyPort);
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                client.getCredentialsProvider().setCredentials(authScope, credentials);
            }
            client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

        }
    	context = new BasicHttpContext();
    	cookieStore = new BasicCookieStore();
    	context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
	}

    private void getProxyDataFromURL(String proxyURL) throws PcException {
        try {
            String mainStr = "";
            if (proxyURL != null && !proxyURL.isEmpty()){
                String[] urlSplit = proxyURL.split("://");

                proxyScheme = urlSplit[0];
                mainStr = urlSplit[1];
                if (mainStr.contains(":")){
                    proxyHostName = mainStr.split(":")[0];
                    proxyPort = Integer.parseInt(mainStr.split(":")[1]);
                }else{
                    proxyHostName = mainStr;
                    proxyPort = 80;
                }
            }
        } catch (Exception ex) {
            throw new PcException("Error: Validating Proxy URL: " + ex + " Please add a proxy URL in this pattern: http(s)://<host>:<port> or leave blank");
        }
    }

    public boolean authenticate(String userName, String password) throws PcException, ClientProtocolException, IOException {
        String userNameAndPassword = userName + ":" + password;
        String encodedCredentials = Base64Encoder.encode(userNameAndPassword.getBytes());
        HttpGet authRequest = new HttpGet(String.format(AUTHENTICATION_LOGIN_URL + tenantSuffix, webProtocol, pcServer));
        authRequest.addHeader("Authorization", String.format("Basic %s", encodedCredentials));
        executeRequest(authRequest);
        return true;
    }

    public PcRunResponse startRun(int testId, int testInstanceId, TimeslotDuration timeslotDuration,
                                  String postRunAction, boolean vudsMode) throws PcException, ClientProtocolException, IOException {
        HttpPost startRunRequest = new HttpPost(String.format(baseURL + "/%s", RUNS_RESOURCE_NAME));
        startRunRequest.addHeader(RESTConstants.CONTENT_TYPE, CONTENT_TYPE_XML);
        PcRunRequest runRequestData = new PcRunRequest(testId, testInstanceId, 0, timeslotDuration, postRunAction, vudsMode);
        startRunRequest.setEntity(new StringEntity(runRequestData.objectToXML(), org.apache.http.entity.ContentType.APPLICATION_XML));
        HttpResponse response = executeRequest(startRunRequest);
        String startRunResponse = IOUtils.toString(response.getEntity().getContent());
        return PcRunResponse.xmlToObject(startRunResponse);
    }

    public int createTestInstance(int testId, int testSetId) throws PcException, ClientProtocolException, IOException {
        HttpPost createTestInstanceRequest = new HttpPost(String.format(baseURL + "/%s", TEST_INSTANCES_NAME));
        TestInstanceCreateRequest testInstanceCreateRequest = new TestInstanceCreateRequest(testId,testSetId);
        createTestInstanceRequest.setEntity(new StringEntity(testInstanceCreateRequest.objectToXML(), org.apache.http.entity.ContentType.APPLICATION_XML));
        createTestInstanceRequest.addHeader(RESTConstants.CONTENT_TYPE, CONTENT_TYPE_XML);
        HttpResponse response = executeRequest(createTestInstanceRequest);
        String responseXml = IOUtils.toString(response.getEntity().getContent());
        int testInstanceID = 0;
        try {
            testInstanceID = testInstanceCreateRequest.getTestInstanceIDFromResponse(responseXml,"TestInstanceID");
        } catch (SAXException|ParserConfigurationException e) {
            throw new PcException("createTestInstance exception: " + e);
        }
        return testInstanceID;
    }

    public PcTestSets GetAllTestSets()throws IOException,PcException {
        String getTestSetsUrl = String.format(baseURL + "/%s", TEST_SETS_NAME);
        HttpGet getTestSetsRequest = new HttpGet(getTestSetsUrl);
        HttpResponse response = executeRequest(getTestSetsRequest);
        String testSets = IOUtils.toString(response.getEntity().getContent());
        return PcTestSets.xmlToObject(testSets);
    }

    public PcTestInstances getTestInstancesByTestId(int testId)throws PcException,IOException{
        String uri = String.format(baseURL + "/%s?%s=%s", TEST_INSTANCES_NAME,"query",URLEncoder.encode("{test-id[" + testId + "]}","UTF-8"));
        HttpGet getFirtstTestInstanceByTestID = new HttpGet(uri);
        HttpResponse response = executeRequest(getFirtstTestInstanceByTestID);
        String testInstances = IOUtils.toString(response.getEntity().getContent());
        return PcTestInstances.xmlToObject(testInstances);
    }

    public boolean stopRun(int runId, String stopMode) throws PcException, ClientProtocolException, IOException {
        String stopUrl = String.format(baseURL + "/%s/%s/%s", RUNS_RESOURCE_NAME, runId, stopMode);
        HttpPost stopRunRequest = new HttpPost(stopUrl);
        ReleaseTimeslot releaseTimesloteRequest = new ReleaseTimeslot(true, "Do Not Collate");
        stopRunRequest.addHeader(RESTConstants.CONTENT_TYPE, CONTENT_TYPE_XML);
        stopRunRequest.setEntity(new StringEntity(releaseTimesloteRequest.objectToXML(), org.apache.http.entity.ContentType.APPLICATION_XML));
        executeRequest(stopRunRequest);
        return true;
    }

    public PcRunResponse getRunData(int runId) throws PcException, ClientProtocolException, IOException {
        HttpGet getRunDataRequest = new HttpGet(String.format(baseURL + "/%s/%s", RUNS_RESOURCE_NAME, runId));
        HttpResponse response = executeRequest(getRunDataRequest);
        String runData = IOUtils.toString(response.getEntity().getContent());
        return PcRunResponse.xmlToObject(runData);
    }

    public PcTest getTestData(int testId) throws IOException, PcException {
        HttpGet getTestDataRequest = new HttpGet(String.format(baseURL + "/%s/%s",TESTS_RESOURCE_NAME,testId ));
        HttpResponse response = executeRequest(getTestDataRequest);
        String testData = IOUtils.toString(response.getEntity().getContent());
        return PcTestData.xmlToObject(testData);
    }

    public PcRunResults getRunResults(int runId) throws PcException, ClientProtocolException, IOException {
        String getRunResultsUrl = String
            .format(baseURL + "/%s/%s/%s", RUNS_RESOURCE_NAME, runId, RESULTS_RESOURCE_NAME);
        HttpGet getRunResultsRequest = new HttpGet(getRunResultsUrl);
        HttpResponse response = executeRequest(getRunResultsRequest);
        String runResults = IOUtils.toString(response.getEntity().getContent());
        return PcRunResults.xmlToObject(runResults);
    }

    public boolean GetRunResultData(int runId, int resultId, String localFilePath) throws PcException, ClientProtocolException, IOException {
        String getRunResultDataUrl = String.format(baseURL + "/%s/%s/%s/%s/data", RUNS_RESOURCE_NAME, runId,
                RESULTS_RESOURCE_NAME, resultId);
        HttpGet getRunResultRequest = new HttpGet(getRunResultDataUrl);
        HttpResponse response = executeRequest(getRunResultRequest);
        OutputStream out = new FileOutputStream(localFilePath);
        InputStream in = response.getEntity().getContent();
        IOUtils.copy(in, out);
        IOUtils.closeQuietly(in);
        IOUtils.closeQuietly(out);
        return true;
    }

    public TrendReportTransactionDataRoot getTrendReportByXML (String trendReportId, int runId) throws PcException, ClientProtocolException, IOException {
        String getTrendReportByXMLUrl = String.format(baseURL + "/%s/%s/%s", TREND_REPORT_RESOURCE_NAME, trendReportId,runId);
        HttpGet getTrendReportByXMLRequest = new HttpGet(getTrendReportByXMLUrl);
        HttpResponse response = executeRequest(getTrendReportByXMLRequest);
        String trendReportByXML = IOUtils.toString(response.getEntity().getContent(), CharEncoding.UTF_8);
        return TrendReportTransactionDataRoot.xmlToObject(trendReportByXML);
    }


    public boolean updateTrendReport(String trendReportId, TrendReportRequest trendReportRequest) throws PcException, IOException {
        String updateTrendReportUrl = String.format(baseURL + "/%s/%s", TREND_REPORT_RESOURCE_NAME, trendReportId);
        HttpPost updateTrendReportRequest = new HttpPost(updateTrendReportUrl);
        updateTrendReportRequest.addHeader(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_XML);
        updateTrendReportRequest.setEntity(new StringEntity(trendReportRequest.objectToXML(), org.apache.http.entity.ContentType.APPLICATION_XML));
        executeRequest(updateTrendReportRequest);
        return true;
    }

    public InputStream getTrendingPDF(String trendReportId) throws IOException, PcException {
        String getTrendReportUrl = String.format(baseURL + "/%s/%s/%s", TREND_REPORT_RESOURCE_NAME, trendReportId,TREND_REPORT_RESOURCE_SUFFIX);
        HttpGet getTrendReportRequest = new HttpGet(getTrendReportUrl);
        executeRequest(getTrendReportRequest);
        HttpResponse response = executeRequest(getTrendReportRequest);
        InputStream in = response.getEntity().getContent();
        return in;
    }

    public ArrayList<PcTrendedRun> getTrendReportMetaData (String trendReportId) throws PcException, ClientProtocolException, IOException {
        String getTrendReportMetaDataUrl = String.format(baseURL + "/%s/%s", TREND_REPORT_RESOURCE_NAME, trendReportId);
        HttpGet getTrendReportMetaDataRequest = new HttpGet(getTrendReportMetaDataUrl);
        HttpResponse response = executeRequest(getTrendReportMetaDataRequest);
        String trendReportMetaData = IOUtils.toString(response.getEntity().getContent());
        return PcTrendReportMetaData.xmlToObject(trendReportMetaData);
    }
    
    public PcRunEventLog getRunEventLog(int runId) throws PcException, ClientProtocolException, IOException {
        String getRunEventLogUrl = String
            .format(baseURL + "/%s/%s/%s", RUNS_RESOURCE_NAME, runId, EVENTLOG_RESOURCE_NAME);
        HttpGet getRunEventLogRequest = new HttpGet(getRunEventLogUrl);
        HttpResponse response = executeRequest(getRunEventLogRequest);
        String runEventLog = IOUtils.toString(response.getEntity().getContent());
        return PcRunEventLog.xmlToObject(runEventLog);
    }

    public boolean logout() throws PcException, ClientProtocolException, IOException {
        HttpGet logoutRequest = new HttpGet(String.format(AUTHENTICATION_LOGOUT_URL, webProtocol,pcServer));
        executeRequest(logoutRequest);
        return true;
    }

    protected HttpResponse executeRequest(HttpRequestBase request) throws PcException, IOException {
        HttpResponse response = client.execute(request, context);
			if (!isOk(response)){
				String message;
				try {
					String content = IOUtils.toString(response.getEntity().getContent());
					PcErrorResponse exception = PcErrorResponse.xmlToObject(content);
					message  = String.format("%s Error code: %s", exception.ExceptionMessage, exception.ErrorCode);
                } catch (Exception ex) {
					message = response.getStatusLine().toString();
				}
				throw new PcException("executeRequest exception: " + message);
			}  		
    		return response;           
    }

    public PcScripts getScripts() throws IOException,PcException{
        HttpGet getScriptsRequest = new HttpGet(String.format(baseURL + "/%s", SCRIPTS_RESOURCE_NAME));
        HttpResponse response = executeRequest(getScriptsRequest);
        String scripts = IOUtils.toString(response.getEntity().getContent());
        return PcScripts.xmlToObject(scripts);
    }

    public PcScript getScript(int Id) throws IOException,PcException{
        HttpGet getScriptsRequest = new HttpGet(String.format(baseURL + "/%s/%s", SCRIPTS_RESOURCE_NAME, Id));
        HttpResponse response = executeRequest(getScriptsRequest);
        String script = IOUtils.toString(response.getEntity().getContent());
        return PcScript.xmlToObject(script);
    }

    public PcScript getScript(String testFolderPath, String scriptName) throws IOException,PcException{
        List<PcScript> pcScriptList = getScripts().getPcScriptList();
        for (PcScript pcScript:pcScriptList
                ) {
            if(pcScript.getTestFolderPath().equalsIgnoreCase(testFolderPath) && pcScript.getName().equalsIgnoreCase(scriptName)) {
                return pcScript;
            }
        }
        throw new PcException(String.format("No script named '%s' was found under this folder path '%s' within the PC project.", scriptName, testFolderPath));
    }


    public int uploadScript(String testFolderPath, boolean Overwrite, boolean RuntimeOnly, boolean KeepCheckedOut, String scriptPath) throws PcException, ClientProtocolException, IOException {

        //trying to create Test Plan folder before uploading script
        createTestPlanFolder(testFolderPath);
        //uploading script
        HttpPost createScriptRequest = new HttpPost(String.format(baseURL + "/%s", SCRIPTS_RESOURCE_NAME));
        File fileToSend = new File(scriptPath);
        FileInputStream FileInputStreamToSend = new FileInputStream(fileToSend);
        ScriptCreateRequest scriptCreateRequest = new ScriptCreateRequest(testFolderPath,Overwrite, RuntimeOnly, KeepCheckedOut);
        MultipartEntity multipartEntity = new MultipartEntity();
        multipartEntity.addPart("File", new InputStreamBody(FileInputStreamToSend, fileToSend.getName()));
        multipartEntity.addPart("Text", new StringBody(scriptCreateRequest.objectToXML()));
        createScriptRequest.setEntity(multipartEntity);
        HttpResponse response = executeRequest(createScriptRequest);
        String responseXml = IOUtils.toString(response.getEntity().getContent());
        int scriptID = 0;
        try {
            scriptID = scriptCreateRequest.getScriptIdFromResponse(responseXml,"ID");
        } catch (SAXException|ParserConfigurationException e) {
            throw new PcException("uploadScript exception: " + e);
        }
        return scriptID;
    }

    public boolean deleteScript(int scriptId) throws PcException, ClientProtocolException, IOException {
        HttpDelete deleteRequest = new HttpDelete(String.format(baseURL + "/%s/%s", SCRIPTS_RESOURCE_NAME, scriptId));
        HttpResponse response = executeRequest(deleteRequest);
        return true;
    }

    public PcTestPlanFolders getTestPlanFolders() throws IOException,PcException{
        HttpGet getFolderTreeRequest = new HttpGet(String.format(baseURL + "/%s", TESTPLAN_RESOURCE_NAME));
        HttpResponse response = executeRequest(getFolderTreeRequest);
        String testPlan = IOUtils.toString(response.getEntity().getContent());
        return PcTestPlanFolders.xmlToObject(testPlan);
    }

    public boolean verifyTestPlanFolderExist (String path) throws IOException,PcException {
        PcTestPlanFolders pcTestPlanFolders = getTestPlanFolders();
        if (pcTestPlanFolders != null ) {
            for (PcTestPlanFolder pcTestPlanFolder : pcTestPlanFolders.getPcTestPlanFolderList()
                    ) {
                if (pcTestPlanFolder.getFullPath().equals(path))
                    return true;
            }
        }
        return false;
    }

    public PcTestPlanFolder createTestPlanFolder(String existingPath, String name) throws IOException,PcException{
        HttpPost createTestPlanFolderRequest = new HttpPost(String.format(baseURL + "/%s", TESTPLAN_RESOURCE_NAME));
        TestPlanFolderCreateRequest testPlanFolderCreateRequest = new TestPlanFolderCreateRequest(existingPath, name);
        createTestPlanFolderRequest.setEntity(new StringEntity(testPlanFolderCreateRequest.objectToXML(), org.apache.http.entity.ContentType.APPLICATION_XML));
        createTestPlanFolderRequest.addHeader(RESTConstants.CONTENT_TYPE, CONTENT_TYPE_XML);
        HttpResponse response = executeRequest(createTestPlanFolderRequest);
        String responseXml = IOUtils.toString(response.getEntity().getContent());
        PcTestPlanFolder pcTestPlanFolder;
        try {
            pcTestPlanFolder = testPlanFolderCreateRequest.getPcTestPlanFolderFromResponse(responseXml);
        } catch (SAXException|ParserConfigurationException e) {
            throw new PcException("createTestPlanFolder exception: " + e);
        }
        return pcTestPlanFolder;
    }

    public ArrayList<PcTestPlanFolder> createTestPlanFolders(String[] paths) throws IOException,PcException{
        ArrayList<String[]> pathFromSubjectAndFolders = Helper.getArrayListOfStringArray(paths);
        PcTestPlanFolders pcTestPlanFolders = getTestPlanFolders();
        ArrayList<String[]> pathFromSubjectAndFoldersFiltered = Helper.getCleanAndNonExistingAndSortedArrayList(pathFromSubjectAndFolders, pcTestPlanFolders);
        return createPcTestPlanFolders(pathFromSubjectAndFoldersFiltered);
    }

    public ArrayList<PcTestPlanFolder> createPcTestPlanFolders(ArrayList<String[]> stringsOfExistingPathFromSubjectAndOfFolderToCreate) throws IOException, PcException {
        //creating the items from ArrayList not existing in PC
        ArrayList<PcTestPlanFolder> createdPcTestPlanFolders = new ArrayList<PcTestPlanFolder>();
        if (stringsOfExistingPathFromSubjectAndOfFolderToCreate.size() > 0) {
            for (String[] pathFromSubjectAndFolder: stringsOfExistingPathFromSubjectAndOfFolderToCreate
                 ) {
                PcTestPlanFolder createdPcTestPlanFolder = createTestPlanFolder(pathFromSubjectAndFolder[0], pathFromSubjectAndFolder[1]);
                createdPcTestPlanFolders.add(createdPcTestPlanFolder);
            }
        }
        return createdPcTestPlanFolders;
    }

    public Test createOrUpdateTestFromYamlTest(String testString ) throws IOException, PcException {

        SimplifiedTest simplifiedTest = xmlOrYamlStringToSimplifiedTest(testString);
        return createOrUpdateTestFromYamlContent("", "", testString);
    }

    public Test createOrUpdateTestFromYamlContent(String testName, String testFolderPath, String testOrContent ) throws IOException, PcException {

        Test createdOrUpdatedTest = null;
        //region requirements
        /*
        Required Test Functionality
•	Should be supported
    o	Workload type
        	Basic schedule by test – number mode. The user should not specify the workload type in the XML
    o	Controller selection (optional field)
        	If field is added we should refer to the user selection. Possible values
            •	<Controller>Automatch</Controller>
            •	<Controller>Specific:machine_name_or_ip</Controller>
            •	<Controller>Docker:image_id</Controller> (memory and CPU will be set to default values)
        	If the field was not added to the XML PC should default to Automatch
    o	Load Generator assignment. The user should be able to choose one of the following options
        	The user should specify number of LGs and all of them will assigned to each group
            •	In such case the user should specify whether to use Automatch or Docker
        	The user should be able to specify which Load Generators are going to be assigned to which group. For example
            •	Group 1 <-> LG1, specific_lg_name_or_ip, DOCKER1
            •	Group 2 <-> LG2, DOCKER2
            •	Group 3 <-> DOCKER2
        	The user should also be able to specify number of LGs per group without specifying exact details for each group
            •	Group 1 <-> 3 LGs
            •	Group 2 <-> 5 LGs
        	If the user chose this option, we should allow specifying also whether the LGs are Automatch or Dockerized
        	The user should be able to specify the Docker image name and resource limits.  If not specified PC should use default values (if there are such)
    o	Vusers
        	User should be able to specify total number of Vusers and distribute equally among group
        	User should be able to specify the number of Vusers per group
    o	SimplifiedScheduler
        	Ramp up time (Start Vusers section). The user should specify the time. PC will calculate internally how to spread it. meaning how many Vusers every time
        	Duration
•	Should not be supported for the first version
    o	Test Options should not be exposed in the XML. The test creation should set default values.
    o	Trend settings. The test creation should set it to disable (default for new tests in PC)
    o	Workload Types
        	Goal oriented schedule
        	Basic scheduler by test percentage mode
        	Basic schedule by group
        	Real world by test (either by number or percentage)
        	Real world by group
    o	Load Generator assignment
        	Setting attributes, location and terminal services
    o	SimplifiedScheduler
        	Initialize: should not be exposed in the XML format. We should default to Initialize each Vuser just before it runs
        	Stop Vusers: should not be exposed in the XML format. We should default to Stop all Vusers simultaneously.
    o	Runtime settings should be taken from the script
    o	Command line. The workaround for the user is to define them in RTS > Additional Attributes
    o	Rendezvous
    o	NV
    o	SV
    o	Analysis Template
    o	SLA
    o	Monitors
    o	Topology
    o	Diagnostics
        */
        //endregion
        ConvertContentStringToTest convertContentStringToTest = new ConvertContentStringToTest(this, testName, testFolderPath, testOrContent).invoke();
        //creating or updating test
        try {
            createdOrUpdatedTest = createOrUpdateTest(convertContentStringToTest.getTestName(), convertContentStringToTest.getTestFolderPathWithSubject(), convertContentStringToTest.getContent());
        } catch (PcException ex) {
            throw ex;
        }
        return createdOrUpdatedTest;
    }

    public static Content getContentFromXmlOrYamlString(String xmlOrYamlTest) {
        Content content = null;
        try {
            Test test = Test.xmlToObject(xmlOrYamlTest);
            content = test.getContent();
        } catch (Exception ex) {
            content = Content.xmlToObject(xmlOrYamlTest);
        }
        return content;
    }

    public Test createOrUpdateTest(String testName, String testFolderPath, String xml) throws IOException, PcException  {
        String testFolderPathWithCorrectSeparatorsAndSubject = testFolderPath.replace("/","\\");
        if(!testFolderPath.startsWith("Subject"))
            testFolderPathWithCorrectSeparatorsAndSubject = "Subject\\".concat(testFolderPath);
        Content content = getContentFromXmlOrYamlString(xml);
        Test test = createOrUpdateTest(testName, testFolderPathWithCorrectSeparatorsAndSubject, content);
        return test;
    }

    public Test createOrUpdateTest(String testName, String testFolderPath, Content content ) throws IOException, PcException  {
        //trying to create Test Plan folder before creating the test
        createTestPlanFolder(testFolderPath);
        //try to create test
        try {
            HttpPost createTestRequest = new HttpPost(String.format(baseURL + "/%s", TESTS_RESOURCE_NAME));
            Test test = new Test(testName, testFolderPath, content);
            createTestRequest.setEntity(new StringEntity(test.objectToXML(), org.apache.http.entity.ContentType.APPLICATION_XML));
            HttpResponse response = executeRequest(createTestRequest);
            String createTestResponse =  IOUtils.toString(response.getEntity().getContent());
            return Test.xmlToObject(createTestResponse);
        } catch (PcException e) { //in case of failure, verify if exception return conflict with exiting test
            int testId = extractTestIdFromString(e.getMessage());
            if (testId != 0) //if exception returns conflict with existing test, get the testId from the exception and update it instead
                   return updateTest(testId, content);

            throw e;
        }
    }

    private void createTestPlanFolder(String testFolderPath) {
        try {
            if (!verifyTestPlanFolderExist(testFolderPath)) {
                String[] scriptPathArray = {testFolderPath};
                createTestPlanFolders(scriptPathArray);
            }
        } catch (PcException | IOException ex) {
            //Continuation should be allowed as exist verification and creation was introduced in PC12.60
        }
    }

    public Test getTest(int testId) throws IOException,PcException {
        HttpGet getTestRequest = new HttpGet(String.format(baseURL + "/%s/%s", TESTS_RESOURCE_NAME, testId));
        HttpResponse response = executeRequest(getTestRequest);
        String xmlTest = IOUtils.toString(response.getEntity().getContent());
        return Test.xmlToObject(xmlTest);
    }

    public Test updateTest(int testId, Content content ) throws IOException, PcException  {
        HttpPut updateTestRequest = new HttpPut(String.format(baseURL + "/%s/%s", TESTS_RESOURCE_NAME, testId));
        updateTestRequest.setEntity(new StringEntity(content.objectToXML(true), org.apache.http.entity.ContentType.APPLICATION_XML));
        HttpResponse response = executeRequest(updateTestRequest);
        Test updatedTest = getTest(testId);
        return updatedTest;
    }

    public boolean deleteTest(int testId) throws IOException, PcException  {
        HttpDelete deleteTestRequest = new HttpDelete(String.format(baseURL + "/%s/%s", TESTS_RESOURCE_NAME, testId));
        HttpResponse response = executeRequest(deleteTestRequest);
        return true;
    }

	public static boolean isOk (HttpResponse response) {
	    return validStatusCodes.contains(response.getStatusLine().getStatusCode());
	}
	
    protected String getBaseURL() {
        return baseURL;
    }

    public int extractTestIdFromString(String value) {
        return Helper.extractTestIdFromString(value);
    }

    public Content readYaml(String yamlContent) throws IOException {
        Content content = null;
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory()); // jackson databind
        try {
            Test test = mapper.readValue(yamlContent, Test.class);
            content = test.getContent();
        } catch (IOException ex1) {
            try {
                content = mapper.readValue(yamlContent, Content.class);
            } catch (IOException ex2) {
                throw ex2;
            }
        }
        return content;
    }

    public static SimplifiedContent xmlOrYamlStringToSimplifiedContent(String strSimplifiedContent) throws IOException  {
        if(strSimplifiedContent == null || strSimplifiedContent.isEmpty())
            return null;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        SimplifiedContent simplifiedContent;
        try {
            simplifiedContent = mapper.readValue(strSimplifiedContent, SimplifiedContent.class);
        } catch (Exception ex1) {
            try {
                simplifiedContent = SimplifiedContent.xmlToObject(strSimplifiedContent);
            } catch (Exception ex2) {
                throw ex1;
            }
        }
        return simplifiedContent;
    }

    public static SimplifiedTest xmlOrYamlStringToSimplifiedTest(String strSimplifiedTest) throws IOException {
        if(strSimplifiedTest == null || strSimplifiedTest.isEmpty())
            return null;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        SimplifiedTest simplifiedTest;
        try {
            simplifiedTest = mapper.readValue(strSimplifiedTest, SimplifiedTest.class);
        } catch (Exception ex1) {
            try {
                simplifiedTest = SimplifiedTest.xmlToObject(strSimplifiedTest);
            } catch (Exception ex2) {
                throw ex1;
            }
        }
        return simplifiedTest;
    }
    //endregion

}
