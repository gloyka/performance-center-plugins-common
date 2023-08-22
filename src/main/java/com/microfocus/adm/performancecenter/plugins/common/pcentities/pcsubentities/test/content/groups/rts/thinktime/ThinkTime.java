package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.ThinkTimeTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ThinkTime")
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
    @XStreamAlias("MultiplyFactor")
    private String MultiplyFactor;

    @XmlElement
    @XStreamAlias("LimitThinkTimeSeconds")
    private String LimitThinkTimeSeconds;

    public ThinkTime() {
        setType(ThinkTimeTypeValues.IGNORE);
    }

    public ThinkTime(String type, int limitThinkTimeSeconds, int minPercentage, int maxPercentage, int multiplyFactor) {
        setType(type);
        if (this.Type.equals(ThinkTimeTypeValues.IGNORE.value())) {
            setLimitThinkTimeSeconds(-1);
            setMultiplyFactor(-1);
            setMinPercentage(-1);
            setMaxPercentage(-1);
        } else if (this.Type.equals(ThinkTimeTypeValues.REPLAY.value())) {
            setLimitThinkTimeSeconds(limitThinkTimeSeconds);
            setMultiplyFactor(-1);
            setMinPercentage(-1);
            setMaxPercentage(-1);
        } else if (this.Type.equals(ThinkTimeTypeValues.MODIFY.value())) {
            setLimitThinkTimeSeconds(limitThinkTimeSeconds);
            setMultiplyFactor(multiplyFactor);
            setMinPercentage(-1);
            setMaxPercentage(-1);
        } else if (this.Type.equals(ThinkTimeTypeValues.RANDOM.value())) {
            setLimitThinkTimeSeconds(limitThinkTimeSeconds);
            setMinPercentage(minPercentage);
            setMaxPercentage(maxPercentage);
            setMultiplyFactor(-1);
        }
    }

    public ThinkTime(ThinkTimeTypeValues type, int limitThinkTimeSeconds, int minPercentage, int maxPercentage, int multiplyFactor) {
        setType(type);
        if (this.Type.equals(ThinkTimeTypeValues.IGNORE.value())) {
            setLimitThinkTimeSeconds(-1);
            setMultiplyFactor(-1);
            setMinPercentage(-1);
            setMaxPercentage(-1);
        } else if (this.Type.equals(ThinkTimeTypeValues.REPLAY.value())) {
            setLimitThinkTimeSeconds(limitThinkTimeSeconds);
            setMultiplyFactor(-1);
            setMinPercentage(-1);
            setMaxPercentage(-1);
        } else if (this.Type.equals(ThinkTimeTypeValues.MODIFY.value())) {
            setLimitThinkTimeSeconds(limitThinkTimeSeconds);
            setMultiplyFactor(multiplyFactor);
            setMinPercentage(-1);
            setMaxPercentage(-1);
        } else if (this.Type.equals(ThinkTimeTypeValues.RANDOM.value())) {
            setLimitThinkTimeSeconds(limitThinkTimeSeconds);
            setMinPercentage(minPercentage);
            setMaxPercentage(maxPercentage);
            setMultiplyFactor(-1);
        }
    }

    public static ThinkTime xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.alias("ThinkTime", ThinkTime.class);
        xstream.setClassLoader(ThinkTime.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ThinkTime) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "ThinkTime{" + "Type = " + Type +
                ", MinPercentage = " + MinPercentage +
                ", MaxPercentage = " + MaxPercentage +
                ", MultiplyFactor = " + MultiplyFactor +
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
        xstream.aliasField("MultiplyFactor", ThinkTime.class, "MultiplyFactor");
        xstream.aliasField("LimitThinkTimeSeconds", ThinkTime.class, "LimitThinkTimeSeconds");
        xstream.aliasField("ThinkTime", ThinkTime.class, "ThinkTime");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(ThinkTimeTypeValues type) {
        this.Type = type.value();
    }

    public String getMinPercentage() {
        return MinPercentage;
    }

    public void setMinPercentage(int value) {
        this.MinPercentage = Common.integerToString(value);
    }

    public void setMinPercentage(String minPercentage) {
        MinPercentage = minPercentage;
    }

    public String getMaxPercentage() {
        return MaxPercentage;
    }

    public void setMaxPercentage(int value) {
        this.MaxPercentage = Common.integerToString(value);
    }

    public void setMaxPercentage(String maxPercentage) {
        MaxPercentage = maxPercentage;
    }

    public String getMultiplyFactor() {
        return MultiplyFactor;
    }

    public void setMultiplyFactor(int value) {
        this.MultiplyFactor = Common.integerToString(value);
    }

    public void setMultiplyFactor(String multiplyFactor) {
        MultiplyFactor = multiplyFactor;
    }

    public String getLimitThinkTimeSeconds() {
        return LimitThinkTimeSeconds;
    }

    public void setLimitThinkTimeSeconds(int value) {
        this.LimitThinkTimeSeconds = Common.integerToString(value);
    }

    public void setLimitThinkTimeSeconds(String limitThinkTimeSeconds) {
        LimitThinkTimeSeconds = limitThinkTimeSeconds;
    }
}
