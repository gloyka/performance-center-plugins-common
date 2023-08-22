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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.commandline.CommandLine;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GlobalCommandLine")
public class GlobalCommandLine {

    @XmlElement
    @XStreamImplicit
    private ArrayList<CommandLine> CommandLine;

    public GlobalCommandLine() {
    }

    public GlobalCommandLine(ArrayList<CommandLine> commandLine) {
        setCommandLine(commandLine);
    }

    public static GlobalCommandLine xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GlobalCommandLine", GlobalCommandLine.class);

        xstream.addImplicitCollection(GlobalCommandLine.class, "CommandLine");
        xstream.alias("CommandLine", CommandLine.class, CommandLine.class);

        xstream.aliasField("GlobalCommandLine", GlobalCommandLine.class, "GlobalCommandLine");
        xstream.setClassLoader(GlobalCommandLine.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GlobalCommandLine) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "GlobalCommandLine{" +
                "CommandLine = " + CommandLine +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GlobalCommandLine", GlobalCommandLine.class);

        xstream.addImplicitCollection(GlobalCommandLine.class, "CommandLine");
        xstream.alias("CommandLine", CommandLine.class, CommandLine.class);

        xstream.aliasField("GlobalCommandLine", GlobalCommandLine.class, "GlobalCommandLine");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public ArrayList<CommandLine> getCommandLine() {
        return CommandLine;
    }

    public void setCommandLine(ArrayList<CommandLine> commandLine) {
        CommandLine = commandLine;
    }
}
