package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
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
@XmlRootElement(name="Thresholds")
public class Thresholds
{


    @XmlElement
    private String LessThanThreshold;

    @XmlElement
    private BetweenThreshold BetweenThreshold;

    @XmlElement
    private String GreaterThanOrEqualThreshold;

    public Thresholds() { }

    public Thresholds(int lessThanThreshold, BetweenThreshold betweenThreshold, int greaterThanOrEqualThreshold) {
        setLessThanThreshold(lessThanThreshold);
        setBetweenThreshold(betweenThreshold);
        setGreaterThanOrEqualThreshold(greaterThanOrEqualThreshold);
    }

    public void setLessThanThreshold(int value) {
        this.LessThanThreshold = Common.integerToString(value);
    }

    public void setGreaterThanOrEqualThreshold(int value) {
        this.GreaterThanOrEqualThreshold = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "Thresholds{" + "LessThanThreshold = " + LessThanThreshold +
                ", BetweenThreshold = " + BetweenThreshold +
                ", GreaterThanOrEqualThreshold = " + GreaterThanOrEqualThreshold + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Thresholds", Thresholds.class);
        xstream.aliasField("LessThanThreshold", Thresholds.class, "LessThanThreshold");

        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.aliasField("GreaterThanOrEqualThreshold", Thresholds.class, "GreaterThanOrEqualThreshold");
        xstream.aliasField("Thresholds", Thresholds.class, "Thresholds");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Thresholds xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Thresholds" , Thresholds.class);

        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.setClassLoader(Thresholds.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Thresholds)xstream.fromXML(xml);
    }

}