package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.j2eedotnet;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.Diagnostics;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="J2EEDotNet")
public class J2EEDotNet
{

    @XmlElement
    private boolean Enabled;

    @XmlElement
    private String Probes;

    @XmlElement
    private boolean IsMediatorOFW;

    @XmlElement
    private boolean MonitorServerRequests;

    public J2EEDotNet() {}

    public J2EEDotNet(boolean enabled, String probes, boolean isMediatorOFW, boolean monitorServerRequests) {
        setEnabled(enabled);
        setProbes(probes);
        setIsMediatorOFW(isMediatorOFW);
        setMonitorServerRequests(monitorServerRequests);
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

    public static J2EEDotNet xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("J2EEDotNet" , J2EEDotNet.class);
        xstream.setClassLoader(J2EEDotNet.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (J2EEDotNet)xstream.fromXML(xml);
    }

}
