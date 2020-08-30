package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.host;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.HostNameDynamicValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.HostNameLGValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.HostTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Host")
public class Host {

    @XmlElement
    private String Name;

    /*
    specific
    automatch (named LG1, LG2, and so on)
    dynamic (named DOCKER1, DOCKER2, and so on)
    */
    @XmlElement
    private String Type;

    public Host() {}

    public Host(String name, String type) {
        setName(name);
        setType(type);
    }

    public Host(String name, HostTypeValues type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameLGValues name, String type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameLGValues name, HostTypeValues type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameDynamicValues name, String type) {
        setName(name);
        setType(type);
    }

    public Host(HostNameDynamicValues name, HostTypeValues type) {
        setName(name);
        setType(type);
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setName(HostNameLGValues name) {
        this.Name = name.value();
    }

    public void setName(HostNameDynamicValues name) {
        this.Name = name.value();
    }

    public void setType(HostTypeValues type) {
        this.Type = type.value();

    }

    public void setType(String type) {
        this.Type = type;
    }

    @Override
    public String toString() {
        return "Host{" + "Name = " + Name +
                ", Type = " + Type + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Host", Host.class);
        xstream.aliasField("Name", Host.class, "Name");
        xstream.aliasField("Type", Host.class, "Type");
        xstream.aliasField("Host", Host.class, "Host");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Host xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Host" , Host.class);
        xstream.setClassLoader(Host.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Host)xstream.fromXML(xml);
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }
}
