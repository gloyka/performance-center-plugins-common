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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BetweenThreshold")
public class BetweenThreshold {
    @XmlElement
    private ArrayList<String> Threshold;

    public BetweenThreshold() {
    }

    public BetweenThreshold(ArrayList<String> threshold) {
        Threshold = threshold;
    }

    public static BetweenThreshold xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("BetweenThreshold", BetweenThreshold.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.setClassLoader(BetweenThreshold.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (BetweenThreshold) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "BetweenThreshold{" + "Threshold = " + Threshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("BetweenThreshold", BetweenThreshold.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.aliasField("BetweenThreshold", BetweenThreshold.class, "BetweenThreshold");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public ArrayList<String> getThreshold() {
        return Threshold;
    }

    public void setThreshold(ArrayList<String> threshold) {
        Threshold = threshold;
    }
}
