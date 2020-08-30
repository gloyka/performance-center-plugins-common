package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content;

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
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions.LogOptions;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime.ThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.script.Script;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.lgdistribution.LGDistribution;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorprofiles.MonitorProfile;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorsofw.MonitorOFW;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.Scheduler;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.Action;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.duration.Duration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.initialize.Initialize;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startgroup.StartGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers.StartVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.stopvusers.StopVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.SLA;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.workloadtype.WorkloadType;
import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name="Content")
public class Content
{
    //@XmlAttribute
    private String xmlns;

    //@XmlElement(required = false)
    private String Controller;

    //@XmlElement
    private WorkloadType WorkloadType;

    //@XmlElement
    private LGDistribution LGDistribution;

    //@XmlElement
    private ArrayList<MonitorProfile> MonitorProfiles;

    //@XmlElement
    private ArrayList<Group> Groups;

    //@XmlElement
    private Scheduler Scheduler;

    //@XmlElement
    private AnalysisTemplate AnalysisTemplate;

    //@XmlElement
    private SLA SLA;

    //@XmlElement
    private Diagnostics Diagnostics;

    //@XmlElement
    private AutomaticTrending AutomaticTrending;

    //@XmlElement
    private ArrayList<MonitorOFW>  MonitorsOFW;

    //@XmlElement
    private GlobalCommandLine GlobalCommandLine;

    //@XmlElement
    private GlobalRTS GlobalRTS;

    private ElasticLoadGeneratorConfiguration ElasticLoadGeneratorConfiguration;

    private ElasticControllerConfiguration ElasticControllerConfiguration;

    public Content() {}

    public Content(WorkloadType workloadType, LGDistribution lgDistribution, ArrayList<MonitorProfile> monitorProfiles,
                   ArrayList<Group> groups, Scheduler scheduler, AnalysisTemplate analysisTemplate, AutomaticTrending automaticTrending,
                   ArrayList<MonitorOFW> monitorsOFW, SLA sla, Diagnostics diagnostics, GlobalCommandLine globalCommandLine, GlobalRTS globalRTS,
                   ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration ,ElasticControllerConfiguration elasticControllerConfiguration) {
        setWorkloadType(workloadType);
        setLGDistribution(lgDistribution);
        setMonitorProfiles(monitorProfiles);
        setGroups(groups);
        setScheduler(scheduler);
        setAnalysisTemplate(analysisTemplate);
        setAutomaticTrending(automaticTrending);
        setMonitorsOFW(monitorsOFW);
        setSLA(sla);
        setDiagnostics(diagnostics);
        setGlobalCommandLine(globalCommandLine);
        setGlobalRTS(globalRTS);
        setElasticLoadGeneratorConfiguration(elasticLoadGeneratorConfiguration);
        setElasticControllerConfiguration(elasticControllerConfiguration);
    }

    public Content(String controller, WorkloadType workloadType, LGDistribution lgDistribution, ArrayList<MonitorProfile> monitorProfiles,
                   ArrayList<Group> groups, Scheduler scheduler, AnalysisTemplate analysisTemplate, AutomaticTrending automaticTrending,
                   ArrayList<MonitorOFW> monitorsOFW, SLA sla, Diagnostics diagnostics, GlobalCommandLine globalCommandLine, GlobalRTS globalRTS,
                   ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration, ElasticControllerConfiguration elasticControllerConfiguration) {
        setController(controller);
        setWorkloadType(workloadType);
        setLGDistribution(lgDistribution);
        setMonitorProfiles(monitorProfiles);
        setGroups(groups);
        setScheduler(scheduler);
        setAnalysisTemplate(analysisTemplate);
        setAutomaticTrending(automaticTrending);
        setMonitorsOFW(monitorsOFW);
        setSLA(sla);
        setDiagnostics(diagnostics);
        setGlobalCommandLine(globalCommandLine);
        setGlobalRTS(globalRTS);
        setElasticLoadGeneratorConfiguration(elasticLoadGeneratorConfiguration);
        setElasticControllerConfiguration(elasticControllerConfiguration);
    }


    @Override
    public String toString() {
        return "Content{" + "Controller = " + Controller +
                ", WorkloadType = " + WorkloadType +
                ", LGDistribution = " + LGDistribution +
                ", MonitorProfiles = " + MonitorProfiles +
                ", Groups = " + Groups +
                ", SimplifiedScheduler = " + Scheduler +
                ", AnalysisTemplate = " + AnalysisTemplate +
                ", AutomaticTrending = " + AutomaticTrending  +
                ", MonitorsOFW = " + MonitorsOFW +
                ", SLA = " + SLA +
                ", Diagnostics = " + Diagnostics +
                ", GlobalCommandLine = " + GlobalCommandLine +
                ", GlobalRTS = " + GlobalRTS +
                ", ElasticLoadGeneratorConfiguration" + ElasticLoadGeneratorConfiguration +
                ", ElasticLoadGeneratorConfiguration" + ElasticControllerConfiguration +
                "}";
    }

    public String objectToXML(boolean withXmlns ) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Content", Content.class);
        if(withXmlns) {
            xmlns= PcRestProxy.PC_API_XMLNS;
            xstream.useAttributeFor(Content.class, "xmlns");
        }
        xstream.aliasField("Controller", Content.class, "Controller");
        xstream.aliasField("WorkloadType", Content.class, "WorkloadType");
        xstream.aliasField("LGDistribution", Content.class, "LGDistribution");
        xstream.aliasField("MonitorProfiles", Content.class, "MonitorProfiles");
        xstream.aliasField("Groups", Content.class, "Groups");
        xstream.aliasField("AnalysisTemplate", Content.class, "AnalysisTemplate");
        xstream.aliasField("MonitorsOFW", Content.class, "MonitorsOFW");
        xstream.aliasField("SLA", Content.class, "SLA");
        xstream.aliasField("Diagnostics", Content.class, "Diagnostics");
        xstream.aliasField("AutomaticTrending", Content.class, "AutomaticTrending");
        xstream.aliasField("ElasticLoadGeneratorConfiguration", Content.class, "ElasticLoadGeneratorConfiguration");
        xstream.aliasField("ElasticControllerConfiguration", Content.class, "ElasticControllerConfiguration");

        //Content
        xstream.alias("MonitorProfile", MonitorProfile.class,MonitorProfile.class);
        xstream.alias("Group", Group.class,Group.class);
        xstream.alias("MonitorOFW", MonitorOFW.class, MonitorOFW.class);

        //GlobalCommandLine
        xstream.addImplicitCollection(GlobalCommandLine.class, "CommandLine");
        xstream.alias("CommandLine", CommandLine.class,CommandLine.class);

        //GlobalRTS
        xstream.addImplicitCollection(GlobalRTS.class, "RTS");
        xstream.alias("RTS", RTS.class,RTS.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");

        //Groups
        xstream.aliasField("Pacing", RTS.class, "Pacing");
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("ThinkTime", RTS.class, "ThinkTime");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.aliasField("JMeter", RTS.class, "JMeter");
        xstream.alias("Host", Host.class,Host.class);
        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");
        xstream.alias("Action", Action.class, Action.class);
        xstream.omitField(Script.class, "ProtocolType" );

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        //SimplifiedScheduler
        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");
        xstream.alias("Action", Action.class, Action.class);

        //SLA
        xstream.alias("Transaction", Transaction.class,Transaction.class);
        xstream.alias("Between", Between.class,Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.aliasField("Content", Content.class, "Content");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Content xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Content" , Content.class);

        //Content
        xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("MonitorProfile", MonitorProfile.class,MonitorProfile.class);
        xstream.alias("Group", Group.class,Group.class);
        xstream.alias("MonitorOFW", MonitorOFW.class, MonitorOFW.class);

        //GlobalCommandLine
        xstream.addImplicitCollection(GlobalCommandLine.class, "CommandLine");
        xstream.alias("CommandLine", CommandLine.class,CommandLine.class);

        //GlobalRTS
        xstream.addImplicitCollection(GlobalRTS.class, "RTS");
        xstream.alias("RTS", RTS.class,RTS.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");

        //Groups
        xstream.aliasField("Pacing", RTS.class, "Pacing");
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("ThinkTime", RTS.class, "ThinkTime");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.aliasField("JMeter", RTS.class, "JMeter");
        xstream.alias("Host", Host.class,Host.class);
        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");
        xstream.alias("Action", Action.class, Action.class);

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        //SimplifiedScheduler
        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");
        xstream.alias("Action", Action.class, Action.class);

        //SLA
        xstream.alias("Transaction", Transaction.class,Transaction.class);
        xstream.alias("Between", Between.class,Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.setClassLoader(Content.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Content)xstream.fromXML(xml);
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getController() {
        return Controller;
    }

    public void setController(String controller) {
        Controller = controller;
    }

    public WorkloadType getWorkloadType() {
        return WorkloadType;
    }

    public void setWorkloadType(WorkloadType workloadType) {
        WorkloadType = workloadType;
    }

    public LGDistribution getLGDistribution() {
        return LGDistribution;
    }

    public void setLGDistribution(LGDistribution LGDistribution) {
        this.LGDistribution = LGDistribution;
    }

    public ArrayList<MonitorProfile> getMonitorProfiles() {
        return MonitorProfiles;
    }

    public void setMonitorProfiles(ArrayList<MonitorProfile> monitorProfiles) {
        MonitorProfiles = monitorProfiles;
    }

    public ArrayList<Group> getGroups() {
        return Groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        Groups = groups;
    }

    public Scheduler getScheduler() {
        return Scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        Scheduler = scheduler;
    }

    public AnalysisTemplate getAnalysisTemplate() {
        return AnalysisTemplate;
    }

    public void setAnalysisTemplate(AnalysisTemplate analysisTemplate) {
        AnalysisTemplate = analysisTemplate;
    }

    public SLA getSLA() {
        return SLA;
    }

    public void setSLA(SLA SLA) {
        this.SLA = SLA;
    }

    public Diagnostics getDiagnostics() {
        return Diagnostics;
    }

    public void setDiagnostics(Diagnostics diagnostics) {
        Diagnostics = diagnostics;
    }

    public AutomaticTrending getAutomaticTrending() {
        return AutomaticTrending;
    }

    public void setAutomaticTrending(AutomaticTrending automaticTrending) {
        AutomaticTrending = automaticTrending;
    }

    public ArrayList<MonitorOFW> getMonitorsOFW() {
        return MonitorsOFW;
    }

    public void setMonitorsOFW(ArrayList<MonitorOFW> monitorsOFW) {
        MonitorsOFW = monitorsOFW;
    }

    public GlobalCommandLine getGlobalCommandLine() {
        return GlobalCommandLine;
    }

    public void setGlobalCommandLine(GlobalCommandLine globalCommandLine) {
        GlobalCommandLine = globalCommandLine;
    }

    public GlobalRTS getGlobalRTS() {
        return GlobalRTS;
    }

    public void setGlobalRTS(GlobalRTS globalRTS) {
        GlobalRTS = globalRTS;
    }

    public ElasticLoadGeneratorConfiguration getElasticLoadGeneratorConfiguration() {
        return ElasticLoadGeneratorConfiguration;
    }

    public void setElasticLoadGeneratorConfiguration(ElasticLoadGeneratorConfiguration elasticLoadGeneratorConfiguration) {
        ElasticLoadGeneratorConfiguration = elasticLoadGeneratorConfiguration;
    }

    public ElasticControllerConfiguration getElasticControllerConfiguration() {
        return ElasticControllerConfiguration;
    }

    public void setElasticControllerConfiguration(ElasticControllerConfiguration elasticControllerConfiguration) {
        ElasticControllerConfiguration = elasticControllerConfiguration;
    }
}