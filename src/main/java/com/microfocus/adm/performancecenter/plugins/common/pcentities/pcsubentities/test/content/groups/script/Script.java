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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.script;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Script")
public class Script {
    @XmlElement
    private String ID;

    @XmlElement
    private String ProtocolType;

    public Script() {
    }

    public Script(int ID) {
        setID(ID);
    }

    public Script(int ID, String protocolType) {
        setID(ID);
        setProtocolType(protocolType);
    }

    public static Script xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script", Script.class);
        xstream.setClassLoader(Script.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Script) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Script{" + "ID = " + ID +
                "ProtocolType = " + ProtocolType + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script", Script.class);
        xstream.aliasField("ID", Script.class, "ID");

        xstream.omitField(Script.class, "ProtocolType");

        xstream.aliasField("Script", Script.class, "Script");
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

    public String getProtocolType() {
        return ProtocolType;
    }

    public void setProtocolType(String protocolType) {
        ProtocolType = protocolType;
    }
}