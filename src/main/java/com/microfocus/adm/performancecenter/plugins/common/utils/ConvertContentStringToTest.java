package com.microfocus.adm.performancecenter.plugins.common.utils;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcException;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcScript;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.analysistemplate.AnalysisTemplate;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.automatictrending.AutomaticTrending;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.Diagnostics;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.GlobalCommandLine;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalrts.GlobalRTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.Group;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.host.Host;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.RTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.JavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter.JMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.Pacing;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime.ThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.script.Script;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.lgdistribution.LGDistribution;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorprofiles.MonitorProfile;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorsofw.MonitorOFW;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.Scheduler;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.Action;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.Ramp;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.TimeInterval;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.duration.Duration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.initialize.Initialize;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers.StartVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.stopvusers.StopVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.SLA;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.workloadtype.WorkloadType;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.*;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.SimplifiedTest;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.SimplifiedContent;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConvertContentStringToTest {
    private PcRestProxy pcRestProxy;
    private String testName;
    private String testFolderPath;
    private String testFolderPathWithSubject;
    private String testOrContent;
    private Content content;

    public ConvertContentStringToTest(PcRestProxy pcRestProxy, String testName, String testFolderPath, String testOrContent) {
        this.pcRestProxy = pcRestProxy;
        this.testName = testName;
        this.testFolderPath = testFolderPath;
        this.testOrContent = testOrContent;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestFolderPath() {
        return testFolderPath;
    }

    public String getTestFolderPathWithSubject() {
        return testFolderPathWithSubject;
    }

    public Content getContent() {
        return content;
    }

    public ConvertContentStringToTest invoke() throws IOException, PcException {

        //region create simplifiedContent
        SimplifiedContent simplifiedContent = getSimplifiedContent();
        //endregion

        //region Controller
        String controller = getController(simplifiedContent);
        //endregion

        //region WorkloadType
        WorkloadType workloadType = getWorkloadType();
        //endregion

        //region LGDistribution
        LGDistribution lgDistribution = getLgDistribution(simplifiedContent);
        //endregion

        //region MonitorProfiles
        ArrayList<MonitorProfile> monitorProfiles = null;
        //endregion

        //region Groups
        //handle situation in which script fullname is provided instead of script id
        // (retrieve script id from script fullname and update provided object)
        ArrayList<Group> recievedGroups = getGroups(getSimplifiedGroups(simplifiedContent), lgDistribution);
        //endregion

        //region Scheduler
        Scheduler scheduler = getScheduler(simplifiedContent);
        //endregion

        //region AnalysisTemplate
        AnalysisTemplate analysisTemplate = null;
        //endregion

        //region AutomaticTrending
        AutomaticTrending automaticTrending = null;
        //endregion

        //region MonitorsOFW
        ArrayList<MonitorOFW> monitorsOFW = null;
        //endregion

        //region SLA
        //SLA => defect: cannot create test without SLA

        SLA sla = null;
//        int percentile = 0;
//        String transactionName = "Lib-View_Transaction";
//        int threshold = 0;
//        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
//        Transaction transaction = new Transaction(transactionName, threshold);
//        TransactionResponseTimePercentile transactionResponseTimePercentile = new TransactionResponseTimePercentile(transactions, percentile);
//        SLA sla = new SLA(null, null, transactionResponseTimePercentile, null, null, null, null);
        //endregion

        //region Diagnostics
        Diagnostics diagnostics = null;
        //endregion

        //region GlobalCommandLine
        GlobalCommandLine globalCommandLine = null;
        //endregion

        //region GlobalRTS
        GlobalRTS globalRTS = null;
        //endregion

        //region default and given values assigned to objects
        content = new Content(controller, workloadType, lgDistribution, monitorProfiles, recievedGroups, scheduler,
                analysisTemplate, automaticTrending, monitorsOFW, sla, diagnostics, globalCommandLine, globalRTS);
        //endregion
        return this;
    }

    private SimplifiedContent getSimplifiedContent() throws IOException {

        SimplifiedContent simplifiedContent;

        if(testName.isEmpty() && testFolderPath.isEmpty()) {
            SimplifiedTest simplifiedTest = PcRestProxy.yamlStringToSimplifiedTest(testOrContent);
            simplifiedContent = simplifiedTest.getTest_content();
            testName = simplifiedTest.getTest_name();
            testFolderPath = simplifiedTest.getTest_folder_path();
        } else {
            simplifiedContent = PcRestProxy.yamlStringToSimplifiedContent(testOrContent);
        }

        //in case testFolderPath contains forward slash as delimiter
        testFolderPathWithSubject = verifyTestFolderPath(testFolderPath);
        return simplifiedContent;
    }

    private List<SimplifiedGroup> getSimplifiedGroups(SimplifiedContent simplifiedContent) throws IOException, PcException {
        List<SimplifiedGroup> simplifiedGroups = simplifiedContent.getGroups();
        for (SimplifiedGroup simplifiedGroup: simplifiedGroups
             ) {
            if(simplifiedGroup.getScript_id() == 0 && !simplifiedGroup.getScript_path().isEmpty()) { //retreiving the script ID + protocol from script name and script folder
                File file = new File("Subject\\".concat(simplifiedGroup.getScript_path()));
                PcScript pcScript = pcRestProxy.getScript(file.getParent().toString(), file.getName());
                simplifiedGroup.setScript_id(pcScript.getID());
                simplifiedGroup.setProtocol(pcScript.getProtocol());
                simplifiedContent.setGroups(simplifiedGroups);
            } else if(simplifiedGroup.getScript_id() > 0) { // retrieving protocol of script
                PcScript pcScript = pcRestProxy.getScript(simplifiedGroup.getScript_id());
                simplifiedGroup.setProtocol(pcScript.getProtocol());
                simplifiedContent.setGroups(simplifiedGroups);
            }
        }
        return simplifiedGroups;
    }

    private Scheduler getScheduler(SimplifiedContent simplifiedContent) {
        ArrayList<Action> actions = new ArrayList<Action>();

        //initialized is unchanged
        Initialize initialize = new Initialize();

        //StartVusers does change if rampuptimeinseconds was provided
        //StartVusers startVusers = new StartVusers();
        StartVusers startVusers = getStartVusersSchedulerByTest(simplifiedContent);

        //Duration does change if durationinseconds was provided
        Duration duration = new Duration();
        if(simplifiedContent.getScheduler().getDuration_seconds() > 0) {
            TimeInterval timeInterval = getTimeInterval(simplifiedContent.getScheduler().getDuration_seconds());
            duration = new Duration(DurationTypeValues.RUN_FOR, timeInterval);
        }

        //StopVusers
        StopVusers stopVusers = new StopVusers();

        actions.add(new Action(initialize));
        actions.add(new Action(startVusers));
        actions.add(new Action(duration));
        actions.add(new Action(stopVusers));

        return new Scheduler(actions);
    }

    //using 15 seconds interval
    private StartVusers getStartVusersSchedulerByTest(SimplifiedContent simplifiedContent) {
        StartVusers startVusers;
        if(simplifiedContent.getScheduler().getRampup_seconds() > 30 ) {
            int vusersSum = simplifiedContent.getGroups().stream().filter(o -> o.getVusers() > 0).mapToInt(o -> o.getVusers()).sum();
            double exactTimeIntervalInSecondsPerUser = ((double) simplifiedContent.getScheduler().getRampup_seconds()) / ((double) vusersSum);
            int vusers = 1;
            int timeIntervalInSeconds = (int) exactTimeIntervalInSecondsPerUser;
            if(exactTimeIntervalInSecondsPerUser < 15 && exactTimeIntervalInSecondsPerUser > 0) {
                vusers = (int) (((double) 15) / exactTimeIntervalInSecondsPerUser) + 1;
                timeIntervalInSeconds = 15;
            }
            TimeInterval timeInterval = getTimeInterval(timeIntervalInSeconds);
            Ramp ramp = new Ramp(vusers, timeInterval);
            startVusers = new StartVusers(StartStopVusersTypeValues.GRADUALLY, ramp);
        } else if(simplifiedContent.getScheduler().getRampup_seconds() > 1 ){
            int vusersSum = simplifiedContent.getGroups().stream().filter(o -> o.getVusers() > 0).mapToInt(o -> o.getVusers()).sum();
            int timeIntervalInSeconds = simplifiedContent.getScheduler().getRampup_seconds() / 2;
            int vusers = (vusersSum /2) + (((vusersSum % 2)==0)?0:1);
            TimeInterval timeInterval = getTimeInterval(timeIntervalInSeconds);
            Ramp ramp = new Ramp(vusers, timeInterval);
            startVusers = new StartVusers(StartStopVusersTypeValues.GRADUALLY, ramp);
        }
        else
            startVusers = new StartVusers();

        return startVusers;
    }

    private ArrayList<Group> getGroups(List<SimplifiedGroup> simplifiedGroups, LGDistribution lgDistribution) {
        ArrayList<Group> recievedGroups = new ArrayList<Group>();

        {
            for (SimplifiedGroup simplifiedGroup:simplifiedGroups
                 ) {

                String groupName = simplifiedGroup.getGroup_name();
                int groupVusers = simplifiedGroup.getVusers() > 0 ? simplifiedGroup.getVusers() : 1;
                Script groupScript = new Script(simplifiedGroup.getScript_id());

                //region RTS


                //Pacing
                int numberOfIterations = 1;
                StartNewIteration startNewIteration = new StartNewIteration(StartNewIterationTypeValues.IMMEDIATELY);
                Pacing pacing = null;

                //Log
                Log log = null;

                //JMeter
                JMeter jMeter = null;

                //LhinkTime
                ThinkTime thinkTime = null;

                //JavaVM
                JavaVM javaVM = null;

                //assigigin value accordind to script protocol: only jmeter is taken in consideration.
                //java protocol cannot currently be supported as it requires too many parameters
                if(!"jmeter".equalsIgnoreCase(simplifiedGroup.getProtocol())) {
                    pacing = new Pacing(numberOfIterations, startNewIteration);
                    thinkTime = new ThinkTime();
                    log = new Log();
                } else
                    jMeter = new JMeter();

                RTS groupRTS = new RTS(pacing, thinkTime, log, jMeter, javaVM);
                //endregion

                //Hosts
                ArrayList<Host> groupHosts = new ArrayList<Host>();
                if(lgDistribution.getType()== LGDistributionTypeValues.MANUAL.value()) {
                    for (String lgHost : simplifiedGroup.getLg_name()
                            ) {
                        if(lgHost.startsWith("LG") && Character.isDigit(lgHost.charAt(lgHost.length()-1)))
                            groupHosts.add(new Host(lgHost, HostTypeValues.AUTOMATCH));
                        else if(lgHost.startsWith("DOCKER") && Character.isDigit(lgHost.charAt(lgHost.length()-1)))
                            groupHosts.add(new Host(lgHost, HostTypeValues.DYNAMIC));
                        else
                            groupHosts.add(new Host(lgHost, HostTypeValues.SPECIFIC));
                    }
                } else {
                    groupHosts = null;
                }

                Group group = new Group(groupName, groupVusers, groupScript, groupHosts, groupRTS, null, null);
                recievedGroups.add(group);
            }
        }
        return recievedGroups;
    }

    private LGDistribution getLgDistribution(SimplifiedContent simplifiedContent) {
        LGDistributionTypeValues lgDistributionTypeValues = LGDistributionTypeValues.ALL_TO_EACH_GROUP;
        boolean isLGHostDefinedInGroups =  simplifiedContent.getGroups().stream().filter(o -> o.getLg_name() != null && o.getLg_name().length > 0).count() == simplifiedContent.getGroups().size();

        if(simplifiedContent.getLg_amount() == 0 && isLGHostDefinedInGroups)
            lgDistributionTypeValues = LGDistributionTypeValues.MANUAL;
        else if (simplifiedContent.getLg_amount() == 0 )
            simplifiedContent.setLg_amount(1);

        LGDistribution lgDistribution = new LGDistribution(lgDistributionTypeValues);
        lgDistribution.setType(lgDistributionTypeValues);
        if(lgDistributionTypeValues==LGDistributionTypeValues.ALL_TO_EACH_GROUP)
            lgDistribution.setAmount(simplifiedContent.getLg_amount());
        return lgDistribution;
    }

    private WorkloadType getWorkloadType() {
        return new WorkloadType(WorkloadTypeValues.BASIC, VusersDistributionModeValues.BY_NUMBER, WorkloadTypeSubTypeValues.BY_TEST);
    }

    private String getController(SimplifiedContent simplifiedContent) {
        String controller = null;
        if(simplifiedContent.getController() != null && !simplifiedContent.getController().isEmpty())
            controller = simplifiedContent.getController();
        return controller;

    }

    private String verifyTestFolderPath (String testFolderPath) {
        String testFolderPathWithSubject = "Subject\\".concat(testFolderPath);
        return testFolderPathWithSubject.replace("/", "\\");
    }

    private TimeInterval getTimeInterval(int timeIntervalInSeconds) {
        int day = (int) TimeUnit.SECONDS.toDays(timeIntervalInSeconds);
        long hours = TimeUnit.SECONDS.toHours(timeIntervalInSeconds) - (day *24);
        long minute = TimeUnit.SECONDS.toMinutes(timeIntervalInSeconds) - (TimeUnit.SECONDS.toHours(timeIntervalInSeconds)* 60);
        long second = TimeUnit.SECONDS.toSeconds(timeIntervalInSeconds) - (TimeUnit.SECONDS.toMinutes(timeIntervalInSeconds) *60);

        return new TimeInterval(day, Math.toIntExact(hours), Math.toIntExact(minute), Math.toIntExact(second));
    }
}
