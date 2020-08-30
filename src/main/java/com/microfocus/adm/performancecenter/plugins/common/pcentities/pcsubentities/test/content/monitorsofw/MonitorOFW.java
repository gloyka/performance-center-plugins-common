package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.monitorsofw;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="MonitorOFW")
public class MonitorOFW {

    @XmlElement
    private String ID;

    public MonitorOFW() {
    }

    public MonitorOFW(int ID) {
        setID(ID);
    }

    public void setID(int value) {
        this.ID = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "MonitorOFW{" + "ID = " + ID;
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("MonitorOFW", MonitorOFW.class);
        xstream.aliasField("ID", MonitorOFW.class, "ID");
        xstream.aliasField("MonitorOFW", MonitorOFW.class, "MonitorOFW");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static MonitorOFW xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("MonitorOFW" , MonitorOFW.class);
        xstream.setClassLoader(MonitorOFW.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (MonitorOFW)xstream.fromXML(xml);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
