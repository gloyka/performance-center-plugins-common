package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagehitspersecond;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AverageHitsPerSecond")
public class AverageHitsPerSecond
{

    @XmlElement
    private String Threshold;

    public AverageHitsPerSecond() { }

    public AverageHitsPerSecond(int threshold) {
        setThreshold(threshold);
    }

    public void setThreshold(int value) {
        this.Threshold = Common.integerToString(value);
    }


    @Override
    public String toString() {
        return "AverageHitsPerSecond{" + "Threshold = " + Threshold + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("AverageHitsPerSecond", AverageHitsPerSecond.class);
        xstream.aliasField("Threshold", AverageHitsPerSecond.class, "Threshold");
        xstream.aliasField("AverageHitsPerSecond", AverageHitsPerSecond.class, "AverageHitsPerSecond");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static AverageHitsPerSecond xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("AverageHitsPerSecond" , AverageHitsPerSecond.class);
        xstream.setClassLoader(AverageHitsPerSecond.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (AverageHitsPerSecond)xstream.fromXML(xml);
    }


    public String getThreshold() {
        return Threshold;
    }

    public void setThreshold(String threshold) {
        Threshold = threshold;
    }
}
