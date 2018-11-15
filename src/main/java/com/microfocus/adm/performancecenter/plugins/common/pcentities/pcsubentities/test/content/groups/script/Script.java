package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.script;

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
@XmlRootElement(name="Script")
public class Script
{
    @XmlElement
    private String ID;

    @XmlElement
    private String ProtocolType;

    public Script(){}

    public Script(int ID) {
        setID(ID);
    }

    public Script(int ID, String protocolType) {
        setID(ID);
        setProtocolType(protocolType);
    }

    public void setID(int value) {
        this.ID = Common.integerToString(value);
    }

    @Override
    public String toString() {
        return "Script{" + "ID = " + ID +
            "ProtocolType = " + ProtocolType + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script", Script.class);
        xstream.aliasField("ID", Script.class, "ID");

        xstream.omitField(Script.class, "ProtocolType" );

        xstream.aliasField("Script", Script.class, "Script");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Script xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script" , Script.class);
        xstream.setClassLoader(Script.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Script)xstream.fromXML(xml);
    }
}