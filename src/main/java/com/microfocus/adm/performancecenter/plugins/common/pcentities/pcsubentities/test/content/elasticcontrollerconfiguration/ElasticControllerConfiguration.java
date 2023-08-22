/**
 * Copyright © 2023 Open Text Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.elasticcontrollerconfiguration;


import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common.integerToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ElasticControllerConfiguration")
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

    public static ElasticControllerConfiguration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ElasticControllerConfiguration", ElasticControllerConfiguration.class);
        xstream.setClassLoader(ElasticControllerConfiguration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ElasticControllerConfiguration) xstream.fromXML(xml);
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
