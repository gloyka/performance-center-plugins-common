/**
 * Copyright © 2023 Open Text Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microfocus.adm.performancecenter.plugins.common.utils;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcException;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcScript;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.analysistemplate.AnalysisTemplate;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.automatictrending.AutomaticTrending;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.Diagnostics;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticcontrollerconfiguration.ElasticControllerConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticloadgeneratorconfiguration.ElasticLoadGeneratorConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.GlobalCommandLine;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.commandline.CommandLine;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalrts.GlobalRTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.Group;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.host.Host;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.RTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.JavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter.JMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.Pacing;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.selenium.Selenium;
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
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.automatictrending.SimplifiedAutomaticTrending;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.elasticconfiguration.SimplifiedElasticConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.javavm.SimplifiedJavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.jmeter.SimplifiedJMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.pacing.SimplifiedPacing;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.selenium.SimplifiedSelenium;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.thinktime.SimplifiedThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConvertContentStringToTest {
    private static final int MIN_INTERVAL_TIME = 1;
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
        //region create simplifiedContent
        simplifiedContent = verifyAndFixSimplifiedContent(simplifiedContent);
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
        //region SimplifiedScheduler
        Scheduler scheduler = getScheduler(simplifiedContent);
        //endregion
        //region AnalysisTemplate
        AnalysisTemplate analysisTemplate = null;
        //endregion
        //region AutomaticTrending
        AutomaticTrending automaticTrending = getAutomaticTrending(simplifiedContent);
        //endregion
        //region MonitorsOFW
        ArrayList<MonitorOFW> monitorsOFW = null;
        //endregion
        //region ElasticLoadGeneratorConfiguration
        ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration = getElasticLoadGeneratorConfiguration(simplifiedContent);
        //endregion
        //region ElasticControllerConfiguration
        ElasticControllerConfiguration elasticControllerConfiguration = getElasticControllerConfiguration(simplifiedContent);
        //endregion
        //region SLA
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
        GlobalCommandLine globalCommandLine = getGlobalCommandLine(simplifiedContent);
        //endregion
        //region GlobalRTS
        GlobalRTS globalRTS = null;
        //endregion
        //region Groups
        //handle situation in which script fullname is provided instead of script id
        // (retrieve script id from script fullname and update provided object)
        ArrayList<Group> receivedGroups = getGroups(simplifiedContent.getGroup(), lgDistribution);
        //endregion
        //region default and given values assigned to objects
        content = new Content(controller, workloadType, lgDistribution, monitorProfiles, receivedGroups, scheduler,
                analysisTemplate, automaticTrending, monitorsOFW, sla, diagnostics, globalCommandLine,
                globalRTS, elasticLoadGeneratorConfiguration, elasticControllerConfiguration);
        //endregion
        return this;
    }

    private SimplifiedContent verifyAndFixSimplifiedContent(SimplifiedContent simplifiedContent) throws IOException, PcException {
        simplifiedContent.setGroup(getSimplifiedGroups(simplifiedContent));
        return simplifiedContent;
    }

    private GlobalCommandLine getGlobalCommandLine(SimplifiedContent simplifiedContent) {
        List<SimplifiedGroup> simplifiedGroups = simplifiedContent.getGroup();
        ArrayList<CommandLine> commandLines = new ArrayList<CommandLine>();
        for (SimplifiedGroup simplifiedGroup : simplifiedGroups
        ) {
            if (simplifiedGroup.getCommand_line() != null && !simplifiedGroup.getCommand_line().isEmpty()) {
                commandLines.add(new CommandLine(simplifiedGroup.getGroup_name(), simplifiedGroup.getCommand_line()));
            }
        }
        if (commandLines.size() > 0)
            return new GlobalCommandLine(commandLines);
        return null;
    }

    private SimplifiedContent getSimplifiedContent() throws IOException {
        SimplifiedContent simplifiedContent;
        if (testName.isEmpty() && testFolderPath.isEmpty()) {
            SimplifiedTest simplifiedTest = PcRestProxy.xmlOrYamlStringToSimplifiedTest(testOrContent);
            simplifiedContent = simplifiedTest.getTest_content();
            testName = simplifiedTest.getTest_name();
            testFolderPath = simplifiedTest.getTest_folder_path();
        } else {
            simplifiedContent = PcRestProxy.xmlOrYamlStringToSimplifiedContent(testOrContent);
        }
        //in case testFolderPath contains forward slash as delimiter
        testFolderPathWithSubject = verifyTestFolderPath(testFolderPath);
        return simplifiedContent;
    }

    private List<SimplifiedGroup> getSimplifiedGroups(SimplifiedContent simplifiedContent) throws IOException, PcException {
        List<SimplifiedGroup> simplifiedGroups = simplifiedContent.getGroup();
        int i = 0;

        ScriptCache scriptCache = null; // lazy-init only if needed

        for (SimplifiedGroup simplifiedGroup : simplifiedGroups) {
            i++;
            PcScript pcScript = null;

            if (simplifiedGroup.getScript_id() == 0 && !simplifiedGroup.getScript_path().isEmpty()) {
                // Lazily create scriptCache on first usage
                if (scriptCache == null) {
                    List<PcScript> allScripts = pcRestProxy.getScripts().getPcScriptList();
                    scriptCache = new ScriptCache(allScripts);
                }

                File file = new File("Subject\\".concat(simplifiedGroup.getScript_path()));
                String testFolderPath = Helper.getParent(file.toPath()).toString();
                String scriptName = Helper.getName(file.getName());

                pcScript = scriptCache.getScript(testFolderPath, scriptName); // fast lookup by name
                simplifiedGroup.setScript_id(pcScript.getID());
                simplifiedGroup.setProtocol(pcScript.getProtocol());
                simplifiedContent.setGroup(simplifiedGroups);
            } else if (simplifiedGroup.getScript_id() > 0) {
                pcScript = pcRestProxy.getScript(simplifiedGroup.getScript_id());
                simplifiedGroup.setProtocol(pcScript.getProtocol());
                simplifiedGroup.setScript_path(pcScript.getTestFolderPath());
                simplifiedContent.setGroup(simplifiedGroups);
            }

            if (simplifiedGroup.getGroup_name() == null || simplifiedGroup.getGroup_name().isEmpty()) {
                simplifiedGroup.setGroup_name(pcScript.getName().concat("_").concat(Integer.toString(i)));
            }
        }

        return simplifiedGroups;
    }

    private Scheduler getScheduler(SimplifiedContent simplifiedContent) {
        ArrayList<Action> actions = new ArrayList<Action>();
        //initialized is unchanged
        Initialize initialize;
        if (simplifiedContent.getScheduler().getInit_type() != null && simplifiedContent.getScheduler().getInit_type().equalsIgnoreCase(InitializeTypeValues.SIMULTANEOUSLY.value())) {
            TimeInterval waitAfterInit = new TimeInterval(0, 0, 0);
            initialize = new Initialize(InitializeTypeValues.SIMULTANEOUSLY, -1, null, waitAfterInit);
        } else {
            initialize = new Initialize();
        }

        //StartVusers does change if rampup was provided
        //StartVusers startVusers = new StartVusers();
        StartVusers startVusers = getStartVusersSchedulerByTest(simplifiedContent);
        //Duration does change if duration was provided
        Duration duration = new Duration();
        if (simplifiedContent.getScheduler().getDuration() > 0) {
            TimeInterval timeInterval = getTimeInterval(simplifiedContent.getScheduler().getDuration());
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

    private ElasticLoadGeneratorConfiguration getElasticLoadGeneratorConfiguration(SimplifiedContent simplifiedContent) {
        SimplifiedElasticConfiguration simplifiedElasticConfiguration = simplifiedContent.getLg_elastic_configuration();
        ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration = null;
        if (simplifiedElasticConfiguration != null && simplifiedElasticConfiguration.getImage_id() != 0) {
            elasticLoadGeneratorConfiguration = new ElasticLoadGeneratorConfiguration(simplifiedElasticConfiguration.getImage_id(), simplifiedElasticConfiguration.getMemory_limit(), simplifiedElasticConfiguration.getCpu_limit());
        }
        return elasticLoadGeneratorConfiguration;
    }

    private ElasticControllerConfiguration getElasticControllerConfiguration(SimplifiedContent simplifiedContent) {
        SimplifiedElasticConfiguration simplifiedElasticConfiguration = simplifiedContent.getController_elastic_configuration();
        ElasticControllerConfiguration elasticControllerConfiguration = null;
        if (simplifiedElasticConfiguration != null && simplifiedElasticConfiguration.getImage_id() != 0) {
            elasticControllerConfiguration = new ElasticControllerConfiguration(simplifiedElasticConfiguration.getImage_id(), simplifiedElasticConfiguration.getMemory_limit(), simplifiedElasticConfiguration.getCpu_limit());
        }
        return elasticControllerConfiguration;
    }

    private AutomaticTrending getAutomaticTrending(SimplifiedContent simplifiedContent) {
        SimplifiedAutomaticTrending simplifiedAutomaticTrending = simplifiedContent.getAutomatic_trending();
        AutomaticTrending automaticTrending = null;
        if (simplifiedAutomaticTrending != null) {
            automaticTrending = new AutomaticTrending(simplifiedAutomaticTrending.getReport_id(), simplifiedAutomaticTrending.getMax_runs_in_report());
        }
        return automaticTrending;
    }

    //using 15 seconds interval
    private StartVusers getStartVusersSchedulerByTest(SimplifiedContent simplifiedContent) {
        StartVusers startVusers;
        if (simplifiedContent.getScheduler().getRampup() > MIN_INTERVAL_TIME) {
            int vusersSum = simplifiedContent.getGroup().stream().filter(o -> o.getVusers() > 0).mapToInt(o -> o.getVusers()).sum();

            double exactTimeIntervalInSecondsPerUser = ((double) simplifiedContent.getScheduler().getRampup()) / ((double) vusersSum);
            int vusers = 1;
            int timeIntervalInSeconds = (int) exactTimeIntervalInSecondsPerUser;
            if (exactTimeIntervalInSecondsPerUser < MIN_INTERVAL_TIME && exactTimeIntervalInSecondsPerUser > 0) {
                vusers = (int) (((double) MIN_INTERVAL_TIME) / exactTimeIntervalInSecondsPerUser) + ((((double) MIN_INTERVAL_TIME) % exactTimeIntervalInSecondsPerUser) == 0 ? 0 : 1);
                timeIntervalInSeconds = MIN_INTERVAL_TIME;
            }
            TimeInterval timeInterval = getTimeInterval(timeIntervalInSeconds);
            Ramp ramp = new Ramp(vusers, timeInterval);
            startVusers = new StartVusers(StartStopVusersTypeValues.GRADUALLY, ramp);
        } else
            startVusers = new StartVusers();
        return startVusers;
    }

    private ArrayList<Group> getGroups(List<SimplifiedGroup> simplifiedGroups, LGDistribution lgDistribution) {
        ArrayList<Group> receivedGroups = new ArrayList<Group>();
        {
            for (SimplifiedGroup simplifiedGroup : simplifiedGroups
            ) {
                String groupName = simplifiedGroup.getGroup_name();
                int groupVusers = simplifiedGroup.getVusers() > 0 ? simplifiedGroup.getVusers() : 1;
                Script groupScript = new Script(simplifiedGroup.getScript_id());
                //region RTS
                RTS groupRTS = defineRTS(simplifiedGroup);
                //endregion
                //region GlobalCommandLine
                String globalCommandLine = defineGlobalCommandLine(simplifiedGroup);
                //endregion
                //region Hosts
                ArrayList<Host> groupHosts = defineGroupHosts(lgDistribution, simplifiedGroup);
                //endregion
                Group group = new Group(groupName, groupVusers, groupScript, groupHosts, groupRTS, globalCommandLine, null, null);
                receivedGroups.add(group);
            }
        }
        return receivedGroups;
    }

    private RTS defineRTS(SimplifiedGroup simplifiedGroup) {
        Pacing pacing = null;
        JavaVM javaVM = null;
        Log log = null;
        JMeter jMeter = null;
        ThinkTime thinkTime = null;
        Selenium selenium = null;
        if (simplifiedGroup.getRts() != null) {
            //region pacing
            pacing = definePacing(simplifiedGroup);
            //endregion
            //region JavaVM
            javaVM = defineJavaVM(simplifiedGroup);
            //endregion
            //region ThinkTime
            thinkTime = defineThinkTime(simplifiedGroup);
            //endregion
            //region JMeter
            jMeter = defineJMeter(simplifiedGroup);
            //endregion
            //region Selenium
            selenium = defineSelenium(simplifiedGroup);
            //endregion
        }
        return new RTS(pacing, thinkTime, log, jMeter, javaVM, selenium);
    }

    private String defineGlobalCommandLine(SimplifiedGroup simplifiedGroup) {
        String globalCommandLine = null;
        if (simplifiedGroup.getCommand_line() != null && !simplifiedGroup.getCommand_line().isEmpty()) {
            globalCommandLine = simplifiedGroup.getGroup_name();
        }
        return globalCommandLine;
    }

    private ArrayList<Host> defineGroupHosts(LGDistribution lgDistribution, SimplifiedGroup simplifiedGroup) {
        ArrayList<Host> groupHosts = new ArrayList<Host>();
        if (lgDistribution.getType() == LGDistributionTypeValues.MANUAL.value()) {
            for (String lgHost : simplifiedGroup.getLg_name()
            ) {
                if (lgHost.startsWith("LG") && Character.isDigit(lgHost.charAt(lgHost.length() - 1)))
                    groupHosts.add(new Host(lgHost, HostTypeValues.AUTOMATCH));
                else if (lgHost.startsWith("DOCKER") && Character.isDigit(lgHost.charAt(lgHost.length() - 1)))
                    groupHosts.add(new Host(lgHost, HostTypeValues.DYNAMIC));
                else
                    groupHosts.add(new Host(lgHost, HostTypeValues.SPECIFIC));
            }
        } else {
            groupHosts = null;
        }
        return groupHosts;
    }

    private Pacing definePacing(SimplifiedGroup simplifiedGroup) {
        SimplifiedPacing simplifiedPacing = simplifiedGroup.getRts().getPacing();
        if (simplifiedPacing != null && simplifiedPacing.getNumber_of_iterations() > 0) {
            StartNewIteration startNewIteration = new StartNewIteration();
            if (simplifiedPacing.getType() != null && !simplifiedPacing.getType().isEmpty() && simplifiedPacing.getDelay() > 0) {
                if (simplifiedPacing.getType().equalsIgnoreCase(StartNewIterationTypeValues.FIXED_DELAY.value()) || simplifiedPacing.getType().equalsIgnoreCase(StartNewIterationTypeValues.FIXED_INTERVAL.value()))
                    startNewIteration = new StartNewIteration(simplifiedPacing.getType().equalsIgnoreCase(StartNewIterationTypeValues.FIXED_DELAY.value()) ? StartNewIterationTypeValues.FIXED_DELAY.value() : StartNewIterationTypeValues.FIXED_INTERVAL.value(), simplifiedPacing.getDelay(), -1, -1);
                if ((simplifiedPacing.getType().equalsIgnoreCase(StartNewIterationTypeValues.RANDOM_DELAY.value()) || simplifiedPacing.getType().equalsIgnoreCase(StartNewIterationTypeValues.RANDOM_INTERVAL.value()))
                        && simplifiedPacing.getDelay_random_range() > 0)
                    startNewIteration = new StartNewIteration(simplifiedPacing.getType().equalsIgnoreCase(StartNewIterationTypeValues.RANDOM_DELAY.value()) ? StartNewIterationTypeValues.RANDOM_DELAY.value() : StartNewIterationTypeValues.RANDOM_INTERVAL.value(), -1, simplifiedPacing.getDelay(), simplifiedPacing.getDelay() + simplifiedPacing.getDelay_random_range());
            }
            return new Pacing(simplifiedPacing.getNumber_of_iterations(), startNewIteration);
        }
        return null;
    }

    private JMeter defineJMeter(SimplifiedGroup simplifiedGroup) {
        SimplifiedJMeter simplifiedJMeter = simplifiedGroup.getRts().getJmeter();
        if (simplifiedJMeter != null) {
            boolean useJMeterAdditionalProperties = simplifiedJMeter.getJmeter_additional_properties() != null && !simplifiedJMeter.getJmeter_additional_properties().isEmpty();
            return new JMeter(simplifiedJMeter.isStart_measurements(),
                    simplifiedJMeter.getJmeter_home_path(),
                    !(simplifiedJMeter.getJmeter_min_port() > 0 && simplifiedJMeter.getJmeter_max_port() > simplifiedJMeter.getJmeter_min_port()),
                    simplifiedJMeter.getJmeter_min_port(),
                    simplifiedJMeter.getJmeter_max_port(),
                    useJMeterAdditionalProperties,
                    useJMeterAdditionalProperties ? simplifiedJMeter.getJmeter_additional_properties() : null);
        }
        return null;
    }

    private Selenium defineSelenium(SimplifiedGroup simplifiedGroup) {
        SimplifiedSelenium simplifiedSelenium = simplifiedGroup.getRts().getSelenium();
        if (simplifiedSelenium != null) {
            return new Selenium(simplifiedSelenium.getJre_path(),
                    simplifiedSelenium.getClass_path(),
                    simplifiedSelenium.getTest_ng_files());
        }
        return null;
    }

    private ThinkTime defineThinkTime(SimplifiedGroup simplifiedGroup) {
        SimplifiedThinkTime simplifiedThinkTime = simplifiedGroup.getRts().getThinktime();
        if (simplifiedThinkTime != null && simplifiedThinkTime.getType() != null && !simplifiedThinkTime.getType().isEmpty()) {
            return new ThinkTime(simplifiedThinkTime.getType(),
                    simplifiedThinkTime.getLimit_seconds(),
                    simplifiedThinkTime.getMin_percentage(),
                    simplifiedThinkTime.getMax_percentage(),
                    simplifiedThinkTime.getMultiply_factor());
        }
        return null;
    }

    private JavaVM defineJavaVM(SimplifiedGroup simplifiedGroup) {

        SimplifiedJavaVM simplifiedJavaVM = simplifiedGroup.getRts().getJava_vm();
        if (simplifiedJavaVM != null) {
            boolean userSpecifiedJdk = (simplifiedJavaVM.getJdk_home() != null && !simplifiedJavaVM.getJdk_home().isEmpty());
            JavaEnvClassPaths javaEnvClassPaths = null;
            if (simplifiedJavaVM.getJava_env_class_paths() != null && simplifiedJavaVM.getJava_env_class_paths().length > 0) {
                javaEnvClassPaths = new JavaEnvClassPaths();
                ArrayList<String> JavaEnvClassPath = new ArrayList<String>();
                for (String java_env_class_path : simplifiedJavaVM.getJava_env_class_paths()
                ) {
                    JavaEnvClassPath.add(java_env_class_path);
                }
                javaEnvClassPaths.setJavaEnvClassPath(JavaEnvClassPath);
            }
            return new JavaVM(javaEnvClassPaths,
                    userSpecifiedJdk,
                    userSpecifiedJdk ? simplifiedJavaVM.getJdk_home() : null,
                    simplifiedJavaVM.getJava_vm_parameters(),
                    simplifiedJavaVM.isUse_xboot(),
                    simplifiedJavaVM.isEnable_classloader_per_vuser());
        }
        return null;
    }

    private LGDistribution getLgDistribution(SimplifiedContent simplifiedContent) {
        LGDistributionTypeValues lgDistributionTypeValues = LGDistributionTypeValues.ALL_TO_EACH_GROUP;
        boolean isLGHostDefinedInGroups = simplifiedContent.getGroup().stream().filter(o -> o.getLg_name() != null && o.getLg_name().length > 0).count() == simplifiedContent.getGroup().size();

        if (simplifiedContent.getLg_amount() == 0 && isLGHostDefinedInGroups)
            lgDistributionTypeValues = LGDistributionTypeValues.MANUAL;
        else if (simplifiedContent.getLg_amount() == 0)
            simplifiedContent.setLg_amount(1);

        LGDistribution lgDistribution = new LGDistribution(lgDistributionTypeValues);
        lgDistribution.setType(lgDistributionTypeValues);
        if (lgDistributionTypeValues == LGDistributionTypeValues.ALL_TO_EACH_GROUP)
            lgDistribution.setAmount(simplifiedContent.getLg_amount());
        return lgDistribution;
    }

    private WorkloadType getWorkloadType() {
        return new WorkloadType(WorkloadTypeValues.BASIC, VusersDistributionModeValues.BY_NUMBER, WorkloadTypeSubTypeValues.BY_TEST);
    }

    private String getController(SimplifiedContent simplifiedContent) {
        String controller = null;
        if (simplifiedContent.getController() != null && !simplifiedContent.getController().isEmpty()) {
            controller = simplifiedContent.getController();
            if (controller.equalsIgnoreCase("Elastic"))
                controller = "Elastic";
        }
        return controller;
    }

    private String verifyTestFolderPath(String testFolderPath) {
        String testFolderPathWithSubject = "Subject\\".concat(testFolderPath);
        return testFolderPathWithSubject.replace("/", "\\");
    }

    private TimeInterval getTimeInterval(int timeIntervalInSeconds) {
        int day = (int) TimeUnit.SECONDS.toDays(timeIntervalInSeconds);
        long hours = TimeUnit.SECONDS.toHours(timeIntervalInSeconds) - (day * 24);
        long minute = TimeUnit.SECONDS.toMinutes(timeIntervalInSeconds) - (TimeUnit.SECONDS.toHours(timeIntervalInSeconds) * 60);
        long second = TimeUnit.SECONDS.toSeconds(timeIntervalInSeconds) - (TimeUnit.SECONDS.toMinutes(timeIntervalInSeconds) * 60);
        return new TimeInterval(day, Math.toIntExact(hours), Math.toIntExact(minute), Math.toIntExact(second));
    }
}
