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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalvirtualusers;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GoalVirtualUsers")
public class GoalVirtualUsers {

    @XmlElement
    private String TargetVusersNumber;

    public GoalVirtualUsers() {
    }

    public GoalVirtualUsers(int targetVusersNumber) {
        setTargetVusersNumber(targetVusersNumber);
    }

    public static GoalVirtualUsers xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GoalVirtualUsers", GoalVirtualUsers.class);
        xstream.setClassLoader(GoalVirtualUsers.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GoalVirtualUsers) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "GoalVirtualUsers{" +
                "TargetVusersNumber = " + TargetVusersNumber +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("GoalVirtualUsers", GoalVirtualUsers.class);
        xstream.aliasField("TargetVusersNumber", GoalVirtualUsers.class, "TargetVusersNumber");
        xstream.aliasField("GoalVirtualUsers", GoalVirtualUsers.class, "GoalVirtualUsers");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getTargetVusersNumber() {
        return TargetVusersNumber;
    }

    public void setTargetVusersNumber(int targetVusersNumber) {
        this.TargetVusersNumber = Common.integerToString(targetVusersNumber);
    }

    public void setTargetVusersNumber(String targetVusersNumber) {
        TargetVusersNumber = targetVusersNumber;
    }
}
