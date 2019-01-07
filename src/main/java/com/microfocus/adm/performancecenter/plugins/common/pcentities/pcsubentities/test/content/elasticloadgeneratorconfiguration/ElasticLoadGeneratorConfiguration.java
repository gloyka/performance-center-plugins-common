package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticloadgeneratorconfiguration;


import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common.integerToString;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ElasticLoadGeneratorConfiguration")
public class ElasticLoadGeneratorConfiguration {

    @XmlElement
    private String ImageId;

    @XmlElement
    private String MemoryLimit;

    @XmlElement
    private String CpuLimit;

    public ElasticLoadGeneratorConfiguration() {
    }

    public ElasticLoadGeneratorConfiguration(String imageId) {
        setImageId(imageId);
    }

    public ElasticLoadGeneratorConfiguration(int imageId, int memoryLimit, int cpuLimit) {
        ImageId = integerToString(imageId);
        MemoryLimit = integerToString(memoryLimit);
        CpuLimit = integerToString(cpuLimit);
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("ElasticLoadGeneratorConfiguration", ElasticLoadGeneratorConfiguration.class);
        xstream.aliasField("ImageId", ElasticLoadGeneratorConfiguration.class, "ImageId");
        xstream.aliasField("MemoryLimit", ElasticLoadGeneratorConfiguration.class, "MemoryLimit");
        xstream.aliasField("CpuLimit", ElasticLoadGeneratorConfiguration.class, "CpuLimit");

        xstream.aliasField("ElasticLoadGeneratorConfiguration", ElasticLoadGeneratorConfiguration.class, "ElasticLoadGeneratorConfiguration");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static ElasticLoadGeneratorConfiguration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ElasticLoadGeneratorConfiguration" , ElasticLoadGeneratorConfiguration.class);
        xstream.setClassLoader(ElasticLoadGeneratorConfiguration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ElasticLoadGeneratorConfiguration)xstream.fromXML(xml);
    }

}
