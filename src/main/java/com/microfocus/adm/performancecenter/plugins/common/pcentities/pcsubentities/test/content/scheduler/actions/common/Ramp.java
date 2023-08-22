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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Ramp")
public class Ramp {

    @XmlElement
    private String Vusers;

    @XmlElement
    private TimeInterval TimeInterval;

    public Ramp() {
    }

    public Ramp(int vusers, TimeInterval timeInterval) {
        setVusers(vusers);
        setTimeInterval(timeInterval);
    }

    public static Ramp xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Ramp", Ramp.class);
        xstream.setClassLoader(Ramp.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Ramp) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Ramp{" +
                "Vusers = " + Vusers +
                ", TimeInterval = " + TimeInterval + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Ramp", Ramp.class);
        xstream.aliasField("Vusers", Ramp.class, "Vusers");
        xstream.aliasField("TimeInterval", Ramp.class, "TimeInterval");
        xstream.aliasField("Ramp", Ramp.class, "Ramp");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getVusers() {
        return Vusers;
    }

    public void setVusers(int vusers) {
        this.Vusers = Common.integerToString(vusers);
    }

    public void setVusers(String vusers) {
        Vusers = vusers;
    }

    public TimeInterval getTimeInterval() {
        return TimeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        TimeInterval = timeInterval;
    }
}
