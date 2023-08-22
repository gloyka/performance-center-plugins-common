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
package com.microfocus.adm.performancecenter.plugins.common.rest;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.Test;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.analysistemplate.AnalysisTemplate;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.automatictrending.AutomaticTrending;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.Diagnostics;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.j2eedotnet.J2EEDotNet;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticcontrollerconfiguration.ElasticControllerConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticloadgeneratorconfiguration.ElasticLoadGeneratorConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.GlobalCommandLine;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.commandline.CommandLine;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalrts.GlobalRTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.GoalScheduler;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalhitspersecond.GoalHitsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goaltransactionspersecond.GoalTransactionsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalvirtualusers.GoalVirtualUsers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.ScenarioSettings;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.runtimeaftergoalachieved.RunTimeAfterGoalAchieved;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.Group;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.host.Host;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.RTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.JavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter.JMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions.LogOptions;
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
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startgroup.StartGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers.StartVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.stopvusers.StopVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.SLA;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagehitspersecond.AverageHitsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagethroughput.AverageThroughput;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.Thresholds;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.LoadValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.errorspersecond.ErrorsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalhits.TotalHits;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalthroughput.TotalThroughput;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimeaverage.TransactionResponseTimeAverage;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimepercentile.TransactionResponseTimePercentile;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.workloadtype.WorkloadType;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.*;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.enums.SimplifiedPacingTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.SimplifiedTest;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.SimplifiedContent;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.automatictrending.SimplifiedAutomaticTrending;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.elasticconfiguration.SimplifiedElasticConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.SimplifiedRTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.javavm.SimplifiedJavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.jmeter.SimplifiedJMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.pacing.SimplifiedPacing;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.selenium.SimplifiedSelenium;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.thinktime.SimplifiedThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler.SimplifiedScheduler;
import org.junit.Before;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

import static com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy.xmlOrYamlStringToSimplifiedContent;
import static com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy.xmlOrYamlStringToSimplifiedTest;

//import org.junit.Test;

public class TestTest {
    private JAXBContext context;

    @Before
    public void init() throws JAXBException {
        this.context = JAXBContext.newInstance(Test.class);
    }

    @org.junit.Test
    public void verifySimplifiedTestSerialization() {

        //region SimplifiedJavaVM
        SimplifiedJavaVM simplifiedJavaVM = verifySimplifiedJavaVM();
        //endregion

        //region SimplifiedJMeter
        SimplifiedJMeter simplifiedJMeter = verifySimplifiedJMeter();
        //endregion

        //region SimplifiedSelenium
        SimplifiedSelenium simplifiedSelenium = verifySimplifiedSelenium();
        //endregion

        //region SimplifiedPacing
        SimplifiedPacing simplifiedPacing = verifySimplifiedPacing();
        //endregion

        //region SimplifiedThinkTime
        SimplifiedThinkTime simplifiedThinkTime = verifySimplifiedThinkTime();
        //endregion

        //region SimplifiedRTS
        verifySimplifiedRTS(simplifiedJavaVM, simplifiedJMeter, simplifiedPacing, simplifiedThinkTime, simplifiedSelenium);
        //endregion

        //region SimplifiedGroup
        ArrayList<SimplifiedGroup> simplifiedGroups = verifySimplifiedGroup();
        //endregion

        //region scheduler
        SimplifiedScheduler simplifiedScheduler = verifyScheduler();
        //endregion

        //region SimplifiedContent
        SimplifiedElasticConfiguration simplifiedElasticConfiguration = verifySimplifiedContent();
        //endregion

        //region SimplifiedAutomaticTrending
        SimplifiedAutomaticTrending simplifiedAutomaticTrending = verifySimplifiedAutomaticTrending();
        //endregion

        //region SimplifiedContentController
        SimplifiedContent simplifiedContent =
                verifySimplifiedContentController(simplifiedGroups, simplifiedScheduler,
                        simplifiedElasticConfiguration, simplifiedAutomaticTrending);
        //endregion

        //region SimplifiedTest
        verifySimplifiedTest(simplifiedContent);
        //endregion

        //region SimplifiedContentFromXmlFile
        String xmlSimplifiedContentFromFile = verifySimplifiedContentFromXmlFile();
        //endregion

        //region SimplifiedTestFromXmlFile
        String xmlSimplifiedTestFromFile = verifySimplifiedTestFromXmlFile();
        //endregion

        //region verify SimplifiedContent and SimplifiedTest from yaml and compare to those from xml
        verifySimplifiedContentAndSimplifiedTestFromYamlAndCompareToThoseFromXml(xmlSimplifiedContentFromFile, xmlSimplifiedTestFromFile);
        //endregion
    }

    @org.junit.Test
    public void verifyTestSerialization() throws JAXBException {
        //region Test
        /* verifying Test */
        //region Content
        /* verifying Content */
        //region AnalysisTemplate
        AnalysisTemplate analysisTemplate = verifyingAnalysisTemplate();
        //endregion AnalysisTemplate
        //region AutomaticTrending
        AutomaticTrending automaticTrending = verifyingAutomaticTrending();
        //endregion AutomaticTrending
        //region Diagnostics
        /* verifying Diagnostics */
        //region J2EEDotNet
        J2EEDotNet j2EEDotNet = verifyingJ2EEDotNet();
        //endregion J2EEDotNet
        Diagnostics diagnostics = verifyingDiagnostics(j2EEDotNet);
        //endregion J2EEDotNet
        //region GlobalCommandLine
        /* verifying GlobalCommandLine */
        //region CommandLine
        CommandLine firstCommandLine, firstCommandLine2, secondCommandLine, secondCommandLine2;
        String commandLineName1 = "CMD1";
        String commandLineName2 = "CMD2";
        String commandLineValue1 = "Command line 1";
        String commandLineValue2 = "Command line 2";
        /* verifying CommandLine */
        firstCommandLine = new CommandLine(commandLineName1, commandLineValue1);
        String xmlFirstCommandLine = firstCommandLine.objectToXML();
        firstCommandLine2 = CommandLine.xmlToObject(xmlFirstCommandLine);
        String xmlFirstCommandLine2 = firstCommandLine2.objectToXML();
        verifyXML(xmlFirstCommandLine, xmlFirstCommandLine2);
        secondCommandLine = new CommandLine(commandLineName2, commandLineValue2);
        String xmlSecondCommandLine = secondCommandLine.objectToXML();
        secondCommandLine2 = CommandLine.xmlToObject(xmlSecondCommandLine);
        String xmlSecondCommandLine2 = secondCommandLine2.objectToXML();
        verifyXML(xmlSecondCommandLine, xmlSecondCommandLine2);
        /* verified CommandLine */
        //endregion CommandLine
        GlobalCommandLine globalCommandLine = verifyingGlobalCommandLine(firstCommandLine, firstCommandLine2, secondCommandLine, secondCommandLine2);
        //endregion CommandLine
        //region Group
        /*verifying Groups*/
        //region Host
        verifyingHost();
        //endregion Host
        //region RTS
        /* verifying RTS */
        //region Log
        LogOptions logOptions = verifyingLogOptions();
        Log log = verifyingLog(logOptions);
        //endregion Log
        //region Pacing
        /* Verifying pacing */
        //region StartNewIteration
        StartNewIteration startNewIteration = VerifyingStartNewIteration();
        //endregion StartNewIteration
        Pacing pacing = verifyingPacing(startNewIteration);
        //endregion StartNewIteration
        //region ThinkTime
        ThinkTime thinkTime = new ThinkTime(ThinkTimeTypeValues.RANDOM, 50, 150, 10, 20);
        String xmlThinkTime = thinkTime.objectToXML();
        ThinkTime thinkTime2 = ThinkTime.xmlToObject(xmlThinkTime);
        String xmlThinkTime2 = thinkTime2.objectToXML();
        verifyXML(xmlThinkTime, xmlThinkTime2);
        //endregion ThinkTime
        //region JavaVM
        /* verifying JavaVM */
        //region JavaEnvClassPaths
        JavaEnvClassPaths javaEnvClassPaths = verifyingJavaEnvClassPaths();
        //endregion JavaEnvClassPaths
        JavaVM javaVM = verifyingJavaVM(javaEnvClassPaths);
        //endregion JavaEnvClassPaths
        //region JMeter
        JMeter jMeter = verifyingJMeter();
        //endregion JMeter
        //region Selenium
        Selenium selenium = verifyingSelenium();
        //endregion Selenium
        RTS rts = verifyingRTS(new RTS(pacing, thinkTime, log, jMeter, javaVM, selenium));
        verifyingRTS(new RTS("kuku", pacing, null, null, null, null, null));
        //endregion Selenium
        //region script
        Script script = verifyingScript();
        //endregion script
        //region Host
        ArrayList<Host> hosts = verifyingHost2();
        //endregion Host
        String groupName1 = "group1";
        String groupName2 = "group1";
        int vusers = 10;
        String globalRTSAll = "All";
        String globalRTSFirst = "first";
        String globalRTSSecond = "second";
        String globalRTSThird = "Third";
        String globalRTSFourth = "Fourth";
        String globalRTSFifth = "Fifth";
        verifyingGroup(groupName1, vusers, script, hosts, rts, globalRTSFifth, commandLineName1);
        //endregion
        //region GlobalRTS
        /* Verifying GlobalRTS */
        //creating RTS for GlobalRTS
        ArrayList<RTS> rtsList = new ArrayList<RTS>();
        rtsList.add(new RTS(globalRTSAll, pacing, thinkTime, log, jMeter, javaVM, selenium));
        rtsList.add(new RTS(globalRTSFirst, pacing, null, null, null, null, null));
        rtsList.add(new RTS(globalRTSSecond, null, thinkTime, null, null, null, null));
        rtsList.add(new RTS(globalRTSThird, null, null, log, null, null, null));
        rtsList.add(new RTS(globalRTSFourth, null, null, null, jMeter, null, null));
        rtsList.add(new RTS(globalRTSFifth, null, null, null, null, javaVM, null));
        rtsList.add(new RTS(globalRTSFifth, null, null, null, null, null, selenium));
        //Verifying GlobalRTS
        GlobalRTS globalRTS = verifyingGlobalRTS(rtsList);
        /* Verified GlobalRTS */
        //endregion
        //region LGDistribution
        LGDistribution lgDistribution = verifyingLGDistribution();
        //endregion
        //region MonitorProfile
        verifyingMonitorProfile();
        //endregion
        //region monitorOFW
        verifyingMonitorOFW();
        //endregion
        //region SimplifiedScheduler
        /* Verifying SimplifiedScheduler */
        //region Action
        /* Verifying Action */
        //region Ramp
        /* Verifying Ramp */
        //region TimeInterval
        TimeInterval timeInterval = verifyingTimeInterval();
        //endregion
        Ramp ramp = verifyingRamp(timeInterval);
        //endregion
        //region Duration
        Duration duration = verifyingDuration(timeInterval);
        //endregion
        //region Initialize
        Initialize initialize = verifyingInitialize(timeInterval);
        //endregion
        //region StartGroup
        StartGroup startGroup = verifyingStartGroup(timeInterval);
        //endregion
        //region StartVusers
        StartVusers startVusers = verifyingStartVusers(ramp);
        //endregion
        //region StopVusers
        StopVusers stopVusers = verifyingStopVusers(ramp);
        //endregion
        verifyingAction(initialize);
        //endregion
        Scheduler scheduler = verifyingSimplifiedScheduler(initialize, startVusers, duration, stopVusers, startGroup);
        //endregion
        //region GoalScheduler
        /* verifying GoalScheduler */
        //region GoalHitsPerSecond
        GoalHitsPerSecond goalHitsPerSecond = verifyingGoalHitsPerSecond();
        //endregion
        //region GoalScheduler
        GoalTransactionsPerSecond goalTransactionsPerSecond = verifyingGoalTransactionsPerSecond();
        //endregion
        //region GoalVirtualUsers
        GoalVirtualUsers goalVirtualUsers = verifyingGoalVirtualUsers();
        //endregion
        //region ScenarioSettings
        /* Verifying ScenarioSettings */
        //region RunTimeAfterGoalAchieved
        RunTimeAfterGoalAchieved runTimeAfterGoalAchieved = verifyingRunTimeAfterGoalAchieved();
        //endregion
        ScenarioSettings scenarioSettings = verifyingScenarioSettings(runTimeAfterGoalAchieved);
        //endregion
        verifyingGoalScheduler(goalHitsPerSecond, goalTransactionsPerSecond, goalVirtualUsers, scenarioSettings);
        //endregion
        //region WorkloadType
        WorkloadType workloadType = verifyingWorkloadType();
        //endregion
        //region SLA
        /* Verifying SLA */
        //region AverageHitsPerSecond
        AverageHitsPerSecond averageHitsPerSecond = verifyingAverageHitsPerSecond();
        //endregion
        //region AverageThroughput
        AverageThroughput averageThroughput = verifyingAverageThroughput();
        //endregion
        //region Between
        verifyingBetween();
        //endregion
        //region LoadValues
        LoadValues loadValues = verifyingLoadValues();
        //endregion
        //region Thresholds
        /* Verifying Thresholds */
        //region BetweenThreshold
        BetweenThreshold betweenThreshold = verifyingBetweenThreshold();
        //endregion
        //verifying Thresholds
        Thresholds thresholds = verifyingThresholds(betweenThreshold);
        /* Verified Thresholds */
        //endregion
        //region ErrorsPerSecond
        ErrorsPerSecond errorsPerSecond = verifyingErrorsPerSecond(thresholds, loadValues);
        //endregion
        //region TotalHits
        TotalHits totalHits = verifyingTotalHits();
        //endregion
        //region TotalThroughput
        TotalThroughput totalThroughput = verifyingTotalThroughput();
        //endregion
        //region Transaction with Thresholds
        verifyingTransactionWithThresholds(new Transaction("Action_Transaction", thresholds));
        //endregion
        //region Transaction with Threshold
        verifyingTransactionWithThresholds(new Transaction("Action_Transaction", 12));
        //endregion
        //region TransactionResponseTimeAverage
        TransactionResponseTimeAverage transactionResponseTimeAverage = verifyingTransactionResponseTimeAverage(thresholds, loadValues);
        //endregion
        //region TransactionResponseTimePercentile
        TransactionResponseTimePercentile transactionResponseTimePercentile = verifyingTransactionResponseTimePercentile();
        //endregion
        SLA sla = verifyingSLA(averageThroughput, transactionResponseTimeAverage, transactionResponseTimePercentile, averageHitsPerSecond, totalThroughput, errorsPerSecond, totalHits);
        //endregion
        //region ElasticLoadGeneratorConfiguration
        ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration = verifyingElasticLoadGeneratorConfiguration();
        //endregion
        //region ElasticControllerConfiguration
        ElasticControllerConfiguration elasticControllerConfiguration = verifyingElasticControllerConfiguration();
        //endregion
        //region ElasticLoadGeneratorConfiguration
        // ElasticLoadGeneratorConfiguration
        //endregion
        //Verified Content
        ArrayList<MonitorProfile> monotorProfiles = new ArrayList<MonitorProfile>();
        monotorProfiles.add(new MonitorProfile(42));
        monotorProfiles.add(new MonitorProfile(45));
        ArrayList<Group> groups = new ArrayList<Group>();
        ArrayList<MonitorOFW> monitorsOFW = new ArrayList<MonitorOFW>();
        monitorsOFW.add(new MonitorOFW(80));
        monitorsOFW.add(new MonitorOFW(81));
        groups.add(new Group(groupName1, vusers, script, hosts, rts, globalRTSFifth, commandLineName1, null));
        groups.add(new Group(groupName2, vusers, script, hosts, rts, globalRTSFifth, commandLineName2, null));
        Content content = new Content("controller", workloadType, lgDistribution, monotorProfiles, groups, scheduler, analysisTemplate, automaticTrending, monitorsOFW, sla, diagnostics, globalCommandLine, globalRTS, elasticLoadGeneratorConfiguration, elasticControllerConfiguration);
        String xmlContent = content.objectToXML(true);
        Content content2 = Content.xmlToObject(xmlContent);
        String xmlContent2 = content2.objectToXML(true);
        verifyXML(xmlContent, xmlContent2);
        /* Verified Content */
        //endregion
        //verifying creating Test
        Test test = new Test("myNewTest", "Subject\\coucou", content);
        String xmlTest = test.objectToXML();
        Test test2 = Test.xmlToObject(xmlTest);
        String xmlTest2 = test2.objectToXML();
        //region Content taken from test
        //verify Content taken from test
        Content contentFromTest = test.getContent();
        String xmlContentFromTest = contentFromTest.objectToXML(true);
        Content contentFromTest2 = Content.xmlToObject(xmlContent);
        String xmlContentFromTest2 = contentFromTest2.objectToXML(true);
        verifyXML(xmlContentFromTest, xmlContentFromTest2);
        //endregion
        verifyXML(xmlTest, xmlTest2);
        /* Verified Test */
        //endregion
    }

    private void verifySimplifiedContentAndSimplifiedTestFromYamlAndCompareToThoseFromXml(String xmlSimplifiedContentFromFile, String xmlSimplifiedTestFromFile) {
        try {
            SimplifiedContent SimplifiedContentFromXml = xmlOrYamlStringToSimplifiedContent(xmlSimplifiedContentFromFile);
            SimplifiedTest SimplifiedTestFromXml = xmlOrYamlStringToSimplifiedTest(xmlSimplifiedTestFromFile);

            String yamlSimplifiedContentFromFile = TestPcRestProxy.fileToStringWithoutTrim("simplifiedContent.yaml");
            SimplifiedContent SimplifiedContentFromYaml = xmlOrYamlStringToSimplifiedContent(yamlSimplifiedContentFromFile);

            String yamlSimplifiedTestFromFile = TestPcRestProxy.fileToStringWithoutTrim("simplifiedTest.yaml");
            SimplifiedTest SimplifiedTestFromYaml = xmlOrYamlStringToSimplifiedTest(yamlSimplifiedTestFromFile);

            verifyXML(SimplifiedContentFromXml.objectToXML(), SimplifiedContentFromYaml.objectToXML());
            verifyXML(SimplifiedTestFromXml.objectToXML(), SimplifiedTestFromYaml.objectToXML());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String verifySimplifiedTestFromXmlFile() {
        String xmlSimplifiedTestFromFile = TestPcRestProxy.fileToStringWithoutTrim("simplifiedTest.xml");
        SimplifiedTest simplifiedTest3 = SimplifiedTest.xmlToObject(xmlSimplifiedTestFromFile);
        String xmlSimplifiedTest3 = simplifiedTest3.objectToXML();
        verifyXML(xmlSimplifiedTestFromFile.replace("\r\n", ""), xmlSimplifiedTest3.replace("\n", ""));
        return xmlSimplifiedTestFromFile;
    }

    private String verifySimplifiedContentFromXmlFile() {
        String xmlSimplifiedContentFromFile = TestPcRestProxy.fileToStringWithoutTrim("simplifiedContent.xml");
        SimplifiedContent simplifiedContent3 = SimplifiedContent.xmlToObject(xmlSimplifiedContentFromFile);
        String xmlSimplifiedContent3 = simplifiedContent3.objectToXML();
        verifyXML(xmlSimplifiedContentFromFile.replace("\r\n", ""), xmlSimplifiedContent3.replace("\n", ""));
        return xmlSimplifiedContentFromFile;
    }

    private void verifySimplifiedTest(SimplifiedContent simplifiedContent) {
        String test_name = "mytest";
        String test_folder_path = "folder\\subfolder";
        SimplifiedTest simplifiedTest = new SimplifiedTest(test_name, test_folder_path, simplifiedContent);
        String xmlSimplifiedTest = simplifiedTest.objectToXML();
        SimplifiedTest simplifiedTest2 = SimplifiedTest.xmlToObject(xmlSimplifiedTest);
        String xmlSimplifiedTest2 = simplifiedTest2.objectToXML();
        verifyXML(xmlSimplifiedTest, xmlSimplifiedTest2);
    }

    private SimplifiedContent verifySimplifiedContentController(
            ArrayList<SimplifiedGroup> simplifiedGroups,
            SimplifiedScheduler simplifiedScheduler,
            SimplifiedElasticConfiguration simplifiedElasticConfiguration,
            SimplifiedAutomaticTrending simplifiedAutomaticTrending
    ) {
        int lg_amount = 3;
        String controller = "[test]controller1";
        SimplifiedContent simplifiedContent = new SimplifiedContent(controller, lg_amount, simplifiedGroups, simplifiedScheduler, simplifiedElasticConfiguration, simplifiedElasticConfiguration, simplifiedAutomaticTrending);
        String xmlSimplifiedContent = simplifiedContent.objectToXML();
        SimplifiedContent simplifiedContent2 = SimplifiedContent.xmlToObject(xmlSimplifiedContent);
        String xmlSimplifiedContent2 = simplifiedContent2.objectToXML();
        verifyXML(xmlSimplifiedContent, xmlSimplifiedContent2);
        return simplifiedContent;
    }

    private SimplifiedElasticConfiguration verifySimplifiedContent() {
        SimplifiedElasticConfiguration simplifiedElasticConfiguration = new SimplifiedElasticConfiguration(5, 2, 5);
        String xmlSimplifiedElasticConfiguration = simplifiedElasticConfiguration.objectToXML();
        SimplifiedElasticConfiguration simplifiedElasticConfiguration2 = SimplifiedElasticConfiguration.xmlToObject(xmlSimplifiedElasticConfiguration);
        String xmlSimplifiedElasticConfiguration2 = simplifiedElasticConfiguration2.objectToXML();
        verifyXML(xmlSimplifiedElasticConfiguration, xmlSimplifiedElasticConfiguration2);
        return simplifiedElasticConfiguration;
    }

    private SimplifiedAutomaticTrending verifySimplifiedAutomaticTrending() {
        SimplifiedAutomaticTrending simplifiedAutomaticTrending = new SimplifiedAutomaticTrending(5, 4);
        String xmlSimplifiedAutomaticTrending = simplifiedAutomaticTrending.objectToXML();
        SimplifiedAutomaticTrending simplifiedAutomaticTrending2 = SimplifiedAutomaticTrending.xmlToObject(xmlSimplifiedAutomaticTrending);
        String xmlSimplifiedAutomaticTrending2 = simplifiedAutomaticTrending2.objectToXML();
        verifyXML(xmlSimplifiedAutomaticTrending, xmlSimplifiedAutomaticTrending2);
        return simplifiedAutomaticTrending;
    }

    private SimplifiedScheduler verifyScheduler() {
        int rampup = 300;
        int duration = 600;
        SimplifiedScheduler simplifiedScheduler = new SimplifiedScheduler(rampup, duration);
        String xmlSimplifiedScheduler = simplifiedScheduler.objectToXML();
        SimplifiedScheduler simplifiedScheduler2 = SimplifiedScheduler.xmlToObject(xmlSimplifiedScheduler);
        String xmlSimplifiedScheduler2 = simplifiedScheduler2.objectToXML();
        verifyXML(xmlSimplifiedScheduler, xmlSimplifiedScheduler2);
        return simplifiedScheduler;
    }

    private ArrayList<SimplifiedGroup> verifySimplifiedGroup() {
        String group_name = "group1";
        int vusers = 20;
        int script_id = 5;
        String script_path = "scripts\\folder1\\scriptname";
        String[] lg_name = {"LG1", "LG2"};
        SimplifiedGroup simplifiedGroup = new SimplifiedGroup(group_name, vusers, script_id, script_path, lg_name);
        String xmlSimplifiedGroup = simplifiedGroup.objectToXML();
        SimplifiedGroup simplifiedGroup2 = SimplifiedGroup.xmlToObject(xmlSimplifiedGroup);
        String xmlSimplifiedGroup2 = simplifiedGroup2.objectToXML();
        verifyXML(xmlSimplifiedGroup, xmlSimplifiedGroup2);
        ArrayList<SimplifiedGroup> simplifiedGroups = new ArrayList<SimplifiedGroup>();
        simplifiedGroups.add(simplifiedGroup);
        simplifiedGroups.add(simplifiedGroup2);
        return simplifiedGroups;
    }

    private void verifySimplifiedRTS(SimplifiedJavaVM simplifiedJavaVM, SimplifiedJMeter simplifiedJMeter, SimplifiedPacing simplifiedPacing, SimplifiedThinkTime simplifiedThinkTime, SimplifiedSelenium simplifiedSelenium) {
        SimplifiedRTS simplifiedRTS = new SimplifiedRTS(simplifiedJavaVM, simplifiedJMeter, simplifiedPacing, simplifiedThinkTime, simplifiedSelenium);
        String xmlSimplifiedRTS = simplifiedRTS.objectToXML();
        SimplifiedRTS simplifiedRTS2 = SimplifiedRTS.xmlToObject(xmlSimplifiedRTS);
        String xmlSimplifiedRTS2 = simplifiedRTS2.objectToXML();
        verifyXML(xmlSimplifiedRTS, xmlSimplifiedRTS2);
    }

    private SimplifiedThinkTime verifySimplifiedThinkTime() {
        String simplifiedThinkTimeType = SimplifiedPacingTypeValues.RANDOM_INTERVAL.value();
        int min_percentage = 3;
        int max_percentage = 8;
        int limit_seconds = 60;
        int multiply_factor = 3;
        SimplifiedThinkTime simplifiedThinkTime = new SimplifiedThinkTime(simplifiedThinkTimeType, limit_seconds, min_percentage, max_percentage, multiply_factor);
        String xmlSimplifiedThinkTime = simplifiedThinkTime.objectToXML();
        SimplifiedThinkTime simplifiedThinkTime2 = SimplifiedThinkTime.xmlToObject(xmlSimplifiedThinkTime);
        String xmlSimplifiedThinkTime2 = simplifiedThinkTime2.objectToXML();
        verifyXML(xmlSimplifiedThinkTime, xmlSimplifiedThinkTime2);
        return simplifiedThinkTime;
    }

    private SimplifiedPacing verifySimplifiedPacing() {
        int number_of_iterations = 3;
        String simplifiedPacingType = SimplifiedPacingTypeValues.RANDOM_INTERVAL.value();
        int delay_at_range_of_seconds = 60;
        int delay_at_range_to_seconds = 120;
        SimplifiedPacing simplifiedPacing = new SimplifiedPacing(number_of_iterations, simplifiedPacingType, delay_at_range_of_seconds, delay_at_range_to_seconds);
        String xmlSimplifiedPacing = simplifiedPacing.objectToXML();
        SimplifiedPacing simplifiedPacing2 = SimplifiedPacing.xmlToObject(xmlSimplifiedPacing);
        String xmlSimplifiedPacing2 = simplifiedPacing2.objectToXML();
        verifyXML(xmlSimplifiedPacing, xmlSimplifiedPacing2);
        return simplifiedPacing;
    }

    private SimplifiedSelenium verifySimplifiedSelenium() {
        String jre_path = "jre_path";
        String class_path = "class_path";
        String test_ng_files = "test_ng_files";
        SimplifiedSelenium simplifiedSelenium = new SimplifiedSelenium(jre_path, class_path, test_ng_files);
        String xmlSimplifiedSelenium = simplifiedSelenium.objectToXML();
        SimplifiedSelenium simplifiedSelenium2 = SimplifiedSelenium.xmlToObject(xmlSimplifiedSelenium);
        String xmlSimplifiedSelenium2 = simplifiedSelenium2.objectToXML();
        verifyXML(xmlSimplifiedSelenium, xmlSimplifiedSelenium2);
        return simplifiedSelenium;
    }

    private SimplifiedJMeter verifySimplifiedJMeter() {
        boolean start_measurements = true;
        String jmeter_home_path = "jmeter_home_path";
        int jmeter_min_port = 12345;
        int jmeter_max_port = 12346;
//        boolean jmeter_distribute_mode = true;
//        String jmeter_additional_properties = "jmeter_additional_properties";
        SimplifiedJMeter simplifiedJMeter = new SimplifiedJMeter(start_measurements, jmeter_home_path, jmeter_min_port, jmeter_max_port);
        String xmlSimplifiedJMeter = simplifiedJMeter.objectToXML();
        SimplifiedJMeter simplifiedJMeter2 = SimplifiedJMeter.xmlToObject(xmlSimplifiedJMeter);
        String xmlSimplifiedJMeter2 = simplifiedJMeter2.objectToXML();
        verifyXML(xmlSimplifiedJMeter, xmlSimplifiedJMeter2);
        return simplifiedJMeter;
    }

    private SimplifiedJavaVM verifySimplifiedJavaVM() {
        String jdk_home = "jdk_home";
        String java_vm_parameters = "java_vm_parameters";
        boolean use_xboot = true;
        boolean enable_classloader_per_vuser = true;
        String[] java_env_class_paths = {"java_env_class_path1", "java_env_class_path2"};
        SimplifiedJavaVM simplifiedJavaVM = new SimplifiedJavaVM(jdk_home, java_vm_parameters, use_xboot, enable_classloader_per_vuser, java_env_class_paths);
        String xmlSimplifiedJavaVM = simplifiedJavaVM.objectToXML();
        SimplifiedJavaVM simplifiedJavaVM2 = SimplifiedJavaVM.xmlToObject(xmlSimplifiedJavaVM);
        String xmlSimplifiedJavaVM2 = simplifiedJavaVM2.objectToXML();
        verifyXML(xmlSimplifiedJavaVM, xmlSimplifiedJavaVM2);
        return simplifiedJavaVM;
    }

    private ElasticControllerConfiguration verifyingElasticControllerConfiguration() {
        ElasticControllerConfiguration elasticControllerConfiguration = new ElasticControllerConfiguration(3, 2, 2);
        String xmlElasticControllerConfiguration = elasticControllerConfiguration.objectToXML();
        ElasticControllerConfiguration elasticControllerConfiguration2 = ElasticControllerConfiguration.xmlToObject(xmlElasticControllerConfiguration);
        String xmlElasticControllerConfiguration2 = elasticControllerConfiguration2.objectToXML();
        verifyXML(xmlElasticControllerConfiguration, xmlElasticControllerConfiguration2);
        return elasticControllerConfiguration;
    }

    private ElasticLoadGeneratorConfiguration verifyingElasticLoadGeneratorConfiguration() {
        ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration = new ElasticLoadGeneratorConfiguration(3, 2, 2);
        String xmlElasticLoadGeneratorConfiguration = elasticLoadGeneratorConfiguration.objectToXML();
        ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration2 = ElasticLoadGeneratorConfiguration.xmlToObject(xmlElasticLoadGeneratorConfiguration);
        String xmlElasticLoadGeneratorConfiguration2 = elasticLoadGeneratorConfiguration2.objectToXML();
        verifyXML(xmlElasticLoadGeneratorConfiguration, xmlElasticLoadGeneratorConfiguration2);
        return elasticLoadGeneratorConfiguration;
    }

    private SLA verifyingSLA(AverageThroughput averageThroughput, TransactionResponseTimeAverage transactionResponseTimeAverage, TransactionResponseTimePercentile transactionResponseTimePercentile, AverageHitsPerSecond averageHitsPerSecond, TotalThroughput totalThroughput, ErrorsPerSecond errorsPerSecond, TotalHits totalHits) {
        SLA sla = new SLA(averageThroughput, transactionResponseTimeAverage, transactionResponseTimePercentile, averageHitsPerSecond, totalThroughput, errorsPerSecond, totalHits);
        String xmlSLA = sla.objectToXML();
        SLA sla2 = SLA.xmlToObject(xmlSLA);
        String xmlSLA2 = sla2.objectToXML();
        verifyXML(xmlSLA, xmlSLA2);
        return sla;
    }

    private TransactionResponseTimePercentile verifyingTransactionResponseTimePercentile() {
        ArrayList<Transaction> transactionResponseTimePercentileTransactions = new ArrayList<Transaction>();
        transactionResponseTimePercentileTransactions.add(new Transaction("Action_Transaction", 10));
        transactionResponseTimePercentileTransactions.add(new Transaction("vuser_end_Transaction", 20));
        transactionResponseTimePercentileTransactions.add(new Transaction("vuser_init_Transaction", 30));

        TransactionResponseTimePercentile transactionResponseTimePercentile = new TransactionResponseTimePercentile(transactionResponseTimePercentileTransactions, 100);
        String xmlTransactionResponseTimePercentile = transactionResponseTimePercentile.objectToXML();
        TransactionResponseTimePercentile transactionResponseTimePercentile2 = TransactionResponseTimePercentile.xmlToObject(xmlTransactionResponseTimePercentile);
        String xmlTransactionResponseTimePercentile2 = transactionResponseTimePercentile2.objectToXML();
        verifyXML(xmlTransactionResponseTimePercentile, xmlTransactionResponseTimePercentile2);
        return transactionResponseTimePercentile;
    }

    private TransactionResponseTimeAverage verifyingTransactionResponseTimeAverage(Thresholds thresholds, LoadValues loadValues) {
        ArrayList<Transaction> transactionResponseTimeAverageTransactions = new ArrayList<Transaction>();
        transactionResponseTimeAverageTransactions.add(new Transaction("Action_Transaction", thresholds));
        transactionResponseTimeAverageTransactions.add(new Transaction("vuser_end_Transaction", thresholds));
        transactionResponseTimeAverageTransactions.add(new Transaction("vuser_init_Transaction", thresholds));

        TransactionResponseTimeAverage transactionResponseTimeAverage = new TransactionResponseTimeAverage(LoadCriterionValues.RUNNING_VUSERS, loadValues, transactionResponseTimeAverageTransactions);
        String xmlTransactionResponseTimeAverage = transactionResponseTimeAverage.objectToXML();
        TransactionResponseTimeAverage transactionResponseTimeAverage2 = TransactionResponseTimeAverage.xmlToObject(xmlTransactionResponseTimeAverage);
        String xmlTransactionResponseTimeAverage2 = transactionResponseTimeAverage2.objectToXML();
        verifyXML(xmlTransactionResponseTimeAverage, xmlTransactionResponseTimeAverage2);
        return transactionResponseTimeAverage;
    }

    private void verifyingTransactionWithThresholds(Transaction thresholds) {
        Transaction transactionThresholds = thresholds;
        String xmlTransactionThresholds = transactionThresholds.objectToXML();
        Transaction transactionThresholds2 = Transaction.xmlToObject(xmlTransactionThresholds);
        String xmlTransactionThresholds2 = transactionThresholds2.objectToXML();
        verifyXML(xmlTransactionThresholds, xmlTransactionThresholds2);
    }

    private TotalThroughput verifyingTotalThroughput() {
        TotalThroughput totalThroughput = new TotalThroughput(10);
        String xmlTotalThroughput = totalThroughput.objectToXML();
        TotalThroughput totalThroughput2 = TotalThroughput.xmlToObject(xmlTotalThroughput);
        String xmlTotalThroughput2 = totalThroughput2.objectToXML();
        verifyXML(xmlTotalThroughput, xmlTotalThroughput2);
        return totalThroughput;
    }

    private TotalHits verifyingTotalHits() {
        TotalHits totalHits = new TotalHits(10);
        String xmlTotalHits = totalHits.objectToXML();
        TotalHits totalHits2 = TotalHits.xmlToObject(xmlTotalHits);
        String xmlTotalHits2 = totalHits2.objectToXML();
        verifyXML(xmlTotalHits, xmlTotalHits2);
        return totalHits;
    }

    private ErrorsPerSecond verifyingErrorsPerSecond(Thresholds thresholds, LoadValues loadValues) {
        ErrorsPerSecond errorsPerSecond = new ErrorsPerSecond(LoadCriterionValues.RUNNING_VUSERS, thresholds, loadValues);
        String xmlErrorsPerSecond = errorsPerSecond.objectToXML();
        ErrorsPerSecond errorsPerSecond2 = ErrorsPerSecond.xmlToObject(xmlErrorsPerSecond);
        String xmlErrorsPerSecond2 = errorsPerSecond2.objectToXML();
        verifyXML(xmlErrorsPerSecond, xmlErrorsPerSecond2);
        return errorsPerSecond;
    }

    private Thresholds verifyingThresholds(BetweenThreshold betweenThreshold) {
        int thresholdsLessThanThreshold = 10;
        int thresholdsGreaterThanOrEqualThreshold = 50;
        Thresholds thresholds = new Thresholds(thresholdsLessThanThreshold, betweenThreshold, thresholdsGreaterThanOrEqualThreshold);
        String xmlThresholds = thresholds.objectToXML();
        Thresholds thresholds2 = Thresholds.xmlToObject(xmlThresholds);
        String xmlThresholds2 = thresholds2.objectToXML();
        verifyXML(xmlThresholds, xmlThresholds2);
        return thresholds;
    }

    private BetweenThreshold verifyingBetweenThreshold() {
        ArrayList<String> BetweenThresholdThresholds = new ArrayList<String>();
        BetweenThresholdThresholds.add("40");
        BetweenThresholdThresholds.add("30");
        BetweenThresholdThresholds.add("40");

        BetweenThreshold betweenThreshold = new BetweenThreshold(BetweenThresholdThresholds);
        String xmlBetweenThreshold = betweenThreshold.objectToXML();
        BetweenThreshold betweenThreshold2 = BetweenThreshold.xmlToObject(xmlBetweenThreshold);
        String xmlBetweenThreshold2 = betweenThreshold2.objectToXML();
        verifyXML(xmlBetweenThreshold, xmlBetweenThreshold2);
        return betweenThreshold;
    }

    private LoadValues verifyingLoadValues() {
        int lessThan = 1;
        ArrayList<Between> betweens = new ArrayList<Between>();
        betweens.add(new Between(1, 25));
        betweens.add(new Between(25, 50));
        betweens.add(new Between(50, 75));
        int greaterThanOrEqual = 75;

        LoadValues loadValues = new LoadValues(lessThan, betweens, greaterThanOrEqual);
        String xmlLoadValues = loadValues.objectToXML();
        LoadValues loadValues2 = LoadValues.xmlToObject(xmlLoadValues);
        String xmlLoadValues2 = loadValues2.objectToXML();
        verifyXML(xmlLoadValues, xmlLoadValues2);
        return loadValues;
    }

    private void verifyingBetween() {
        int betweenFrom = 10;
        int betweenTo = 20;
        Between between = new Between(betweenFrom, betweenTo);
        String xmlBetween = between.objectToXML();
        Between between2 = Between.xmlToObject(xmlBetween);
        String xmlBetween2 = between2.objectToXML();
        verifyXML(xmlBetween, xmlBetween2);
    }

    private AverageThroughput verifyingAverageThroughput() {
        int averageThroughputThreshold = 90;
        AverageThroughput averageThroughput = new AverageThroughput(averageThroughputThreshold);
        String xmlAverageThroughput = averageThroughput.objectToXML();
        AverageThroughput averageThroughput2 = AverageThroughput.xmlToObject(xmlAverageThroughput);
        String xmlAverageThroughput2 = averageThroughput2.objectToXML();
        verifyXML(xmlAverageThroughput, xmlAverageThroughput2);
        return averageThroughput;
    }

    private AverageHitsPerSecond verifyingAverageHitsPerSecond() {
        int averageHitsPerSecondThreshold = 40;
        AverageHitsPerSecond averageHitsPerSecond = new AverageHitsPerSecond(averageHitsPerSecondThreshold);
        String xmlAverageHitsPerSecond = averageHitsPerSecond.objectToXML();
        AverageHitsPerSecond averageHitsPerSecond2 = AverageHitsPerSecond.xmlToObject(xmlAverageHitsPerSecond);
        String xmlAverageHitsPerSecond2 = averageHitsPerSecond2.objectToXML();
        verifyXML(xmlAverageHitsPerSecond, xmlAverageHitsPerSecond2);
        return averageHitsPerSecond;
    }

    private WorkloadType verifyingWorkloadType() {
        WorkloadType workloadType = new WorkloadType(WorkloadTypeValues.BASIC, VusersDistributionModeValues.BY_NUMBER, WorkloadTypeSubTypeValues.BY_TEST);
        String xmlWorkloadType = workloadType.objectToXML();
        WorkloadType workloadType2 = WorkloadType.xmlToObject(xmlWorkloadType);
        String xmlWorkloadType2 = workloadType2.objectToXML();
        verifyXML(xmlWorkloadType, xmlWorkloadType2);
        return workloadType;
    }

    private void verifyingGoalScheduler(GoalHitsPerSecond goalHitsPerSecond, GoalTransactionsPerSecond goalTransactionsPerSecond, GoalVirtualUsers goalVirtualUsers, ScenarioSettings scenarioSettings) {
        String goalProfileName = "HPS_100";
        GoalTypeValues goalType;
        boolean doNotChangeScriptThinkTime = true;
        GoalScheduler goalScheduler = new GoalScheduler(goalProfileName, GoalTypeValues.HITS_PER_SECOND, goalHitsPerSecond, goalTransactionsPerSecond, goalVirtualUsers, doNotChangeScriptThinkTime, scenarioSettings);
        String xmlGoalScheduler = goalScheduler.objectToXML();
        GoalScheduler goalScheduler2 = GoalScheduler.xmlToObject(xmlGoalScheduler);
        String xmlGoalScheduler2 = goalScheduler2.objectToXML();
        verifyXML(xmlGoalScheduler, xmlGoalScheduler2);
    }

    private ScenarioSettings verifyingScenarioSettings(RunTimeAfterGoalAchieved runTimeAfterGoalAchieved) {
        boolean scenarioSettingsReceiveNotification = true;
        ScenarioSettings scenarioSettings = new ScenarioSettings(GoalCannotBeReachedActionValues.CONTINUE_WITHOUT_REACHING, runTimeAfterGoalAchieved, scenarioSettingsReceiveNotification);
        String xmlScenarioSettings = scenarioSettings.objectToXML();
        ScenarioSettings scenarioSettings2 = ScenarioSettings.xmlToObject(xmlScenarioSettings);
        String xmlScenarioSettings2 = scenarioSettings2.objectToXML();
        verifyXML(xmlScenarioSettings, xmlScenarioSettings2);
        return scenarioSettings;
    }

    private RunTimeAfterGoalAchieved verifyingRunTimeAfterGoalAchieved() {
        int runTimeAfterGoalAchievedMinutes = 5;
        RunTimeAfterGoalAchieved runTimeAfterGoalAchieved = new RunTimeAfterGoalAchieved(runTimeAfterGoalAchievedMinutes);
        String xmlRunTimeAfterGoalAchieved = runTimeAfterGoalAchieved.objectToXML();
        RunTimeAfterGoalAchieved runTimeAfterGoalAchieved2 = RunTimeAfterGoalAchieved.xmlToObject(xmlRunTimeAfterGoalAchieved);
        String xmlRunTimeAfterGoalAchieved2 = runTimeAfterGoalAchieved2.objectToXML();
        verifyXML(xmlRunTimeAfterGoalAchieved, xmlRunTimeAfterGoalAchieved2);
        return runTimeAfterGoalAchieved;
    }

    private GoalVirtualUsers verifyingGoalVirtualUsers() {
        int targetVusersNumber = 30;
        GoalVirtualUsers goalVirtualUsers = new GoalVirtualUsers(targetVusersNumber);
        String xmlGoalVirtualUsers = goalVirtualUsers.objectToXML();
        GoalVirtualUsers goalVirtualUsers2 = GoalVirtualUsers.xmlToObject(xmlGoalVirtualUsers);
        String xmlGoalVirtualUsers2 = goalVirtualUsers2.objectToXML();
        verifyXML(xmlGoalVirtualUsers, xmlGoalVirtualUsers2);
        return goalVirtualUsers;
    }

    private GoalTransactionsPerSecond verifyingGoalTransactionsPerSecond() {
        String targetTransactionsPerSecond = "2";
        String transactionName = "myTransactionName";
        int goalTransactionsPerSecondMinVusers = 30;
        int goalTransactionsPerSecondMaxVusers = 60;
        GoalTransactionsPerSecond goalTransactionsPerSecond = new GoalTransactionsPerSecond(targetTransactionsPerSecond, transactionName, goalTransactionsPerSecondMinVusers, goalTransactionsPerSecondMaxVusers);
        String xmlGoalTransactionsPerSecond = goalTransactionsPerSecond.objectToXML();
        GoalTransactionsPerSecond goalTransactionsPerSecond2 = GoalTransactionsPerSecond.xmlToObject(xmlGoalTransactionsPerSecond);
        String xmlGoalTransactionsPerSecond2 = goalTransactionsPerSecond2.objectToXML();
        verifyXML(xmlGoalTransactionsPerSecond, xmlGoalTransactionsPerSecond2);
        return goalTransactionsPerSecond;
    }

    private GoalHitsPerSecond verifyingGoalHitsPerSecond() {
        int targetHitsPerSecond = 100;
        int goalHitsPerSecondMinVusers = 30;
        int goalHitsPerSecondMaxVusers = 60;
        GoalHitsPerSecond goalHitsPerSecond = new GoalHitsPerSecond(targetHitsPerSecond, goalHitsPerSecondMinVusers, goalHitsPerSecondMaxVusers);
        String xmlGoalHitsPerSecond = goalHitsPerSecond.objectToXML();
        GoalHitsPerSecond goalHitsPerSecond2 = GoalHitsPerSecond.xmlToObject(xmlGoalHitsPerSecond);
        String xmlGoalHitsPerSecond2 = goalHitsPerSecond2.objectToXML();
        verifyXML(xmlGoalHitsPerSecond, xmlGoalHitsPerSecond2);
        return goalHitsPerSecond;
    }

    private Scheduler verifyingSimplifiedScheduler(Initialize initialize, StartVusers startVusers, Duration duration, StopVusers stopVusers, StartGroup startGroup) {
        ArrayList<Action> schedulerActions = new ArrayList<Action>();
        schedulerActions.add(new Action(initialize));
        schedulerActions.add(new Action(startVusers));
        schedulerActions.add(new Action(duration));
        schedulerActions.add(new Action(stopVusers));
        schedulerActions.add(new Action(startGroup));

        Scheduler scheduler = new Scheduler(schedulerActions);
        String xmlScheduler = scheduler.objectToXML();
        Scheduler scheduler2 = Scheduler.xmlToObject(xmlScheduler);
        String xmlScheduler2 = scheduler2.objectToXML();
        verifyXML(xmlScheduler, xmlScheduler2);
        return scheduler;
    }

    private void verifyingAction(Initialize initialize) {
        Action action = new Action(initialize);
        String xmlAction = action.objectToXML();
        Action action2 = Action.xmlToObject(xmlAction);
        String xmlAction2 = action2.objectToXML();
        verifyXML(xmlAction, xmlAction2);
    }

    private StopVusers verifyingStopVusers(Ramp ramp) {
        int stopVusersVusers = 12;
        StopVusers stopVusers = new StopVusers(StartStopVusersTypeValues.GRADUALLY, stopVusersVusers, ramp);
        String xmlStopVusers = stopVusers.objectToXML();
        StopVusers stopVusers2 = StopVusers.xmlToObject(xmlStopVusers);
        String xmlStopVusers2 = stopVusers2.objectToXML();
        verifyXML(xmlStopVusers, xmlStopVusers2);
        return stopVusers;
    }

    private StartVusers verifyingStartVusers(Ramp ramp) {
        int startVusersVusers = 12;
        StartVusers startVusers = new StartVusers(StartStopVusersTypeValues.GRADUALLY, startVusersVusers, ramp);
        String xmlStartVusers = startVusers.objectToXML();
        StartVusers startVusers2 = StartVusers.xmlToObject(xmlStartVusers);
        String xmlStartVusers2 = startVusers2.objectToXML();
        verifyXML(xmlStartVusers, xmlStartVusers2);
        return startVusers;
    }

    private StartGroup verifyingStartGroup(TimeInterval timeInterval) {
        String startGroupName = "groupName1";
        StartGroup startGroup = new StartGroup(StartGroupTypeValues.IMMEDIATELY, timeInterval, startGroupName);
        String xmlStartGroup = startGroup.objectToXML();
        StartGroup startGroup2 = StartGroup.xmlToObject(xmlStartGroup);
        String xmlStartGroup2 = startGroup2.objectToXML();
        verifyXML(xmlStartGroup, xmlStartGroup2);
        return startGroup;
    }

    private Initialize verifyingInitialize(TimeInterval timeInterval) {
        int durationVusers = 10;

        Initialize initialize = new Initialize(InitializeTypeValues.GRADUALLY, durationVusers, timeInterval, timeInterval);
        String xmlInitialize = initialize.objectToXML();
        Initialize initialize2 = Initialize.xmlToObject(xmlInitialize);
        String xmlInitialize2 = initialize2.objectToXML();
        verifyXML(xmlInitialize, xmlInitialize2);
        return initialize;
    }

    private Duration verifyingDuration(TimeInterval timeInterval) {
        Duration duration = new Duration(DurationTypeValues.UNTIL_COMPLETE, timeInterval);
        String xmlDuration = duration.objectToXML();
        Duration duration2 = Duration.xmlToObject(xmlDuration);
        String xmlDuration2 = duration2.objectToXML();
        verifyXML(xmlDuration, xmlDuration2);
        return duration;
    }

    private Ramp verifyingRamp(TimeInterval timeInterval) {
        int rampVusers = 10;
        Ramp ramp = new Ramp(rampVusers, timeInterval);
        String xmlRamp = ramp.objectToXML();
        Ramp ramp2 = Ramp.xmlToObject(xmlRamp);
        String xmlRamp2 = ramp2.objectToXML();
        verifyXML(xmlRamp, xmlRamp2);
        return ramp;
    }

    private TimeInterval verifyingTimeInterval() {
        int timeIntervalHours = 10;
        int timeIntervalMinutes = 10;
        int timeIntervalSeconds = 10;
        TimeInterval timeInterval = new TimeInterval(timeIntervalHours, timeIntervalMinutes, timeIntervalSeconds);
        String xmlTimeInterval = timeInterval.objectToXML();
        TimeInterval timeInterval2 = TimeInterval.xmlToObject(xmlTimeInterval);
        String xmlTimeInterval2 = timeInterval2.objectToXML();
        verifyXML(xmlTimeInterval, xmlTimeInterval2);
        return timeInterval;
    }

    private void verifyingMonitorOFW() {
        MonitorOFW monitorOFW = new MonitorOFW(2);
        String xmlMonitorOFW = monitorOFW.objectToXML();
        MonitorOFW monitorOFW2 = MonitorOFW.xmlToObject(xmlMonitorOFW);
        String xmlMonitorOFW2 = monitorOFW2.objectToXML();
        verifyXML(xmlMonitorOFW, xmlMonitorOFW2);
    }

    private void verifyingMonitorProfile() {
        MonitorProfile monitorProfile = new MonitorProfile(2);
        String xmlMonitorProfile = monitorProfile.objectToXML();
        MonitorProfile monitorProfile2 = MonitorProfile.xmlToObject(xmlMonitorProfile);
        String xmlMonitorProfile2 = monitorProfile2.objectToXML();
        verifyXML(xmlMonitorProfile, xmlMonitorProfile2);
    }

    private LGDistribution verifyingLGDistribution() {
        LGDistribution lgDistribution = new LGDistribution(LGDistributionTypeValues.ALL_TO_EACH_GROUP, 2);
        String xmlLGDistribution = lgDistribution.objectToXML();
        LGDistribution lgDistribution2 = LGDistribution.xmlToObject(xmlLGDistribution);
        String xmlLGDistribution2 = lgDistribution2.objectToXML();
        verifyXML(xmlLGDistribution, xmlLGDistribution2);
        return lgDistribution;
    }

    private GlobalRTS verifyingGlobalRTS(ArrayList<RTS> rtsList) {
        GlobalRTS globalRTS = new GlobalRTS(rtsList);
        String xmlGlobalRTS = globalRTS.objectToXML();
        GlobalRTS globalRTS2 = GlobalRTS.xmlToObject(xmlGlobalRTS);
        String xmlGlobalRTS2 = globalRTS2.objectToXML();
        verifyXML(xmlGlobalRTS, xmlGlobalRTS2);
        return globalRTS;
    }

    private void verifyingGroup(String groupName1, int vusers, Script script, ArrayList<Host> hosts, RTS rts, String globalRTSFifth, String commandLineName1) {
        Group group = new Group(groupName1, vusers, script, hosts, rts, globalRTSFifth, commandLineName1, null);
        String xmlGroup = group.objectToXML();
        Group group2 = Group.xmlToObject(xmlGroup);
        String xmlGroup2 = group2.objectToXML();
        verifyXML(xmlGroup, xmlGroup2);
    }

    private ArrayList<Host> verifyingHost2() {
        Host firstHost = new Host(HostNameDynamicValues.DOCKER1, HostTypeValues.DYNAMIC);
        String xmlFirstHost = firstHost.objectToXML();
        Host firstHost2 = Host.xmlToObject(xmlFirstHost);
        String xmlFirstHost2 = firstHost2.objectToXML();
        verifyXML(xmlFirstHost, xmlFirstHost2);

        Host secondHost = new Host(HostNameLGValues.LG1, HostTypeValues.AUTOMATCH);
        String xmlSecondHost = secondHost.objectToXML();
        Host secondHost2 = Host.xmlToObject(xmlSecondHost);
        String xmlSecondHost2 = secondHost2.objectToXML();
        verifyXML(xmlSecondHost, xmlSecondHost2);

        ArrayList<Host> hosts = new ArrayList<Host>();
        hosts.add(firstHost);
        hosts.add(secondHost);
        return hosts;
    }

    private Script verifyingScript() {
        int scriptId = 3;
        Script script = new Script(scriptId);
        String xmlScript = script.objectToXML();
        Script script2 = Script.xmlToObject(xmlScript);
        String xmlScript2 = script2.objectToXML();
        verifyXML(xmlScript, xmlScript2);
        return script;
    }

    private RTS verifyingRTS(RTS pacing) {
        RTS rts = pacing;
        String xmlRTS = rts.objectToXML();
        RTS rts2 = RTS.xmlToObject(xmlRTS);
        String xmlRTS2 = rts2.objectToXML();
        verifyXML(xmlRTS, xmlRTS2);
        return rts;
    }

    private Selenium verifyingSelenium() {
        String jrePath = "%JRE_PATH%";
        String classPath = "";
        String testNgFiles = "";

        Selenium selenium = new Selenium(jrePath, classPath, testNgFiles);
        String xmlSelenium = selenium.objectToXML();
        Selenium selenium2 = Selenium.xmlToObject(xmlSelenium);
        String xmlSelenium2 = selenium2.objectToXML();
        verifyXML(xmlSelenium, xmlSelenium2);
        return selenium;
    }

    private JMeter verifyingJMeter() {
        boolean startMeasurements = true;
        String jMeterHomePath = "Some Path";
        boolean jMeterUseDefaultPort = false;
        int jMeterMinPort = 2000;
        int jMeterMaxPort = 3000;

        JMeter jMeter = new JMeter(startMeasurements, jMeterHomePath, jMeterUseDefaultPort, jMeterMinPort, jMeterMaxPort);
        String xmlJmeter = jMeter.objectToXML();
        JMeter jMeter2 = JMeter.xmlToObject(xmlJmeter);
        String xmlJmeter2 = jMeter2.objectToXML();
        verifyXML(xmlJmeter, xmlJmeter2);
        return jMeter;
    }

    private JavaVM verifyingJavaVM(JavaEnvClassPaths javaEnvClassPaths) {
        boolean userSpecifiedJdk = true;
        String jdkHome = "my_jdk_path";
        String javaVmParameters = "some_parameters_here";
        boolean useXboot = true;
        boolean enableClassLoaderPerVuser = false;
        JavaVM javaVM = new JavaVM(javaEnvClassPaths, userSpecifiedJdk, jdkHome, javaVmParameters, useXboot, enableClassLoaderPerVuser);
        String xmljavaVM = javaVM.objectToXML();
        JavaVM javaVM2 = JavaVM.xmlToObject(xmljavaVM);
        String xmljavaVM2 = javaVM2.objectToXML();
        verifyXML(xmljavaVM, xmljavaVM2);
        return javaVM;
    }

    private JavaEnvClassPaths verifyingJavaEnvClassPaths() {
        ArrayList<String> classPaths = new ArrayList<>();
        classPaths.add("user_binaries1\\C__Users_my_user_Desktop_VugenScriptConverterCustomerIssue\\junit-1.0-SNAPSHOT.jar");
        classPaths.add("user_binaries2\\C__Users_my_user_Desktop_VugenScriptConverterCustomerIssue\\junit-1.0-SNAPSHOT.jar");
        JavaEnvClassPaths javaEnvClassPaths = new JavaEnvClassPaths(classPaths);
        String xmlJavaEnvClassPaths = javaEnvClassPaths.objectToXML();
        JavaEnvClassPaths javaEnvClassPaths2 = JavaEnvClassPaths.xmlToObject(xmlJavaEnvClassPaths);
        String xmlJavaEnvClassPaths2 = javaEnvClassPaths2.objectToXML();
        verifyXML(xmlJavaEnvClassPaths, xmlJavaEnvClassPaths2);
        return javaEnvClassPaths;
    }

    private Pacing verifyingPacing(StartNewIteration startNewIteration) {
        Pacing pacing = new Pacing(10, startNewIteration);
        String xmlPacing = pacing.objectToXML();
        Pacing pacing2 = Pacing.xmlToObject(xmlPacing);
        String xmlPacing2 = pacing2.objectToXML();
        verifyXML(xmlPacing, xmlPacing2);
        return pacing;
    }

    private StartNewIteration VerifyingStartNewIteration() {
        int delayAtRangeOfSeconds = 10;
        int delayAtRangeToSeconds = 20;
        StartNewIteration startNewIteration = new StartNewIteration(StartNewIterationTypeValues.RANDOM_INTERVAL, -1, delayAtRangeOfSeconds, delayAtRangeToSeconds);
        String xmlStartNewIteration = startNewIteration.objectToXML();
        StartNewIteration startNewIteration2 = StartNewIteration.xmlToObject(xmlStartNewIteration);
        String xmlStartNewIteration2 = startNewIteration2.objectToXML();
        verifyXML(xmlStartNewIteration, xmlStartNewIteration2);
        return startNewIteration;
    }

    private Log verifyingLog(LogOptions logOptions) {
        Log log = new Log(LogTypeValues.EXTENDED, true, true, true, logOptions);
        String xmlLog = log.objectToXML();
        Log log2 = Log.xmlToObject(xmlLog);
        String xmlLog2 = log2.objectToXML();
        verifyXML(xmlLog, xmlLog2);
        return log;
    }

    private LogOptions verifyingLogOptions() {
        LogOptions logOptions = new LogOptions(LogOptionsTypeValues.ALWAYS, 10);
        String xmlLogOptions = logOptions.objectToXML();
        LogOptions logOptions2 = LogOptions.xmlToObject(xmlLogOptions);
        String xmlLogOptions2 = logOptions2.objectToXML();
        verifyXML(xmlLogOptions, xmlLogOptions2);
        return logOptions;
    }

    private void verifyingHost() {
        Host hostFirst = new Host(HostNameLGValues.LG1, HostTypeValues.AUTOMATCH);
        String xmlHostFirst = hostFirst.objectToXML();
        Host hostFirst2 = Host.xmlToObject(xmlHostFirst);
        String xmlHostFirst2 = hostFirst2.objectToXML();
        verifyXML(xmlHostFirst, xmlHostFirst2);

        Host hostSecond = new Host(HostNameDynamicValues.DOCKER1, HostTypeValues.DYNAMIC);
        String xmlHostSecond = hostSecond.objectToXML();
        Host hostSecond2 = Host.xmlToObject(xmlHostSecond);
        String xmlHostSecond2 = hostSecond2.objectToXML();
        verifyXML(xmlHostSecond, xmlHostSecond2);

        Host hostThird = new Host("MyHostName", HostTypeValues.SPECIFIC);
        String xmlHostThird = hostThird.objectToXML();
        Host hostThird2 = Host.xmlToObject(xmlHostThird);
        String xmlHostThird2 = hostThird2.objectToXML();
        verifyXML(xmlHostThird, xmlHostThird2);
    }

    private GlobalCommandLine verifyingGlobalCommandLine(CommandLine firstCommandLine, CommandLine firstCommandLine2, CommandLine secondCommandLine, CommandLine secondCommandLine2) {
        ArrayList<CommandLine> commandLinesArrayList = new ArrayList<CommandLine>();
        commandLinesArrayList.add(firstCommandLine);
        commandLinesArrayList.add(firstCommandLine2);
        commandLinesArrayList.add(secondCommandLine);
        commandLinesArrayList.add(secondCommandLine2);
        GlobalCommandLine globalCommandLine = new GlobalCommandLine(commandLinesArrayList);
        String xmlGlobalCommandLine = globalCommandLine.objectToXML();
        GlobalCommandLine globalCommandLine2 = GlobalCommandLine.xmlToObject(xmlGlobalCommandLine);
        String xmlGlobalCommandLine2 = globalCommandLine2.objectToXML();
        verifyXML(xmlGlobalCommandLine, xmlGlobalCommandLine2);
        return globalCommandLine;
    }

    private Diagnostics verifyingDiagnostics(J2EEDotNet j2EEDotNet) {
        Diagnostics diagnostics = new Diagnostics(true, true, j2EEDotNet, 34);
        String xmlDiagnostics = diagnostics.objectToXML();
        Diagnostics diagnostics2 = Diagnostics.xmlToObject(xmlDiagnostics);
        String xmlDiagnostics2 = diagnostics2.objectToXML();
        verifyXML(xmlDiagnostics, xmlDiagnostics2);
        return diagnostics;
    }

    private J2EEDotNet verifyingJ2EEDotNet() {
        J2EEDotNet j2EEDotNet = new J2EEDotNet(true, "", false, true);
        String xmlJ2EEDotNet = j2EEDotNet.objectToXML();
        J2EEDotNet j2EEDotNet2 = J2EEDotNet.xmlToObject(xmlJ2EEDotNet);
        String xmlJ2EEDotNet2 = j2EEDotNet2.objectToXML();
        verifyXML(xmlJ2EEDotNet, xmlJ2EEDotNet2);
        return j2EEDotNet;
    }

    private AutomaticTrending verifyingAutomaticTrending() {
        AutomaticTrending automaticTrending = new AutomaticTrending(2, 10, TrendRangeTypeValues.COMPLETE_RUN, MaxRunsReachedOptionValues.DO_NOT_PUBLISH_ADDITIONAL_RUNS);
        String xmlAutomaticTrending = automaticTrending.objectToXML();
        AutomaticTrending automaticTrending2 = AutomaticTrending.xmlToObject(xmlAutomaticTrending);
        String xmlAutomaticTrending2 = automaticTrending2.objectToXML();
        verifyXML(xmlAutomaticTrending, xmlAutomaticTrending2);
        return automaticTrending;
    }

    private AnalysisTemplate verifyingAnalysisTemplate() {
        AnalysisTemplate analysisTemplate = new AnalysisTemplate(4);
        String xmlAnalysisTemplate = analysisTemplate.objectToXML();
        AnalysisTemplate analysisTemplate2 = AnalysisTemplate.xmlToObject(xmlAnalysisTemplate);
        String xmlAnalysisTemplate2 = analysisTemplate2.objectToXML();
        verifyXML(xmlAnalysisTemplate, xmlAnalysisTemplate2);
        return analysisTemplate;
    }

    private void verifyXML(String xmlFromFirstObject, String xmlFromFirstObject2) {
        verifyXML(xmlFromFirstObject, xmlFromFirstObject2, false);
    }

    private void verifyXML(String xmlFromFirstObject, String xmlFromFirstObject2, boolean publish) {
        if (!xmlFromFirstObject.equals(xmlFromFirstObject2))
            System.out.println(String.format("objectToXML doesn't work: original is: \n %s \n and copy is: \n %s \n", xmlFromFirstObject, xmlFromFirstObject2));
        else if (publish)
            System.out.println(xmlFromFirstObject);
    }


}
