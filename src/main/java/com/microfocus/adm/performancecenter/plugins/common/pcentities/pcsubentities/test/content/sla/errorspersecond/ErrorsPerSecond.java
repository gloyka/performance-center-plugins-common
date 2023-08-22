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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.errorspersecond;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.Thresholds;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.LoadValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.LoadCriterionValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ErrorsPerSecond")
public class ErrorsPerSecond {
    /*values are:
        running_vusers
        throughput
        hits_per_second
        transactions_per_second
    */
    @XmlElement
    private String LoadCriterion;
    @XmlElement
    private Thresholds Thresholds;
    @XmlElement
    private LoadValues LoadValues;

    public ErrorsPerSecond() {
    }

    public ErrorsPerSecond(String loadCriterion, Thresholds thresholds, LoadValues loadValues) {
        setLoadCriterion(loadCriterion);
        setThresholds(thresholds);
        setLoadValues(loadValues);
    }

    public ErrorsPerSecond(LoadCriterionValues loadCriterion, Thresholds thresholds, LoadValues loadValues) {
        setLoadCriterion(loadCriterion);
        setThresholds(thresholds);
        setLoadValues(loadValues);
    }

    public static ErrorsPerSecond xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ErrorsPerSecond", ErrorsPerSecond.class);
        xstream.alias("Between", Between.class, Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.setClassLoader(ErrorsPerSecond.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (ErrorsPerSecond) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "ErrorsPerSecond{" + "loadvalues = " + LoadCriterion +
                ", Thresholds = " + Thresholds +
                ", LoadValues = " + LoadValues + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ErrorsPerSecond", ErrorsPerSecond.class);
        xstream.aliasField("LoadCriterion", ErrorsPerSecond.class, "LoadCriterion");
        xstream.aliasField("Thresholds", ErrorsPerSecond.class, "Thresholds");
        xstream.aliasField("LoadValues", ErrorsPerSecond.class, "LoadValues");
        xstream.alias("Between", Between.class, Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.aliasField("ErrorsPerSecond", ErrorsPerSecond.class, "ErrorsPerSecond");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getLoadCriterion() {
        return LoadCriterion;
    }

    public void setLoadCriterion(String loadCriterion) {
        this.LoadCriterion = loadCriterion;
    }

    public void setLoadCriterion(LoadCriterionValues loadCriterion) {
        this.LoadCriterion = loadCriterion.value();
    }

    public Thresholds getThresholds() {
        return Thresholds;
    }

    public void setThresholds(Thresholds thresholds) {
        Thresholds = thresholds;
    }

    public LoadValues getLoadValues() {
        return LoadValues;
    }

    public void setLoadValues(LoadValues loadValues) {
        LoadValues = loadValues;
    }
}
