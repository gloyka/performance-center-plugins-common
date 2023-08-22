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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.StartNewIterationTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.xml.bind.annotation.*;

import static com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common.integerToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "StartNewIteration")
public class StartNewIteration {
    @XmlAttribute
    @XStreamAsAttribute
    private String Type;

    @XmlElement
    @XStreamAlias("DelayOfSeconds")
    private String DelayOfSeconds;

    @XmlElement
    @XStreamAlias("DelayAtRangeOfSeconds")
    private String DelayAtRangeOfSeconds;

    @XmlElement
    @XStreamAlias("DelayAtRangeToSeconds")
    private String DelayAtRangeToSeconds;

    public StartNewIteration() {
        setType(StartNewIterationTypeValues.IMMEDIATELY);
        setDelayAtRangeOfSeconds(-1);
        setDelayAtRangeToSeconds(-1);
    }

    public StartNewIteration(StartNewIterationTypeValues type) {
        setType(type);
        setDelayAtRangeOfSeconds(-1);
        setDelayAtRangeToSeconds(-1);
    }

    public StartNewIteration(String type) {
        setType(type);
        setDelayAtRangeOfSeconds(-1);
        setDelayAtRangeToSeconds(-1);
    }

    public StartNewIteration(StartNewIterationTypeValues type, int delayOfSeconds, int delayAtRangeOfSeconds, int delayAtRangeToSeconds) {
        setType(type);
        if (type.equals(StartNewIterationTypeValues.IMMEDIATELY.value())) {
            setDelayOfSeconds(-1);
            setDelayAtRangeOfSeconds(-1);
            setDelayAtRangeToSeconds(-1);
        } else if (type.equals(StartNewIterationTypeValues.FIXED_DELAY.value()) || type.equals(StartNewIterationTypeValues.FIXED_INTERVAL.value())) {
            setDelayOfSeconds(delayOfSeconds);
            setDelayAtRangeOfSeconds(-1);
            setDelayAtRangeToSeconds(-1);
        } else if (type.equals(StartNewIterationTypeValues.RANDOM_DELAY.value()) || type.equals(StartNewIterationTypeValues.RANDOM_INTERVAL.value())) {
            setDelayOfSeconds(-1);
            setDelayAtRangeOfSeconds(delayAtRangeOfSeconds);
            setDelayAtRangeToSeconds(delayAtRangeToSeconds);
        }
    }

    public StartNewIteration(String type, int delayOfSeconds, int delayAtRangeOfSeconds, int delayAtRangeToSeconds) {
        setType(type);
        if (type.equals(StartNewIterationTypeValues.IMMEDIATELY.value())) {
            setDelayOfSeconds(-1);
            setDelayAtRangeOfSeconds(-1);
            setDelayAtRangeToSeconds(-1);
        } else if (type.equals(StartNewIterationTypeValues.FIXED_DELAY.value()) || type.equals(StartNewIterationTypeValues.FIXED_INTERVAL.value())) {
            setDelayOfSeconds(delayOfSeconds);
            setDelayAtRangeOfSeconds(-1);
            setDelayAtRangeToSeconds(-1);
        } else if (type.equals(StartNewIterationTypeValues.RANDOM_DELAY.value()) || type.equals(StartNewIterationTypeValues.RANDOM_INTERVAL.value())) {
            setDelayOfSeconds(-1);
            setDelayAtRangeOfSeconds(delayAtRangeOfSeconds);
            setDelayAtRangeToSeconds(delayAtRangeToSeconds);
        }
    }

    public static StartNewIteration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("DelayAtRangeOfSeconds", StartNewIteration.class, "DelayAtRangeOfSeconds");
        xstream.aliasField("DelayAtRangeToSeconds", StartNewIteration.class, "DelayAtRangeToSeconds");
        xstream.alias("DelayAtRangeOfSeconds", StartNewIteration.class, StartNewIteration.class);
        xstream.alias("StartNewIteration", StartNewIteration.class);
        xstream.setClassLoader(StartNewIteration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (StartNewIteration) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "StartNewIteration{" +
                "Type = " + Type +
                ", DelayAtRangeOfSeconds = " + DelayAtRangeOfSeconds + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("StartNewIteration", StartNewIteration.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("DelayOfSeconds", StartNewIteration.class, "DelayOfSeconds");
        xstream.aliasField("DelayAtRangeOfSeconds", StartNewIteration.class, "DelayAtRangeOfSeconds");
        xstream.aliasField("DelayAtRangeToSeconds", StartNewIteration.class, "DelayAtRangeToSeconds");
        xstream.aliasField("StartNewIteration", StartNewIteration.class, "StartNewIteration");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(StartNewIterationTypeValues type) {
        this.Type = type.value();
    }

    public String getDelayOfSeconds() {
        return DelayOfSeconds;
    }

    public void setDelayOfSeconds(int delayOfSeconds) {
        this.DelayOfSeconds = integerToString(delayOfSeconds);
    }

    public void setDelayOfSeconds(String delayOfSeconds) {
        DelayOfSeconds = delayOfSeconds;
    }

    public String getDelayAtRangeOfSeconds() {
        return DelayAtRangeOfSeconds;
    }

    public void setDelayAtRangeOfSeconds(int delayAtRangeOfSeconds) {
        this.DelayAtRangeOfSeconds = integerToString(delayAtRangeOfSeconds);
    }

    public void setDelayAtRangeOfSeconds(String delayAtRangeOfSeconds) {
        DelayAtRangeOfSeconds = delayAtRangeOfSeconds;
    }

    public String getDelayAtRangeToSeconds() {
        return DelayAtRangeToSeconds;
    }

    public void setDelayAtRangeToSeconds(int delayAtRangeToSeconds) {
        this.DelayAtRangeToSeconds = integerToString(delayAtRangeToSeconds);
    }

    public void setDelayAtRangeToSeconds(String delayAtRangeToSeconds) {
        DelayAtRangeToSeconds = delayAtRangeToSeconds;
    }
}