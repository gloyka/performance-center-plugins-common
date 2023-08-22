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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.commandline;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CommandLine")
public class CommandLine {

    @XmlElement
    @XStreamAlias("Name")
    private String Name;

    @XmlElement
    @XStreamAlias("Value")
    private String Value;

    public CommandLine() {
    }

    public CommandLine(String name, String value) {
        setName(name);
        setValue(value);
    }

    public static CommandLine xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("CommandLine", CommandLine.class);
        xstream.setClassLoader(CommandLine.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (CommandLine) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "CommandLine{" +
                "Name = " + Name +
                ", Value = " + Value +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("CommandLine", CommandLine.class);
        xstream.aliasField("Name", CommandLine.class, "Name");
        xstream.aliasField("Value", CommandLine.class, "Value");
        xstream.aliasField("CommandLine", CommandLine.class, "CommandLine");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
