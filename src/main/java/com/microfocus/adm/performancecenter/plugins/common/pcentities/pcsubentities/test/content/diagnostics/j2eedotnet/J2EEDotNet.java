/**
 Copyright © 2023 Open Text Corporation

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.j2eedotnet;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "J2EEDotNet")
public class J2EEDotNet {

    @XmlElement
    private boolean Enabled;

    @XmlElement
    private String Probes;

    @XmlElement
    private boolean IsMediatorOFW;

    @XmlElement
    private boolean MonitorServerRequests;

    public J2EEDotNet() {
    }

    public J2EEDotNet(boolean enabled, String probes, boolean isMediatorOFW, boolean monitorServerRequests) {
        setEnabled(enabled);
        setProbes(probes);
        setIsMediatorOFW(isMediatorOFW);
        setMonitorServerRequests(monitorServerRequests);
    }

    public static J2EEDotNet xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("J2EEDotNet", J2EEDotNet.class);
        xstream.setClassLoader(J2EEDotNet.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (J2EEDotNet) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "J2EEDotNet{" + "Enabled = " + Enabled +
                ", Probes = " + Probes +
                ", IsMediatorOFW = " + IsMediatorOFW +
                ", MonitorServerRequests = " + MonitorServerRequests + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("J2EEDotNet", J2EEDotNet.class);
        xstream.aliasField("Enabled", J2EEDotNet.class, "Enabled");
        xstream.aliasField("Probes", J2EEDotNet.class, "Probes");
        xstream.aliasField("IsMediatorOFW", J2EEDotNet.class, "IsMediatorOFW");
        xstream.aliasField("MonitorServerRequests", J2EEDotNet.class, "MonitorServerRequests");
        xstream.aliasField("J2EEDotNet", J2EEDotNet.class, "J2EEDotNet");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    public String getProbes() {
        return Probes;
    }

    public void setProbes(String probes) {
        Probes = probes;
    }

    public boolean isMediatorOFW() {
        return IsMediatorOFW;
    }

    public void setMediatorOFW(boolean mediatorOFW) {
        IsMediatorOFW = mediatorOFW;
    }

    public void setIsMediatorOFW(boolean mediatorOFW) {
        IsMediatorOFW = mediatorOFW;
    }

    public boolean isMonitorServerRequests() {
        return MonitorServerRequests;
    }

    public void setMonitorServerRequests(boolean monitorServerRequests) {
        MonitorServerRequests = monitorServerRequests;
    }
}
