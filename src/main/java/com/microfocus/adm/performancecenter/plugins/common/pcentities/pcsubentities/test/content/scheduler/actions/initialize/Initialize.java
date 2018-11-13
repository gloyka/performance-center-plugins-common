package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.initialize;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.TimeInterval;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.InitializeTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.*;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Initialize")
public class Initialize
{

    /*Possible values:
        Type="gradually"
        Type="just before vuser runs"
        Type="simultaneously" */
    @XmlAttribute
    private String Type;

    @XmlElement
    private String Vusers;

    @XmlElement
    private TimeInterval TimeInterval;

    @XmlElement
    private TimeInterval WaitAfterInit;

    public Initialize() {
        setType(InitializeTypeValues.JUST_BEFORE_VUSER_RUNS);
    }

    public Initialize(String type) {
        setType(type);
        setVusers(-1);
        setTimeInterval(null);
        setWaitAfterInit(null);
    }

    public Initialize(InitializeTypeValues type) {
        setType(type);
        setVusers(-1);
        setTimeInterval(null);
        setWaitAfterInit(null);
    }

    public Initialize(String type, int vusers, TimeInterval timeInterval, TimeInterval waitAfterInit) {
        setType(type);
        setVusers(vusers);
        setTimeInterval(timeInterval);
        setWaitAfterInit(waitAfterInit);
    }


    public Initialize(InitializeTypeValues type, int vusers, TimeInterval timeInterval, TimeInterval waitAfterInit) {
        setType(type);
        setVusers(vusers);
        setTimeInterval(timeInterval);
        setWaitAfterInit(waitAfterInit);
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(InitializeTypeValues type) {
        this.Type = type.value();
    }

    public void setVusers(int vusers) {
        this.Vusers = Common.integerToString(vusers);
    }

    @Override
    public String toString() {
        return "Initialize{" +
                "Type = " + Type +
                ", Vusers = " + Vusers +
                ", TimeInterval = " + TimeInterval +
                ", WaitAfterInit = " + WaitAfterInit + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Initialize", Initialize.class);

        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");

        xstream.aliasField("Vusers", Initialize.class, "Vusers");
        xstream.aliasField("TimeInterval", Initialize.class, "TimeInterval");
        xstream.aliasField("WaitAfterInit", Initialize.class, "WaitAfterInit");
        xstream.aliasField("Initialize", Initialize.class, "Initialize");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Initialize xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");

        xstream.alias("Initialize" , Initialize.class);
        xstream.setClassLoader(Initialize.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Initialize)xstream.fromXML(xml);
    }
}