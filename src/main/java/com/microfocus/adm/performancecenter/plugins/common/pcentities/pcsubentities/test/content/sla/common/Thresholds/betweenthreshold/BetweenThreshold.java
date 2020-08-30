package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="BetweenThreshold")
public class BetweenThreshold {

    @XmlElement
    private ArrayList<String> Threshold;

    public BetweenThreshold() {}

    public BetweenThreshold(ArrayList<String> threshold) {
        Threshold = threshold;
    }

    @Override
    public String toString() {
        return "BetweenThreshold{" + "Threshold = " + Threshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("BetweenThreshold", BetweenThreshold.class);

        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.aliasField("BetweenThreshold", BetweenThreshold.class, "BetweenThreshold");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static BetweenThreshold xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("BetweenThreshold" , BetweenThreshold.class);

        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.setClassLoader(BetweenThreshold.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (BetweenThreshold)xstream.fromXML(xml);
    }


    public ArrayList<String> getThreshold() {
        return Threshold;
    }

    public void setThreshold(ArrayList<String> threshold) {
        Threshold = threshold;
    }
}
