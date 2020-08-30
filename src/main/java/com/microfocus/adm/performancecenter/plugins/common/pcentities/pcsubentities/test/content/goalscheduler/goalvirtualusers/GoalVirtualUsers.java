package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goalvirtualusers;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="GoalVirtualUsers")
public class GoalVirtualUsers {

    @XmlElement
    private String TargetVusersNumber;

    public GoalVirtualUsers() { }

    public GoalVirtualUsers(int targetVusersNumber) {
        setTargetVusersNumber(targetVusersNumber);
    }

    public void setTargetVusersNumber(int targetVusersNumber) {
            this.TargetVusersNumber = Common.integerToString(targetVusersNumber);
    }

    @Override
    public String toString() {
        return "GoalVirtualUsers{" +
                "TargetVusersNumber = " + TargetVusersNumber +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("GoalVirtualUsers", GoalVirtualUsers.class);
        xstream.aliasField("TargetVusersNumber", GoalVirtualUsers.class, "TargetVusersNumber");
        xstream.aliasField("GoalVirtualUsers", GoalVirtualUsers.class, "GoalVirtualUsers");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static GoalVirtualUsers xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GoalVirtualUsers" , GoalVirtualUsers.class);
        xstream.setClassLoader(GoalVirtualUsers.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GoalVirtualUsers)xstream.fromXML(xml);
    }

    public String getTargetVusersNumber() {
        return TargetVusersNumber;
    }

    public void setTargetVusersNumber(String targetVusersNumber) {
        TargetVusersNumber = targetVusersNumber;
    }
}
