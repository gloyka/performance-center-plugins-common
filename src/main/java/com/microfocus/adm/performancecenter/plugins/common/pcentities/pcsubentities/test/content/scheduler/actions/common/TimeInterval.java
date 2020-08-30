package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorsofw.MonitorOFW;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TimeInterval")
public class TimeInterval {

    @XmlElement
    private String Days;

    @XmlElement
    private String Hours;

    @XmlElement
    private String Minutes;

    @XmlElement
    private String Seconds;

    public TimeInterval() {}

    public TimeInterval(int days, int hours, int minutes, int seconds) {
        setDays(days);
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public TimeInterval(int hours, int minutes, int seconds) {
        setDays(-1);
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void setDays (int days) {
        this.Days = Common.integerToString(days);
    }

    public void setHours (int hours) {
            this.Hours = Common.integerToString(hours);
    }

    public void setMinutes (int minutes) {
        this.Minutes = Common.integerToString(minutes);
    }

    public void setSeconds (int seconds) {
        this.Seconds = Common.integerToString(seconds);
    }

    @Override
    public String toString() {
        return "TimeInterval{" +"Days = " + Days +
                ", Hours = " + Hours +
                ", Minutes = " + Minutes +
                ", Seconds = " + Seconds + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TimeInterval", TimeInterval.class);
        xstream.aliasField("Days", TimeInterval.class, "Days");
        xstream.aliasField("Hours", TimeInterval.class, "Hours");
        xstream.aliasField("Minutes", TimeInterval.class, "Minutes");
        xstream.aliasField("Seconds", TimeInterval.class, "Seconds");
        xstream.aliasField("TimeInterval", TimeInterval.class, "TimeInterval");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static TimeInterval xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TimeInterval" , TimeInterval.class);
        xstream.setClassLoader(TimeInterval.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TimeInterval)xstream.fromXML(xml);
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String hours) {
        Hours = hours;
    }

    public String getMinutes() {
        return Minutes;
    }

    public void setMinutes(String minutes) {
        Minutes = minutes;
    }

    public String getSeconds() {
        return Seconds;
    }

    public void setSeconds(String seconds) {
        Seconds = seconds;
    }
}
