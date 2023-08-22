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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "JMeter")
public class JMeter {

    @XmlElement
    private boolean StartMeasurements;

    @XmlElement
    private String JMeterHomePath;

    @XmlElement
    private boolean JMeterUseDefaultPort;

    @XmlElement
    private String JMeterMinPort;

    @XmlElement
    private String JMeterMaxPort;

    @XmlElement
    private boolean JMeterDistributeMode;

    @XmlElement
    private String JMeterAdditionalProperties;

    public JMeter() {
        setStartMeasurements(true);
        setJMeterUseDefaultPort(true);
        setJMeterDistributeMode(false);
    }

    public JMeter(boolean startMeasurements, String jMeterHomePath, boolean jMeterUseDefaultPort, int jMeterMinPort, int jMeterMaxPort) {
        setStartMeasurements(startMeasurements);
        setJMeterHomePath(jMeterHomePath);
        setJMeterUseDefaultPort(jMeterUseDefaultPort);
        setJMeterMinPort(jMeterMinPort);
        setJMeterMaxPort(jMeterMaxPort);
    }

    public JMeter(boolean startMeasurements, String jMeterHomePath, boolean jMeterUseDefaultPort, int jMeterMinPort, int jMeterMaxPort, boolean jMeterDistributeMode) {
        setStartMeasurements(startMeasurements);
        setJMeterHomePath(jMeterHomePath);
        setJMeterUseDefaultPort(jMeterUseDefaultPort);
        setJMeterMinPort(jMeterUseDefaultPort ? 0 : jMeterMinPort);
        setJMeterMaxPort(jMeterUseDefaultPort ? 0 : jMeterMaxPort);
        setJMeterDistributeMode(jMeterDistributeMode);
    }

    public JMeter(boolean startMeasurements, String jMeterHomePath, boolean jMeterUseDefaultPort, int jMeterMinPort, int jMeterMaxPort, boolean jMeterDistributeMode, String jMeterAdditionalProperties) {
        setStartMeasurements(startMeasurements);
        setJMeterHomePath(jMeterHomePath);
        setJMeterUseDefaultPort(jMeterUseDefaultPort);
        setJMeterMinPort(jMeterUseDefaultPort ? 0 : jMeterMinPort);
        setJMeterMaxPort(jMeterUseDefaultPort ? 0 : jMeterMaxPort);
        setJMeterDistributeMode(jMeterDistributeMode);
        setJMeterAdditionalProperties(jMeterAdditionalProperties);
    }

    public static JMeter xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JMeter", JMeter.class);
        xstream.setClassLoader(JMeter.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (JMeter) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "JMeter{" + "StartMeasurements = " + StartMeasurements +
                ", JMeterHomePath = " + JMeterHomePath +
                ", JMeterUseDefaultPort = " + JMeterUseDefaultPort +
                ", JMeterMinPort = " + JMeterMinPort +
                ", JMeterMaxPort = " + JMeterMaxPort +
                ", JMeterDistributeMode = " + JMeterDistributeMode +
                ", JMeterAdditionalProperties = " + JMeterAdditionalProperties +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JMeter", JMeter.class);
        xstream.aliasField("StartMeasurements", JMeter.class, "StartMeasurements");
        xstream.aliasField("JMeterHomePath", JMeter.class, "JMeterHomePath");
        xstream.aliasField("JMeterUseDefaultPort", JMeter.class, "JMeterUseDefaultPort");
        xstream.aliasField("JMeterMinPort", JMeter.class, "JMeterMinPort");
        xstream.aliasField("JMeterMaxPort", JMeter.class, "JMeterMaxPort");
        xstream.aliasField("JMeterDistributeMode", JMeter.class, "JMeterDistributeMode");
        xstream.aliasField("JMeterAdditionalProperties", JMeter.class, "JMeterAdditionalProperties");
        xstream.aliasField("JMeter", JMeter.class, "JMeter");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public boolean isStartMeasurements() {
        return StartMeasurements;
    }

    public void setStartMeasurements(boolean startMeasurements) {
        StartMeasurements = startMeasurements;
    }

    public String getJMeterHomePath() {
        return JMeterHomePath;
    }

    public void setJMeterHomePath(String JMeterHomePath) {
        this.JMeterHomePath = JMeterHomePath;
    }

    public boolean isJMeterUseDefaultPort() {
        return JMeterUseDefaultPort;
    }

    public void setJMeterUseDefaultPort(boolean JMeterUseDefaultPort) {
        this.JMeterUseDefaultPort = JMeterUseDefaultPort;
    }

    public String getJMeterMinPort() {
        return JMeterMinPort;
    }

    public void setJMeterMinPort(int JMeterMinPort) {
        this.JMeterMinPort = Common.integerToString(JMeterMinPort);
    }

    public void setJMeterMinPort(String JMeterMinPort) {
        this.JMeterMinPort = JMeterMinPort;
    }

    public String getJMeterMaxPort() {
        return JMeterMaxPort;
    }

    public void setJMeterMaxPort(int JMeterMaxPort) {
        this.JMeterMaxPort = Common.integerToString(JMeterMaxPort);
    }

    public void setJMeterMaxPort(String JMeterMaxPort) {
        this.JMeterMaxPort = JMeterMaxPort;
    }

    public boolean isJMeterDistributeMode() {
        return JMeterDistributeMode;
    }

    public void setJMeterDistributeMode(boolean JMeterDistributeMode) {
        this.JMeterDistributeMode = JMeterDistributeMode;
    }

    public String getJMeterAdditionalProperties() {
        return JMeterAdditionalProperties;
    }

    public void setJMeterAdditionalProperties(String JMeterAdditionalProperties) {
        this.JMeterAdditionalProperties = JMeterAdditionalProperties;
    }
}
