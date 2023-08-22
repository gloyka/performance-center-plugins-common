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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Pacing")
public class Pacing {

    @XmlElement
    private String NumberOfIterations;

    @XmlElement
    private StartNewIteration StartNewIteration;

    public Pacing() {
    }

    public Pacing(int numberOfIterations, StartNewIteration startNewIteration) {
        setNumberOfIterations(numberOfIterations);
        setStartNewIteration(startNewIteration);
    }

    public static Pacing xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Pacing", Pacing.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.setClassLoader(Pacing.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Pacing) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Pacing{" + "NumberOfIterations = " + NumberOfIterations +
                ", StartNewIteration = " + StartNewIteration + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Pacing", Pacing.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("NumberOfIterations", Pacing.class, "NumberOfIterations");
        xstream.aliasField("StartNewIteration", Pacing.class, "StartNewIteration");
        xstream.aliasField("Pacing", Pacing.class, "Pacing");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getNumberOfIterations() {
        return NumberOfIterations;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        this.NumberOfIterations = Common.integerToString(numberOfIterations);
    }

    public void setNumberOfIterations(String numberOfIterations) {
        NumberOfIterations = numberOfIterations;
    }

    public StartNewIteration getStartNewIteration() {
        return StartNewIteration;
    }

    public void setStartNewIteration(StartNewIteration startNewIteration) {
        StartNewIteration = startNewIteration;
    }
}
