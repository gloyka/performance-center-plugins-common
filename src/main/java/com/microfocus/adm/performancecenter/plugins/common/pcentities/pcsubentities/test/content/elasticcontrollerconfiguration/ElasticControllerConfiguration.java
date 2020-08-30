package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticcontrollerconfiguration;


import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common.integerToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ElasticControllerConfiguration")
public class ElasticControllerConfiguration {

    @XmlElement
    private String ImageId;

    @XmlElement
    private String MemoryLimit;

    @XmlElement
    private String CpuLimit;

    public ElasticControllerConfiguration() {
    }

    public ElasticControllerConfiguration(String imageId) {
        setImageId(imageId);
    }

    public ElasticControllerConfiguration(int imageId, int memoryLimit, int cpuLimit) {
        ImageId = integerToString(imageId);
        MemoryLimit = integerToString(memoryLimit);
        CpuLimit = integerToString(cpuLimit);
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("ElasticControllerConfiguration", ElasticControllerConfiguration.class);
        xstream.aliasField("ImageId", ElasticControllerConfiguration.class, "ImageId");
        xstream.aliasField("MemoryLimit", ElasticControllerConfiguration.class, "MemoryLimit");
        xstream.aliasField("CpuLimit", ElasticControllerConfiguration.class, "CpuLimit");

        xstream.aliasField("ElasticControllerConfiguration", ElasticControllerConfiguration.class, "ElasticControllerConfiguration");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static ElasticControllerConfiguration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ElasticControllerConfiguration" , ElasticControllerConfiguration.class);
        xstream.setClassLoader(ElasticControllerConfiguration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ElasticControllerConfiguration)xstream.fromXML(xml);
    }

    public String getImageId() {
        return ImageId;
    }

    public void setImageId(String imageId) {
        ImageId = imageId;
    }

    public String getMemoryLimit() {
        return MemoryLimit;
    }

    public void setMemoryLimit(String memoryLimit) {
        MemoryLimit = memoryLimit;
    }

    public String getCpuLimit() {
        return CpuLimit;
    }

    public void setCpuLimit(String cpuLimit) {
        CpuLimit = cpuLimit;
    }
}
