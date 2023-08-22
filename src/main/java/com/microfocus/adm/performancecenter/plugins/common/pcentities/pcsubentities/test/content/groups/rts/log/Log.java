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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions.LogOptions;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.LogTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Log")
public class Log {

    @XmlAttribute
    private String Type;

    @XmlElement
    private boolean ParametersSubstituion;

    @XmlElement
    private boolean DataReturnedByServer;

    @XmlElement
    private boolean AdvanceTrace;

    @XmlElement
    private LogOptions LogOptions;

    public Log() {
        setType(LogTypeValues.DISABLE);
        setParametersSubstituion(false);
        setDataReturnedByServer(false);
        setAdvanceTrace(false);
    }

    public Log(LogTypeValues type, boolean parametersSubstituion, boolean dataReturnedByServer, boolean advanceTrace, LogOptions logOptions) {
        setType(type);
        setParametersSubstituion(parametersSubstituion);
        setDataReturnedByServer(dataReturnedByServer);
        setAdvanceTrace(advanceTrace);
        setLogOptions(logOptions);
    }

    public Log(String type, boolean parametersSubstituion, boolean dataReturnedByServer, boolean advanceTrace, LogOptions logOptions) {
        setType(type);
        setParametersSubstituion(parametersSubstituion);
        setDataReturnedByServer(dataReturnedByServer);
        setAdvanceTrace(advanceTrace);
        setLogOptions(logOptions);
    }

    public static Log xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("Type", Log.class, "Type");
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.alias("Log", Log.class);
        xstream.setClassLoader(Log.class.getClassLoader());
        return (Log) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Log{" + "Type = " + Type +
                ", ParametersSubstituion = " + ParametersSubstituion +
                ", DataReturnedByServer = " + DataReturnedByServer +
                ", AdvanceTrace = " + AdvanceTrace +
                ", LogOptions = " + LogOptions +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Log", Log.class);
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("Type", Log.class, "Type");
        xstream.aliasField("ParametersSubstituion", Log.class, "ParametersSubstituion");
        xstream.aliasField("DataReturnedByServer", Log.class, "DataReturnedByServer");
        xstream.aliasField("AdvanceTrace", Log.class, "AdvanceTrace");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.aliasField("Log", Log.class, "Log");
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(LogTypeValues type) {
        this.Type = type.value();
    }

    public boolean isParametersSubstituion() {
        return ParametersSubstituion;
    }

    public void setParametersSubstituion(boolean parametersSubstituion) {
        ParametersSubstituion = parametersSubstituion;
    }

    public boolean isDataReturnedByServer() {
        return DataReturnedByServer;
    }

    public void setDataReturnedByServer(boolean dataReturnedByServer) {
        DataReturnedByServer = dataReturnedByServer;
    }

    public boolean isAdvanceTrace() {
        return AdvanceTrace;
    }

    public void setAdvanceTrace(boolean advanceTrace) {
        AdvanceTrace = advanceTrace;
    }

    public LogOptions getLogOptions() {
        return LogOptions;
    }

    public void setLogOptions(LogOptions logOptions) {
        LogOptions = logOptions;
    }
}