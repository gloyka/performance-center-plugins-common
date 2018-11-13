package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.ThinkTimeTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ThinkTime")
public class ThinkTime {

    @XmlAttribute
    @XStreamAsAttribute
    private String Type;

    @XmlElement
    @XStreamAlias("MinPercentage")
    private String MinPercentage;

    @XmlElement
    @XStreamAlias("MaxPercentage")
    private String MaxPercentage;

    @XmlElement
    @XStreamAlias("LimitThinkTimeSeconds")
    private String LimitThinkTimeSeconds;

    public ThinkTime() {
        setType(ThinkTimeTypeValues.REPLAY);
    }

    public ThinkTime(String type) {
        setType(type);
    }

    public ThinkTime(ThinkTimeTypeValues type) {
        setType(type);
    }

    public ThinkTime(String type, int minPercentage, int maxPercentage, int limitThinkTimeSeconds) {
        setType(type);
        setMinPercentage(minPercentage);
        setMaxPercentage(maxPercentage);
        setLimitThinkTimeSeconds(limitThinkTimeSeconds);
    }

    public ThinkTime(ThinkTimeTypeValues type, int minPercentage, int maxPercentage, int limitThinkTimeSeconds) {
        setType(type);
        setMinPercentage(minPercentage);
        setMaxPercentage(maxPercentage);
        setLimitThinkTimeSeconds(limitThinkTimeSeconds);
    }

    public void setType (String type) {
        this.Type = type;
    }

    public void setType (ThinkTimeTypeValues type) {
        this.Type = type.value();
    }

    public void setMinPercentage(int value) {
        this.MinPercentage = Common.integerToString(value);
    }

    public void setMaxPercentage(int value) {
        this.MaxPercentage = Common.integerToString(value);
    }

    public void setLimitThinkTimeSeconds(int value) {
        this.LimitThinkTimeSeconds = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "ThinkTime{" + "Type = " + Type +
                ", MinPercentage = " + MinPercentage +
                ", MaxPercentage = " + MaxPercentage +
                ", LimitThinkTimeSeconds = " + LimitThinkTimeSeconds +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ThinkTime", ThinkTime.class);
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.aliasField("MinPercentage", ThinkTime.class, "MinPercentage");
        xstream.aliasField("MaxPercentage", ThinkTime.class, "MaxPercentage");
        xstream.aliasField("LimitThinkTimeSeconds", ThinkTime.class, "LimitThinkTimeSeconds");
        xstream.aliasField("ThinkTime", ThinkTime.class, "ThinkTime");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static ThinkTime xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.alias("ThinkTime" , ThinkTime.class);
        xstream.setClassLoader(ThinkTime.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ThinkTime)xstream.fromXML(xml);
    }

}
