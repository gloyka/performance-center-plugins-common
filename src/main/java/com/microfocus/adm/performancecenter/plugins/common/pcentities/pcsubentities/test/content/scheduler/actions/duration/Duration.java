package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.duration;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.TimeInterval;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.DurationTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Duration")
public class Duration
{
/* possible values
        Type="indefinitely"
        Type="run for"
        Type="until complete"*/

    @XmlAttribute
    private String Type;

    @XmlElement
    private TimeInterval TimeInterval;

    public Duration() {
        setType(DurationTypeValues.UNTIL_COMPLETE);
    }

    public Duration(String type, TimeInterval timeInterval) {
        setType(type);
        setTimeInterval(timeInterval);
    }

    public Duration(DurationTypeValues type, TimeInterval timeInterval) {
        setType(type);
        setTimeInterval(timeInterval);
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(DurationTypeValues type) {
        this.Type = type.value();
    }


    @Override
    public String toString() {
        return "Duration{" +
                "Type = " + Type +
                ", TimeInterval = " + TimeInterval + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Duration", Duration.class);

        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");

        xstream.aliasField("TimeInterval", Duration.class, "TimeInterval");
        xstream.aliasField("Duration", Duration.class, "Duration");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Duration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");

        xstream.alias("Duration" , Duration.class);
        xstream.setClassLoader(Duration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Duration)xstream.fromXML(xml);
    }


    public String getType() {
        return Type;
    }

    public TimeInterval getTimeInterval() {
        return TimeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        TimeInterval = timeInterval;
    }
}
