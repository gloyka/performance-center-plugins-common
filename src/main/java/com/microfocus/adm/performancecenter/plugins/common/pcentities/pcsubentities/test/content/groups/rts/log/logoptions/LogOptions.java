package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.LogOptionsTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Log")
public class LogOptions {

    @XmlAttribute
    private String Type;

    @XmlElement
    private String CacheSize;

    public LogOptions(){}

    public LogOptions(LogOptionsTypeValues type, int cacheSize) {
        setType(type);
        setCacheSize(cacheSize);
    }

    public LogOptions(String type, int cacheSize) {
        setType(type);
        setCacheSize(cacheSize);
    }
    public void setType(String type) {
        this.Type = type;
    }

    public void setType(LogOptionsTypeValues type) {
        this.Type = type.value();
    }

    public void setCacheSize(int cacheSize) {
            this.CacheSize = Common.integerToString(cacheSize);
    }

        @Override
    public String toString() {
        return "LogOptionsTypeValues{" + "Type = " + Type +
                ", CacheSize = " + CacheSize +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("LogOptions", LogOptions.class);
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.aliasField("Type", LogOptions.class, "Type");
        xstream.aliasField("CacheSize", LogOptions.class, "CacheSize");
        xstream.aliasField("LogOptions", LogOptions.class, "LogOptions");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static LogOptions xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.aliasField("Type", LogOptions.class, "Type");
        xstream.alias("LogOptions" , LogOptions.class);
        xstream.setClassLoader(LogOptions.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (LogOptions)xstream.fromXML(xml);
    }
}
