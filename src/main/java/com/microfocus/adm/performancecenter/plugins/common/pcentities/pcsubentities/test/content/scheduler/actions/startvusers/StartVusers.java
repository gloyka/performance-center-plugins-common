package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.Ramp;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.StartStopVusersTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.*;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="StartVusers")
public class StartVusers
{

    /*possible values:
        Type="simultaneously"
        Type="gradually" */
    @XmlAttribute
    private String Type;

    @XmlElement
    private String Vusers;

    @XmlElement
    private Ramp Ramp;

    public StartVusers() {
        setType(StartStopVusersTypeValues.SIMULTANEOUSLY);
    }

    public StartVusers(String type, int vusers, Ramp ramp) {
        setType (type);
        setVusers(vusers);
        setRamp(ramp);
    }

    public StartVusers(StartStopVusersTypeValues type, int vusers, Ramp ramp) {
        setType (type);
        setVusers(vusers);
        setRamp(ramp);
    }

    public StartVusers(StartStopVusersTypeValues type,  Ramp ramp) {
        setType (type);
        setVusers(null);
        setRamp(ramp);
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(StartStopVusersTypeValues type) {
        this.Type = type.value();
    }

    public void setVusers(int value) {
        this.Vusers = Common.integerToString(value);
    }

    public void setVusers(String value) {
        this.Vusers = value;
    }

    @Override
    public String toString() {
        return "StartVusers{" + "Type = " + Type +
                ", Vusers = " + Vusers +
                ", Ramp = " + Ramp + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("StartVusers", StartVusers.class);

        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");

        if(Vusers != null && !Vusers.isEmpty())
            xstream.aliasField("Vusers", StartVusers.class, "Vusers");

        xstream.aliasField("Ramp", StartVusers.class, "Ramp");
        xstream.aliasField("StartVusers", StartVusers.class, "StartVusers");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static StartVusers xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");

        xstream.alias("StartVusers" , StartVusers.class);
        xstream.setClassLoader(StartVusers.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (StartVusers)xstream.fromXML(xml);
    }


}

