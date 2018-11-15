package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="JMeter")
public class JMeter {

    @XmlElement
    private boolean StartMeasurements;

    @XmlElement
    private String JMeterHomePath;

    @XmlElement
    private boolean JMeterUseDefaultPort;

    @XmlElement
    private String JMeterMinPort;

    @XmlElement
    private String JMeterMaxPort;

    @XmlElement
    private boolean JMeterDistributeMode;

    @XmlElement
    private String JMeterAdditionalProperties;

    public JMeter() {
        setStartMeasurements(true);
        setJMeterUseDefaultPort(true);
        setJMeterMinPort(4445);
        setJMeterMaxPort(4455);
        setJMeterDistributeMode(false);
    }

    public JMeter(boolean startMeasurements, String jMeterHomePath, boolean jMeterUseDefaultPort, int jMeterMinPort, int jMeterMaxPort) {
        setStartMeasurements(startMeasurements);
        setJMeterHomePath(jMeterHomePath);
        setJMeterUseDefaultPort(jMeterUseDefaultPort);
        setJMeterMinPort(jMeterMinPort);
        setJMeterMaxPort(jMeterMaxPort);
    }

    public JMeter(boolean startMeasurements, String jMeterHomePath, boolean jMeterUseDefaultPort, int jMeterMinPort, int jMeterMaxPort, boolean jMeterDistributeMode) {
        setStartMeasurements(startMeasurements);
        setJMeterHomePath(jMeterHomePath);
        setJMeterUseDefaultPort(jMeterUseDefaultPort);
        setJMeterMinPort(jMeterMinPort);
        setJMeterMaxPort(jMeterMaxPort);
        setJMeterMaxPort(jMeterMaxPort);
        setJMeterDistributeMode(jMeterDistributeMode);
    }

    public void setJMeterMinPort(int JMeterMinPort) {
            this.JMeterMinPort = Common.integerToString(JMeterMinPort);
    }

    public void setJMeterMaxPort(int JMeterMaxPort) {
            this.JMeterMaxPort = Common.integerToString(JMeterMaxPort);
    }


    @Override
    public String toString() {
        return "JMeter{" + "StartMeasurements = " + StartMeasurements +
                ", JMeterHomePath = " + JMeterHomePath +
                ", JMeterUseDefaultPort = " + JMeterUseDefaultPort +
                ", JMeterMinPort = " + JMeterMinPort +
                ", JMeterMaxPort = " + JMeterMaxPort +
                ", JMeterDistributeMode = " + JMeterDistributeMode +
                ", JMeterAdditionalProperties = " + JMeterAdditionalProperties +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JMeter", JMeter.class);
        xstream.aliasField("StartMeasurements", JMeter.class, "StartMeasurements");
        xstream.aliasField("JMeterHomePath", JMeter.class, "JMeterHomePath");
        xstream.aliasField("JMeterUseDefaultPort", JMeter.class, "JMeterUseDefaultPort");
        xstream.aliasField("JMeterMinPort", JMeter.class, "JMeterMinPort");
        xstream.aliasField("JMeterMaxPort", JMeter.class, "JMeterMaxPort");
        xstream.aliasField("JMeterDistributeMode", JMeter.class, "JMeterDistributeMode");
        xstream.aliasField("JMeterAdditionalProperties", JMeter.class, "JMeterAdditionalProperties");
        xstream.aliasField("JMeter", JMeter.class, "JMeter");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static JMeter xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JMeter" , JMeter.class);
        xstream.setClassLoader(JMeter.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (JMeter)xstream.fromXML(xml);
    }

}
