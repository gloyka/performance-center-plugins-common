package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startgroup;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.TimeInterval;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.StartGroupTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;


@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="StartGroup")
public class StartGroup {

    /* possible values
        Type="immediately"
        Type="with delay"
        Type="when group finishes" */
    @XmlAttribute
    private String Type;

    @XmlElement
    private TimeInterval TimeInterval;

    @XmlElement
    private String Name;

    public StartGroup() { }

    public StartGroup(String type, TimeInterval timeInterval, String name) {
        setType(type);
        setTimeInterval(timeInterval);
        setName(name);
    }

    public StartGroup(StartGroupTypeValues type, TimeInterval timeInterval, String name) {
        setType(type);
        setTimeInterval(timeInterval);
        setName(name);
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(StartGroupTypeValues type) {
        this.Type = type.value();
    }

    @Override
    public String toString() {
        return "StartGroup{" + "Type = " + Type +
                ", TimeInterval = " + TimeInterval +
                ", Name = " + Name + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("StartGroup", StartGroup.class);

        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");

        xstream.aliasField("TimeInterval", StartGroup.class, "TimeInterval");
        xstream.aliasField("Name", StartGroup.class, "Name");
        xstream.aliasField("StartGroup", StartGroup.class, "StartGroup");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static StartGroup xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");

        xstream.alias("StartGroup" , StartGroup.class);
        xstream.setClassLoader(StartGroup.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (StartGroup)xstream.fromXML(xml);
    }
}