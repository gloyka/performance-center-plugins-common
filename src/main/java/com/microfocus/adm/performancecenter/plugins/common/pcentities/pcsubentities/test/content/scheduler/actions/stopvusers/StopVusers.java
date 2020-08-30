package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.stopvusers;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.Ramp;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.StartStopVusersTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="StopVusers")
public class StopVusers {

    /* possible values:
        Type="simultaneously"
        Type="gradually" */

    @XmlAttribute
    private String Type;

    @XmlElement
    private String Vusers;

    @XmlElement
    private Ramp Ramp;

    public StopVusers() {
        setType(StartStopVusersTypeValues.SIMULTANEOUSLY);
    }

    public StopVusers(String type, int vusers, Ramp ramp) {
        setType (type);
        setVusers(vusers);
        setRamp(ramp);
    }

    public StopVusers(StartStopVusersTypeValues type, int vusers, Ramp ramp) {
        setType (type);
        setVusers(vusers);
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

    @Override
    public String toString() {
        return "StopVusers{" + "Type = " + Type +
                ", Vusers = " + Vusers +
                ", Ramp = " + Ramp + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("StopVusers", StopVusers.class);

        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");

        xstream.aliasField("Vusers", StopVusers.class, "Vusers");
        xstream.aliasField("Ramp", StopVusers.class, "Ramp");
        xstream.aliasField("StopVusers", StopVusers.class, "StopVusers");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static StopVusers xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");

        xstream.alias("StopVusers" , StopVusers.class);
        xstream.setClassLoader(StopVusers.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (StopVusers)xstream.fromXML(xml);
    }

    public String getType() {
        return Type;
    }

    public String getVusers() {
        return Vusers;
    }

    public void setVusers(String vusers) {
        Vusers = vusers;
    }

    public Ramp getRamp() {
        return Ramp;
    }

    public void setRamp(Ramp ramp) {
        Ramp = ramp;
    }
}
