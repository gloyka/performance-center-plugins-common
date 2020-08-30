package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagethroughput;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagehitspersecond.AverageHitsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AverageThroughput")
public class AverageThroughput
{

    @XmlElement
    private String Threshold;

    public AverageThroughput() {
    }

    public AverageThroughput(int threshold) {
        setThreshold(threshold);
    }

    public void setThreshold(int value) {
        this.Threshold = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "AverageThroughput{" + "Threshold = " + Threshold + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("AverageThroughput", AverageThroughput.class);
        xstream.aliasField("Threshold", AverageThroughput.class, "Threshold");
        xstream.aliasField("AverageThroughput", AverageThroughput.class, "AverageThroughput");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static AverageThroughput xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("AverageThroughput" , AverageThroughput.class);
        xstream.setClassLoader(AverageThroughput.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (AverageThroughput)xstream.fromXML(xml);
    }

    public String getThreshold() {
        return Threshold;
    }

    public void setThreshold(String threshold) {
        Threshold = threshold;
    }
}
