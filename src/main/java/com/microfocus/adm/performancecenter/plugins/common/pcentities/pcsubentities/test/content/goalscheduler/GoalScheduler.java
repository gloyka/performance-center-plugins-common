package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.ScenarioSettings;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalvirtualusers.GoalVirtualUsers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalhitspersecond.GoalHitsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goaltransactionspersecond.GoalTransactionsPerSecond;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.GoalTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="GoalScheduler")
public class GoalScheduler {

    @XmlElement
    private String GoalProfileName;

    /*
    Required. Goal types can be:
        VirtualUsers
        HitsPerSecond
        TransactionsPerSecond
    */
    @XmlElement
    private String GoalType;

    /*Mandatory when GoalType is HitsPerSecond*/
    @XmlElement
    private GoalHitsPerSecond GoalHitsPerSecond;

    /*Mandatory when GoalType is TransactionsPerSecond */
    @XmlElement
    private GoalTransactionsPerSecond GoalTransactionsPerSecond;

    @XmlElement
    private GoalVirtualUsers GoalVirtualUsers;

    @XmlElement
    private boolean DoNotChangeScriptThinkTime;

    @XmlElement
    private ScenarioSettings ScenarioSettings;


    public GoalScheduler() { }


    public GoalScheduler(String goalProfileName, String goalType, GoalHitsPerSecond goalHitsPerSecond, GoalTransactionsPerSecond goalTransactionsPerSecond, GoalVirtualUsers goalVirtualUsers, boolean doNotChangeScriptThinkTime, ScenarioSettings scenarioSettings) {
        setGoalProfileName(goalProfileName);
        setGoalType(goalType);
        setGoalHitsPerSecond(goalHitsPerSecond);
        setGoalTransactionsPerSecond(goalTransactionsPerSecond);
        setGoalVirtualUsers(goalVirtualUsers);
        setDoNotChangeScriptThinkTime(doNotChangeScriptThinkTime);
        setScenarioSettings(scenarioSettings);
    }


    public GoalScheduler(String goalProfileName, GoalTypeValues goalType, GoalHitsPerSecond goalHitsPerSecond, GoalTransactionsPerSecond goalTransactionsPerSecond, GoalVirtualUsers goalVirtualUsers, boolean doNotChangeScriptThinkTime, ScenarioSettings scenarioSettings) {
        setGoalProfileName(goalProfileName);
        setGoalType(goalType);
        setGoalHitsPerSecond(goalHitsPerSecond);
        setGoalTransactionsPerSecond(goalTransactionsPerSecond);
        setGoalVirtualUsers(goalVirtualUsers);
        setDoNotChangeScriptThinkTime(doNotChangeScriptThinkTime);
        setScenarioSettings(scenarioSettings);
    }

    public void setGoalType (String goalType) {
        this.GoalType = goalType;
    }

    public void setGoalType (GoalTypeValues goalType) {
        this.GoalType = goalType.value();
    }

    @Override
    public String toString() {
        return "GoalScheduler{" + "GoalProfileName = " + GoalProfileName +
                ", GoalType = " + GoalType +
                ", GoalHitsPerSecond = " + GoalHitsPerSecond +
                ", GoalTransactionsPerSecond = " + GoalTransactionsPerSecond +
                ", GoalVirtualUsers = " + GoalVirtualUsers +
                ", DoNotChangeScriptThinkTime = " + DoNotChangeScriptThinkTime +
                ", ScenarioSettings = " + ScenarioSettings +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("GoalScheduler", GoalScheduler.class);
        xstream.aliasField("GoalProfileName", GoalScheduler.class, "GoalProfileName");
        xstream.aliasField("GoalType", GoalScheduler.class, "GoalType");
        xstream.aliasField("GoalHitsPerSecond", GoalScheduler.class, "GoalHitsPerSecond");
        xstream.aliasField("GoalTransactionsPerSecond", GoalScheduler.class, "GoalTransactionsPerSecond");
        xstream.aliasField("GoalVirtualUsers", GoalScheduler.class, "GoalVirtualUsers");
        xstream.aliasField("DoNotChangeScriptThinkTime", GoalScheduler.class, "DoNotChangeScriptThinkTime");
        xstream.aliasField("ScenarioSettings", GoalScheduler.class, "ScenarioSettings");
        xstream.aliasField("GoalScheduler", GoalScheduler.class, "GoalScheduler");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static GoalScheduler xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GoalScheduler" , GoalScheduler.class);
        xstream.setClassLoader(GoalScheduler.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GoalScheduler)xstream.fromXML(xml);
    }

}
