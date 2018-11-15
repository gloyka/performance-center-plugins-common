package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalhitspersecond;

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
@XmlRootElement(name="GoalHitsPerSecond")
public class GoalHitsPerSecond {

    @XmlElement
    private String TargetHitsPerSecond;

    @XmlElement
    private String MinVusers;

    @XmlElement
    private String MaxVusers;


    public GoalHitsPerSecond() { }

    public GoalHitsPerSecond(int targetHitsPerSecond, int minVusers, int maxVusers) {
        setTargetHitsPerSecond(targetHitsPerSecond);
        setMinVusers(minVusers);
        setMaxVusers(maxVusers);
    }

    public void setTargetHitsPerSecond(int targetHitsPerSecond) {
            this.TargetHitsPerSecond = Common.integerToString(targetHitsPerSecond);
    }

    public void setMinVusers(int minVusers) {
            this.MinVusers = Common.integerToString(minVusers);
    }

    public void setMaxVusers(int maxVusers) {
            this.MaxVusers = Common.integerToString(maxVusers);
    }

    @Override
    public String toString() {
        return "GoalHitsPerSecond{" + "TargetHitsPerSecond = " + TargetHitsPerSecond +
                ", MinVusers = " + MinVusers +
                ", MaxVusers = " + MaxVusers +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("GoalHitsPerSecond", GoalHitsPerSecond.class);
        xstream.aliasField("MinVusers", GoalHitsPerSecond.class, "MinVusers");
        xstream.aliasField("MaxVusers", GoalHitsPerSecond.class, "MaxVusers");
        xstream.aliasField("GoalHitsPerSecond", GoalHitsPerSecond.class, "GoalHitsPerSecond");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static GoalHitsPerSecond xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GoalHitsPerSecond" , GoalHitsPerSecond.class);
        xstream.setClassLoader(GoalHitsPerSecond.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GoalHitsPerSecond)xstream.fromXML(xml);
    }


}
