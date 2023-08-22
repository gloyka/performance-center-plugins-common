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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.host;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.HostNameDynamicValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.HostNameLGValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.HostTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Host")
public class Host {

    @XmlElement
    private String Name;

    /*
    specific
    automatch (named LG1, LG2, and so on)
    dynamic (named DOCKER1, DOCKER2, and so on)
    */
    @XmlElement
    private String Type;

    public Host() {
    }

    public Host(String name, String type) {
        setName(name);
        setType(type);
    }

    public Host(String name, HostTypeValues type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameLGValues name, String type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameLGValues name, HostTypeValues type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameDynamicValues name, String type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameDynamicValues name, HostTypeValues type) {
        setName(name);
        setType(type);
    }

    public static Host xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Host", Host.class);
        xstream.setClassLoader(Host.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Host) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Host{" + "Name = " + Name +
                ", Type = " + Type + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Host", Host.class);
        xstream.aliasField("Name", Host.class, "Name");
        xstream.aliasField("Type", Host.class, "Type");
        xstream.aliasField("Host", Host.class, "Host");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setName(HostNameLGValues name) {
        this.Name = name.value();
    }

    public void setName(HostNameDynamicValues name) {
        this.Name = name.value();
    }

    public String getType() {
        return Type;
    }

    public void setType(HostTypeValues type) {
        this.Type = type.value();

    }

    public void setType(String type) {
        this.Type = type;
    }
}
