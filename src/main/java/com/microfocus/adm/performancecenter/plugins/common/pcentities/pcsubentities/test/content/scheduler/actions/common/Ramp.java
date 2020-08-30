package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Ramp")
public class Ramp
{

    @XmlElement
    private String Vusers;

    @XmlElement
    private TimeInterval TimeInterval;

    public Ramp() { }

    public Ramp(int vusers, TimeInterval timeInterval) {
        setVusers(vusers);
        setTimeInterval(timeInterval);
    }

    public void setVusers(int vusers) {
         this.Vusers = Common.integerToString(vusers);
    }

    @Override
    public String toString() {
        return "Ramp{" +
                "Vusers = " + Vusers +
                ", TimeInterval = " + TimeInterval + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Ramp", Ramp.class);
        xstream.aliasField("Vusers", Ramp.class, "Vusers");
        xstream.aliasField("TimeInterval", Ramp.class, "TimeInterval");
        xstream.aliasField("Ramp", Ramp.class, "Ramp");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Ramp xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Ramp" , Ramp.class);
        xstream.setClassLoader(Ramp.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Ramp)xstream.fromXML(xml);
    }


    public String getVusers() {
        return Vusers;
    }

    public void setVusers(String vusers) {
        Vusers = vusers;
    }

    public TimeInterval getTimeInterval() {
        return TimeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        TimeInterval = timeInterval;
    }
}
