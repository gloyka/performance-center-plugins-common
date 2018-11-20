package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scheduler {

    //optional
    int rampup;

    //optional
    int duration;

    public Scheduler() {}

    public Scheduler(int rampup, int duration) {
        this.rampup = rampup;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Scheduler {" +
                "rampup = " + rampup + ", " +
                "duration = " + duration + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Scheduler", Scheduler.class);
        xstream.aliasField("rampup", Scheduler.class, "MinVusers");
        xstream.aliasField("duration", Scheduler.class, "MaxVusers");
        xstream.aliasField("Scheduler", Scheduler.class, "Scheduler");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Scheduler xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Scheduler" , Scheduler.class);
        xstream.setClassLoader(Scheduler.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Scheduler)xstream.fromXML(xml);
    }
}
