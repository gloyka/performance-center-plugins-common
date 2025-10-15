package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

public class SimplifiedScheduler {

    //optional
    private int rampup;

    //optional
    private int duration;

    //optional
    private String init_type;

    public SimplifiedScheduler() {
    }

    public SimplifiedScheduler(int rampup, int duration) {
        this.rampup = rampup;
        this.duration = duration;
    }

    public SimplifiedScheduler(int rampup, int duration, String init_type) {
        this.rampup = rampup;
        this.duration = duration;
        this.init_type = init_type;
    }

    public static SimplifiedScheduler xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedScheduler", SimplifiedScheduler.class);
        xstream.setClassLoader(SimplifiedScheduler.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedScheduler) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "SimplifiedScheduler {" +
                "init_type = " + init_type + ", " +
                "rampup = " + rampup + ", " +
                "duration = " + duration + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedScheduler", SimplifiedScheduler.class);
        xstream.aliasField("init_type", SimplifiedScheduler.class, "init_type");
        xstream.aliasField("rampup", SimplifiedScheduler.class, "rampup");
        xstream.aliasField("duration", SimplifiedScheduler.class, "duration");
        xstream.aliasField("SimplifiedScheduler", SimplifiedScheduler.class, "SimplifiedScheduler");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public int getRampup() {
        return rampup;
    }

    public void setRampup(int rampup) {
        this.rampup = rampup;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getInit_type() {
        return init_type;
    }

    public void setInit_type(String init_type) {
        this.init_type = init_type;
    }
}
