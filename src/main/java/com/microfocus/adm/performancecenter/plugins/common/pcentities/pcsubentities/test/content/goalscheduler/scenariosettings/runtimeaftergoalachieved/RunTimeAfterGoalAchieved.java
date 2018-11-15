package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.scenariosettings.runtimeaftergoalachieved;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="RunTimeAfterGoalAchieved")
public class RunTimeAfterGoalAchieved {

    @XmlElement
    private String Minutes;

    public RunTimeAfterGoalAchieved() { }

    public RunTimeAfterGoalAchieved(int minutes) {
        setMinutes(minutes);
    }

    @Override
    public String toString() {
        return "RunTimeAfterGoalAchieved{" + "Minutes = " + Minutes +
                "}";
    }

    public void setMinutes(int minutes) {
            this.Minutes = Common.integerToString(minutes);
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("RunTimeAfterGoalAchieved", RunTimeAfterGoalAchieved.class);
        xstream.aliasField("Minutes", RunTimeAfterGoalAchieved.class, "Minutes");
        xstream.aliasField("RunTimeAfterGoalAchieved", RunTimeAfterGoalAchieved.class, "RunTimeAfterGoalAchieved");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static RunTimeAfterGoalAchieved xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("RunTimeAfterGoalAchieved" , RunTimeAfterGoalAchieved.class);
        xstream.setClassLoader(RunTimeAfterGoalAchieved.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (RunTimeAfterGoalAchieved)xstream.fromXML(xml);
    }

}


