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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.runtimeaftergoalachieved;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RunTimeAfterGoalAchieved")
public class RunTimeAfterGoalAchieved {

    @XmlElement
    private String Minutes;

    public RunTimeAfterGoalAchieved() {
    }

    public RunTimeAfterGoalAchieved(int minutes) {
        setMinutes(minutes);
    }

    public static RunTimeAfterGoalAchieved xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("RunTimeAfterGoalAchieved", RunTimeAfterGoalAchieved.class);
        xstream.setClassLoader(RunTimeAfterGoalAchieved.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (RunTimeAfterGoalAchieved) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "RunTimeAfterGoalAchieved{" + "Minutes = " + Minutes +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("RunTimeAfterGoalAchieved", RunTimeAfterGoalAchieved.class);
        xstream.aliasField("Minutes", RunTimeAfterGoalAchieved.class, "Minutes");
        xstream.aliasField("RunTimeAfterGoalAchieved", RunTimeAfterGoalAchieved.class, "RunTimeAfterGoalAchieved");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {
        this.Minutes = Common.integerToString(minutes);
    }

    public void setMinutes(String minutes) {
        Minutes = minutes;
    }
}


