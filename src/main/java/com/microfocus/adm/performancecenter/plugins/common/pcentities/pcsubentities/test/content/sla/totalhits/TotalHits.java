package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalhits;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
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
@XmlRootElement(name="TotalHits")
public class TotalHits
{

    @XmlElement
    private String Threshold;

    public TotalHits() { }

    public TotalHits(int threshold) {
        setThreshold(threshold);
    }

    public void setThreshold(int value) {
        this.Threshold = Common.integerToString(value);
    }


    @Override
    public String toString() {
        return "TotalHits{" + "Threshold = " + Threshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TotalHits", TotalHits.class);
        xstream.aliasField("Threshold", TotalHits.class, "Threshold");
        xstream.aliasField("TotalHits", TotalHits.class, "TotalHits");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static TotalHits xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TotalHits" , TotalHits.class);
        xstream.setClassLoader(TotalHits.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TotalHits)xstream.fromXML(xml);
    }

}