package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="WaitAfterInit")
public class WaitAfterInit {

    @XmlElement
    private String Days;

    @XmlElement
    private String Hours;

    @XmlElement
    private String Minutes;

    @XmlElement
    private String Seconds;

    public WaitAfterInit() {}

    public WaitAfterInit(int days, int hours, int minutes, int seconds) {
        setDays(days);
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public WaitAfterInit(int hours, int minutes, int seconds) {
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
        return "WaitAfterInit{" +"Days = " + Days +
                "; Hours = " + Hours +
                ", Minutes = " + Minutes +
                ", Seconds = " + Seconds + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("WaitAfterInit", WaitAfterInit.class);
        xstream.aliasField("Days", WaitAfterInit.class, "Days");
        xstream.aliasField("Hours", WaitAfterInit.class, "Hours");
        xstream.aliasField("Minutes", WaitAfterInit.class, "Minutes");
        xstream.aliasField("Seconds", WaitAfterInit.class, "Seconds");
        xstream.aliasField("WaitAfterInit", WaitAfterInit.class, "WaitAfterInit");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static WaitAfterInit xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("WaitAfterInit" , WaitAfterInit.class);
        xstream.setClassLoader(WaitAfterInit.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (WaitAfterInit)xstream.fromXML(xml);
    }
}
