package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;

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
@XmlRootElement(name="Pacing")
public class Pacing
{

    @XmlElement
    private String NumberOfIterations;

    @XmlElement
    private StartNewIteration StartNewIteration;

    public Pacing() {}

    public Pacing(int numberOfIterations, StartNewIteration startNewIteration) {
        setNumberOfIterations(numberOfIterations);
        setStartNewIteration(startNewIteration);
    }

    public void setNumberOfIterations(int numberOfIterations) {
            this.NumberOfIterations = Common.integerToString(numberOfIterations);
    }

    @Override
    public String toString() {
        return "Pacing{" + "NumberOfIterations = " + NumberOfIterations +
                ", StartNewIteration = " + StartNewIteration + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Pacing", Pacing.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("NumberOfIterations", Pacing.class, "NumberOfIterations");
        xstream.aliasField("StartNewIteration", Pacing.class, "StartNewIteration");
        xstream.aliasField("Pacing", Pacing.class, "Pacing");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Pacing xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Pacing" , Pacing.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.setClassLoader(Pacing.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Pacing)xstream.fromXML(xml);
    }

}
