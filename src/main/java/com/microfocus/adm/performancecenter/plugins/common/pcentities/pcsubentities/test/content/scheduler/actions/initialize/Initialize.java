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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.initialize;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.common.TimeInterval;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.InitializeTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Initialize")
public class Initialize {

    /*Possible values:
        Type="gradually"
        Type="just before vuser runs"
        Type="simultaneously" */
    @XmlAttribute
    private String Type;

    @XmlElement
    private String Vusers;

    @XmlElement
    private TimeInterval TimeInterval;

    @XmlElement
    private TimeInterval WaitAfterInit;

    public Initialize() {
        setType(InitializeTypeValues.JUST_BEFORE_VUSER_RUNS);
    }

    public Initialize(String type) {
        setType(type);
        setVusers(-1);
        setTimeInterval(null);
        setWaitAfterInit(null);
    }

    public Initialize(InitializeTypeValues type) {
        setType(type);
        setVusers(-1);
        setTimeInterval(null);
        setWaitAfterInit(null);
    }

    public Initialize(String type, int vusers, TimeInterval timeInterval, TimeInterval waitAfterInit) {
        setType(type);
        setVusers(vusers);
        setTimeInterval(timeInterval);
        setWaitAfterInit(waitAfterInit);
    }


    public Initialize(InitializeTypeValues type, int vusers, TimeInterval timeInterval, TimeInterval waitAfterInit) {
        setType(type);
        setVusers(vusers);
        setTimeInterval(timeInterval);
        setWaitAfterInit(waitAfterInit);
    }

    public static Initialize xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");

        xstream.alias("Initialize", Initialize.class);
        xstream.setClassLoader(Initialize.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Initialize) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Initialize{" +
                "Type = " + Type +
                ", Vusers = " + Vusers +
                ", TimeInterval = " + TimeInterval +
                ", WaitAfterInit = " + WaitAfterInit + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Initialize", Initialize.class);

        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");

        xstream.aliasField("Vusers", Initialize.class, "Vusers");
        xstream.aliasField("TimeInterval", Initialize.class, "TimeInterval");
        xstream.aliasField("WaitAfterInit", Initialize.class, "WaitAfterInit");
        xstream.aliasField("Initialize", Initialize.class, "Initialize");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(InitializeTypeValues type) {
        this.Type = type.value();
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

    public TimeInterval getWaitAfterInit() {
        return WaitAfterInit;
    }

    public void setWaitAfterInit(TimeInterval waitAfterInit) {
        WaitAfterInit = waitAfterInit;
    }
}