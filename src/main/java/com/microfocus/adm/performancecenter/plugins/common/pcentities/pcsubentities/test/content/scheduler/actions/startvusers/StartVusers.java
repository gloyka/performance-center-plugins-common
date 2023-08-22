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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.Ramp;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.StartStopVusersTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "StartVusers")
public class StartVusers {
    /*possible values:
        Type="simultaneously"
        Type="gradually" */
    @XmlAttribute
    private String Type;
    @XmlElement
    private String Vusers;
    @XmlElement
    private Ramp Ramp;

    public StartVusers() {
        setType(StartStopVusersTypeValues.SIMULTANEOUSLY);
    }

    public StartVusers(String type, int vusers, Ramp ramp) {
        setType(type);
        setVusers(vusers);
        setRamp(ramp);
    }

    public StartVusers(StartStopVusersTypeValues type, int vusers, Ramp ramp) {
        setType(type);
        setVusers(vusers);
        setRamp(ramp);
    }

    public StartVusers(StartStopVusersTypeValues type, Ramp ramp) {
        setType(type);
        setVusers(null);
        setRamp(ramp);
    }

    public static StartVusers xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.alias("StartVusers", StartVusers.class);
        xstream.setClassLoader(StartVusers.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (StartVusers) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "StartVusers{" + "Type = " + Type +
                ", Vusers = " + Vusers +
                ", Ramp = " + Ramp + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("StartVusers", StartVusers.class);
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        if (Vusers != null && !Vusers.isEmpty())
            xstream.aliasField("Vusers", StartVusers.class, "Vusers");
        xstream.aliasField("Ramp", StartVusers.class, "Ramp");
        xstream.aliasField("StartVusers", StartVusers.class, "StartVusers");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(StartStopVusersTypeValues type) {
        this.Type = type.value();
    }

    public String getVusers() {
        return Vusers;
    }

    public void setVusers(int value) {
        this.Vusers = Common.integerToString(value);
    }

    public void setVusers(String value) {
        this.Vusers = value;
    }

    public Ramp getRamp() {
        return Ramp;
    }

    public void setRamp(Ramp ramp) {
        Ramp = ramp;
    }
}

