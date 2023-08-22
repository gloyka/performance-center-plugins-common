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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalthroughput;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TotalThroughput")
public class TotalThroughput {

    @XmlElement
    private String Threshold;

    public TotalThroughput() {
    }

    public TotalThroughput(int threshold) {
        setThreshold(threshold);
    }

    public static TotalThroughput xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TotalThroughput", TotalThroughput.class);
        xstream.setClassLoader(TotalThroughput.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TotalThroughput) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "TotalThroughput{" + "Threshold = " + Threshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TotalThroughput", TotalThroughput.class);
        xstream.aliasField("Threshold", TotalThroughput.class, "Threshold");
        xstream.aliasField("TotalThroughput", TotalThroughput.class, "TotalThroughput");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getThreshold() {
        return Threshold;
    }

    public void setThreshold(int value) {
        this.Threshold = Common.integerToString(value);
    }

    public void setThreshold(String threshold) {
        Threshold = threshold;
    }
}