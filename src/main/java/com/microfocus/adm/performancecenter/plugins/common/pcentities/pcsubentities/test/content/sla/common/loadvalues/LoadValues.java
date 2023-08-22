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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LoadValues")
public class LoadValues {
    @XmlElement
    private String LessThan;
    @XmlElement
    private ArrayList<Between> Betweens;
    @XmlElement
    private String GreaterThanOrEqual;

    public LoadValues() {
    }

    public LoadValues(int lessThan, ArrayList<Between> betweens, int greaterThanOrEqual) {
        setLessThan(lessThan);
        setBetweens(betweens);
        setGreaterThanOrEqual(greaterThanOrEqual);
    }

    public static LoadValues xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("LoadValues", LoadValues.class);
        xstream.alias("Between", Between.class, Between.class);
        xstream.aliasField("LoadValues", LoadValues.class, "LoadValues");
        xstream.setClassLoader(LoadValues.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (LoadValues) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "LoadValues{" + "LessThan = " + LessThan +
                ", Betweens = " + Betweens +
                ", GreaterThanOrEqual = " + GreaterThanOrEqual + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("LoadValues", LoadValues.class);
        xstream.aliasField("LessThan", LoadValues.class, "LessThan");
        xstream.aliasField("Betweens", LoadValues.class, "Betweens");
        xstream.alias("Between", Between.class, Between.class);
        xstream.aliasField("GreaterThanOrEqual", LoadValues.class, "GreaterThanOrEqual");
        xstream.aliasField("LoadValues", LoadValues.class, "LoadValues");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getLessThan() {
        return LessThan;
    }

    public void setLessThan(int value) {
        this.LessThan = Common.integerToString(value);
    }

    public void setLessThan(String lessThan) {
        LessThan = lessThan;
    }

    public ArrayList<Between> getBetweens() {
        return Betweens;
    }

    public void setBetweens(ArrayList<Between> betweens) {
        Betweens = betweens;
    }

    public String getGreaterThanOrEqual() {
        return GreaterThanOrEqual;
    }

    public void setGreaterThanOrEqual(int value) {
        this.GreaterThanOrEqual = Common.integerToString(value);
    }

    public void setGreaterThanOrEqual(String greaterThanOrEqual) {
        GreaterThanOrEqual = greaterThanOrEqual;
    }
}
