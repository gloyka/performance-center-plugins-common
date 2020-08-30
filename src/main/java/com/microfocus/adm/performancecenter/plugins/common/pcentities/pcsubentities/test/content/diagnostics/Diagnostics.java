package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.automatictrending.AutomaticTrending;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.diagnostics.j2eedotnet.J2EEDotNet;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Diagnostics")
public class Diagnostics
{
    @XmlElement
    private boolean Enabled;

    @XmlElement
    private String VusersPercentage;

    @XmlElement
    private boolean EnableWebPage;

    @XmlElement
    private J2EEDotNet J2EEDotNet;

    public Diagnostics() {
        setEnabled(false);
        setEnableWebPage(false);
        setJ2EEDotNet(new J2EEDotNet(false, null, false, false));
        setVusersPercentage(1);
    }

    public Diagnostics(boolean enabled, boolean enableWebPage, J2EEDotNet j2EEDotNet, int vusersPercentage) {
        setEnabled(enabled);
        if(enabled == false) {
            setEnableWebPage(enableWebPage);
            setJ2EEDotNet(j2EEDotNet);
            setVusersPercentage(vusersPercentage);
        } else  {
            setEnableWebPage(false);
            setJ2EEDotNet(new J2EEDotNet(false, null, false, false));
            setVusersPercentage(1);
        }
    }

    public void setVusersPercentage(int value) {
            this.VusersPercentage = (value > 0 && value <= 100) ? Common.integerToString(value) : "1";
    }

    @Override
    public String toString() {
        return "Diagnostics{" + "EnableWebPage = " + EnableWebPage +
                ", Enabled = " + Enabled +
                ", J2EEDotNet = " + J2EEDotNet +
                ", VusersPercentage = " + VusersPercentage + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("Diagnostics", Diagnostics.class);
        xstream.aliasField("Enabled", Diagnostics.class, "Enabled");
        xstream.aliasField("VusersPercentage", Diagnostics.class, "VusersPercentage");
        xstream.aliasField("EnableWebPage", Diagnostics.class, "EnableWebPage");
        xstream.aliasField("J2EEDotNet", Diagnostics.class, "J2EEDotNet");
        xstream.aliasField("Diagnostics", Diagnostics.class, "Diagnostics");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Diagnostics xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Diagnostics" , Diagnostics.class);
        xstream.setClassLoader(Diagnostics.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Diagnostics)xstream.fromXML(xml);
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    public String getVusersPercentage() {
        return VusersPercentage;
    }

    public void setVusersPercentage(String vusersPercentage) {
        VusersPercentage = vusersPercentage;
    }

    public boolean isEnableWebPage() {
        return EnableWebPage;
    }

    public void setEnableWebPage(boolean enableWebPage) {
        EnableWebPage = enableWebPage;
    }

    public J2EEDotNet getJ2EEDotNet() {
        return J2EEDotNet;
    }

    public void setJ2EEDotNet(J2EEDotNet j2EEDotNet) {
        J2EEDotNet = j2EEDotNet;
    }
}
