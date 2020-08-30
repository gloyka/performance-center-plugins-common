package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.initialize.Initialize;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers.StartVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.duration.Duration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.stopvusers.StopVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startgroup.StartGroup;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Action")
public class Action
{

    @XmlElement
    private Initialize Initialize;

    @XmlElement
    private StartVusers StartVusers;

    @XmlElement
    private Duration Duration;

    @XmlElement
    private StopVusers StopVusers;

    @XmlElement
    private StartGroup StartGroup;

    public Action() {}

    public Action(Initialize initialize) {
        setInitialize(initialize);
    }

    public Action(StartVusers startVusers) {
        setStartVusers(startVusers);
    }

    public Action(Duration duration) {
        setDuration(duration);
    }

    public Action(StopVusers stopVusers) {
        setStopVusers(stopVusers);
    }

    public Action(StartGroup startGroup) {
        setStartGroup(startGroup);
    }

    @Override
    public String toString() {
        return "Action{" +
                "Initialize = " + Initialize +
                ", StartGroup" + StartGroup +
                ", StartVusers = " + StartVusers +
                ", Duration = " + Duration +
                ", StopVusers = " + StopVusers + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Action", Action.class);

        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");

        xstream.aliasField("Initialize", Action.class, "Initialize");
        xstream.aliasField("StartVusers", Action.class, "StartVusers");
        xstream.aliasField("Duration", Action.class, "Duration");
        xstream.aliasField("StopVusers", Action.class, "StopVusers");
        xstream.aliasField("StartGroup", Action.class, "StartGroup");
        xstream.aliasField("Action", Action.class, "Action");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Action xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");

        xstream.alias("Action" , Action.class);
        xstream.setClassLoader(Action.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Action)xstream.fromXML(xml);
    }

    public Initialize getInitialize() {
        return Initialize;
    }

    public void setInitialize(Initialize initialize) {
        Initialize = initialize;
    }

    public StartVusers getStartVusers() {
        return StartVusers;
    }

    public void setStartVusers(StartVusers startVusers) {
        StartVusers = startVusers;
    }

    public Duration getDuration() {
        return Duration;
    }

    public void setDuration(Duration duration) {
        Duration = duration;
    }

    public StopVusers getStopVusers() {
        return StopVusers;
    }

    public void setStopVusers(StopVusers stopVusers) {
        StopVusers = stopVusers;
    }

    public StartGroup getStartGroup() {
        return StartGroup;
    }

    public void setStartGroup(StartGroup startGroup) {
        StartGroup = startGroup;
    }
}
