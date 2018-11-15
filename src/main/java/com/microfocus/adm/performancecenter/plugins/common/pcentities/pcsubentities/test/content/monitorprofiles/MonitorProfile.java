package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorprofiles;

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
@XmlRootElement(name="MonitorProfile")
public class MonitorProfile {

    @XmlElement
    private String ID;

    public MonitorProfile() {
    }

    public MonitorProfile(int ID) {
        setID(ID);
    }

    public void setID(int value) {
        this.ID = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "MonitorProfile{" + "ID = " + ID;
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("MonitorProfile", MonitorProfile.class);
        xstream.aliasField("ID", MonitorProfile.class, "ID");
        xstream.aliasField("MonitorProfile", MonitorProfile.class, "MonitorProfile");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static MonitorProfile xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("MonitorProfile" , MonitorProfile.class);
        xstream.setClassLoader(MonitorProfile.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (MonitorProfile)xstream.fromXML(xml);
    }

}
