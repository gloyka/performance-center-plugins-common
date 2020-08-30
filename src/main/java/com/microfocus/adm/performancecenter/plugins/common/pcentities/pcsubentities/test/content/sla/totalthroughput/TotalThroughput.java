package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalthroughput;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TotalThroughput")
public class TotalThroughput
{

    @XmlElement
    private String Threshold;

    public TotalThroughput() { }

    public TotalThroughput(int threshold) {
        setThreshold(threshold);
    }

    public void setThreshold(int value) {
        this.Threshold = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "TotalThroughput{" + "Threshold = " + Threshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TotalThroughput", TotalThroughput.class);
        xstream.aliasField("Threshold", TotalThroughput.class, "Threshold");
        xstream.aliasField("TotalThroughput", TotalThroughput.class, "TotalThroughput");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static TotalThroughput xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TotalThroughput" , TotalThroughput.class);
        xstream.setClassLoader(TotalThroughput.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TotalThroughput)xstream.fromXML(xml);
    }

    public String getThreshold() {
        return Threshold;
    }

    public void setThreshold(String threshold) {
        Threshold = threshold;
    }
}