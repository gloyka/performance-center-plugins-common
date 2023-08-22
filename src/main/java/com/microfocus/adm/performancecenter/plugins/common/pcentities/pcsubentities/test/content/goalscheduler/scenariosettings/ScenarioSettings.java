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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.runtimeaftergoalachieved.RunTimeAfterGoalAchieved;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.GoalCannotBeReachedActionValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ScenarioSettings")
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

    public ScenarioSettings() {
    }

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

    public static ScenarioSettings xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ScenarioSettings", ScenarioSettings.class);
        xstream.setClassLoader(ScenarioSettings.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ScenarioSettings) xstream.fromXML(xml);
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

    public String getGoalCannotBeReachedAction() {
        return GoalCannotBeReachedAction;
    }

    public void setGoalCannotBeReachedAction(String goalCannotBeReachedAction) {
        this.GoalCannotBeReachedAction = goalCannotBeReachedAction;
    }

    public void setGoalCannotBeReachedAction(GoalCannotBeReachedActionValues goalCannotBeReachedAction) {
        this.GoalCannotBeReachedAction = goalCannotBeReachedAction.value();
    }

    public RunTimeAfterGoalAchieved getRunTimeAfterGoalAchieved() {
        return RunTimeAfterGoalAchieved;
    }

    public void setRunTimeAfterGoalAchieved(RunTimeAfterGoalAchieved runTimeAfterGoalAchieved) {
        RunTimeAfterGoalAchieved = runTimeAfterGoalAchieved;
    }

    public boolean isReceiveNotification() {
        return ReceiveNotification;
    }

    public void setReceiveNotification(boolean receiveNotification) {
        ReceiveNotification = receiveNotification;
    }
}
