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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorprofiles;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MonitorProfile")
public class MonitorProfile {

    @XmlElement
    private String ID;

    public MonitorProfile() {
    }

    public MonitorProfile(int ID) {
        setID(ID);
    }

    public static MonitorProfile xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("MonitorProfile", MonitorProfile.class);
        xstream.setClassLoader(MonitorProfile.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (MonitorProfile) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "MonitorProfile{" + "ID = " + ID;
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("MonitorProfile", MonitorProfile.class);
        xstream.aliasField("ID", MonitorProfile.class, "ID");
        xstream.aliasField("MonitorProfile", MonitorProfile.class, "MonitorProfile");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getID() {
        return ID;
    }

    public void setID(int value) {
        this.ID = Common.integerToString(value);
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
