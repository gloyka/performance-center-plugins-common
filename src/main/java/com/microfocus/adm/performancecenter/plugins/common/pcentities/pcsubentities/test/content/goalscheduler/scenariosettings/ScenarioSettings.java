package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.runtimeaftergoalachieved.RunTimeAfterGoalAchieved;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.GoalCannotBeReachedActionValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ScenarioSettings")
public class ScenarioSettings {


    /*
    Required. One of:
        StopScenarioAndSaveResults
        ContinueWithoutReaching.
    */
    @XmlElement
    private String GoalCannotBeReachedAction;

    @XmlElement
    private RunTimeAfterGoalAchieved RunTimeAfterGoalAchieved;

    @XmlElement
    private boolean ReceiveNotification;

    public ScenarioSettings() { }

    public ScenarioSettings(String goalCannotBeReachedAction, RunTimeAfterGoalAchieved runTimeAfterGoalAchieved, boolean receiveNotification) {
        setGoalCannotBeReachedAction(goalCannotBeReachedAction);
        setRunTimeAfterGoalAchieved(runTimeAfterGoalAchieved);
        setReceiveNotification(receiveNotification);
    }

    public ScenarioSettings(GoalCannotBeReachedActionValues goalCannotBeReachedAction, RunTimeAfterGoalAchieved runTimeAfterGoalAchieved, boolean receiveNotification) {
        setGoalCannotBeReachedAction(goalCannotBeReachedAction);
        setRunTimeAfterGoalAchieved(runTimeAfterGoalAchieved);
        setReceiveNotification(receiveNotification);
    }

    public void setGoalCannotBeReachedAction(String goalCannotBeReachedAction) {
        this.GoalCannotBeReachedAction = goalCannotBeReachedAction;
    }

    public void setGoalCannotBeReachedAction(GoalCannotBeReachedActionValues goalCannotBeReachedAction) {
        this.GoalCannotBeReachedAction = goalCannotBeReachedAction.value();
    }

    @Override
    public String toString() {
        return "ScenarioSettings{" + "GoalCannotBeReachedAction = " + GoalCannotBeReachedAction +
                ", RunTimeAfterGoalAchieved = " + RunTimeAfterGoalAchieved +
                ", ReceiveNotification = " + ReceiveNotification +
                "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("ScenarioSettings", ScenarioSettings.class);
        xstream.aliasField("GoalCannotBeReachedAction", ScenarioSettings.class, "GoalCannotBeReachedAction");
        xstream.aliasField("RunTimeAfterGoalAchieved", ScenarioSettings.class, "RunTimeAfterGoalAchieved");
        xstream.aliasField("ReceiveNotification", ScenarioSettings.class, "ReceiveNotification");
        xstream.aliasField("ScenarioSettings", ScenarioSettings.class, "ScenarioSettings");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static ScenarioSettings xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ScenarioSettings" , ScenarioSettings.class);
        xstream.setClassLoader(ScenarioSettings.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ScenarioSettings)xstream.fromXML(xml);
    }

}
