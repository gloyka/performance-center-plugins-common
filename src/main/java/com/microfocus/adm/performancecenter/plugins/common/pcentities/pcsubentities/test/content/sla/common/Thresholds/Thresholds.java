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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Thresholds")
public class Thresholds {
    @XmlElement
    private String LessThanThreshold;
    @XmlElement
    private BetweenThreshold BetweenThreshold;
    @XmlElement
    private String GreaterThanOrEqualThreshold;

    public Thresholds() {
    }

    public Thresholds(int lessThanThreshold, BetweenThreshold betweenThreshold, int greaterThanOrEqualThreshold) {
        setLessThanThreshold(lessThanThreshold);
        setBetweenThreshold(betweenThreshold);
        setGreaterThanOrEqualThreshold(greaterThanOrEqualThreshold);
    }

    public static Thresholds xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Thresholds", Thresholds.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.setClassLoader(Thresholds.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Thresholds) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Thresholds{" + "LessThanThreshold = " + LessThanThreshold +
                ", BetweenThreshold = " + BetweenThreshold +
                ", GreaterThanOrEqualThreshold = " + GreaterThanOrEqualThreshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Thresholds", Thresholds.class);
        xstream.aliasField("LessThanThreshold", Thresholds.class, "LessThanThreshold");
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.aliasField("GreaterThanOrEqualThreshold", Thresholds.class, "GreaterThanOrEqualThreshold");
        xstream.aliasField("Thresholds", Thresholds.class, "Thresholds");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getLessThanThreshold() {
        return LessThanThreshold;
    }

    public void setLessThanThreshold(int value) {
        this.LessThanThreshold = Common.integerToString(value);
    }

    public void setLessThanThreshold(String lessThanThreshold) {
        LessThanThreshold = lessThanThreshold;
    }

    public BetweenThreshold getBetweenThreshold() {
        return BetweenThreshold;
    }

    public void setBetweenThreshold(BetweenThreshold betweenThreshold) {
        BetweenThreshold = betweenThreshold;
    }

    public String getGreaterThanOrEqualThreshold() {
        return GreaterThanOrEqualThreshold;
    }

    public void setGreaterThanOrEqualThreshold(int value) {
        this.GreaterThanOrEqualThreshold = Common.integerToString(value);
    }

    public void setGreaterThanOrEqualThreshold(String greaterThanOrEqualThreshold) {
        GreaterThanOrEqualThreshold = greaterThanOrEqualThreshold;
    }
}