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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.duration;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.TimeInterval;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.DurationTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Duration")
public class Duration {
/* possible values
        Type="indefinitely"
        Type="run for"
        Type="until complete"*/

    @XmlAttribute
    private String Type;

    @XmlElement
    private TimeInterval TimeInterval;

    public Duration() {
        setType(DurationTypeValues.UNTIL_COMPLETE);
    }

    public Duration(String type, TimeInterval timeInterval) {
        setType(type);
        setTimeInterval(timeInterval);
    }

    public Duration(DurationTypeValues type, TimeInterval timeInterval) {
        setType(type);
        setTimeInterval(timeInterval);
    }

    public static Duration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");

        xstream.alias("Duration", Duration.class);
        xstream.setClassLoader(Duration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Duration) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Duration{" +
                "Type = " + Type +
                ", TimeInterval = " + TimeInterval + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Duration", Duration.class);

        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");

        xstream.aliasField("TimeInterval", Duration.class, "TimeInterval");
        xstream.aliasField("Duration", Duration.class, "Duration");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(DurationTypeValues type) {
        this.Type = type.value();
    }

    public TimeInterval getTimeInterval() {
        return TimeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        TimeInterval = timeInterval;
    }
}
