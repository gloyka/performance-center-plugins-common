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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.workloadtype;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.VusersDistributionModeValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.WorkloadTypeSubTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.WorkloadTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "WorkloadType")
public class WorkloadType {
    /*
    Required. One of:
        basic
        real-world
        goal oriented
    */
    @XmlElement
    private String Type;
    /*
    Required for non "goal oriented" workload type. One of:
        by test
        by group
    */
    @XmlElement
    private String SubType;
    /*
    Required if WorkloadType/SubType is by test. One of:
        by number
        by percentage
    * */
    @XmlElement
    private String VusersDistributionMode;

    public WorkloadType() {
    }

    public WorkloadType(String type, String vusersDistributionMode, String subType) {
        setType(type);
        setVusersDistributionMode(vusersDistributionMode);
        setSubType(subType);
    }

    public WorkloadType(WorkloadTypeValues type, VusersDistributionModeValues vusersDistributionMode, WorkloadTypeSubTypeValues subType) {
        setType(type);
        setVusersDistributionMode(vusersDistributionMode);
        setSubType(subType);
    }

    public static WorkloadType xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("WorkloadType", WorkloadType.class);
        xstream.setClassLoader(WorkloadType.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (WorkloadType) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "WorkloadType{" + "Type = " + Type +
                ", VusersDistributionMode = " + VusersDistributionMode +
                ", SubType = " + SubType +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("WorkloadType", WorkloadType.class);
        xstream.aliasField("Type", WorkloadType.class, "Type");
        xstream.aliasField("VusersDistributionMode", WorkloadType.class, "VusersDistributionMode");
        xstream.aliasField("SubType", WorkloadType.class, "SubType");
        xstream.aliasField("WorkloadType", WorkloadType.class, "WorkloadType");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(WorkloadTypeValues type) {
        this.Type = type.value();
    }

    public String getSubType() {
        return SubType;
    }

    public void setSubType(String subType) {
        this.SubType = subType;
    }

    public void setSubType(WorkloadTypeSubTypeValues subType) {
        this.SubType = subType.value();
    }

    public String getVusersDistributionMode() {
        return VusersDistributionMode;
    }

    public void setVusersDistributionMode(String vusersDistributionMode) {
        this.VusersDistributionMode = vusersDistributionMode;
    }

    public void setVusersDistributionMode(VusersDistributionModeValues vusersDistributionMode) {
        this.VusersDistributionMode = vusersDistributionMode.value();
    }
}