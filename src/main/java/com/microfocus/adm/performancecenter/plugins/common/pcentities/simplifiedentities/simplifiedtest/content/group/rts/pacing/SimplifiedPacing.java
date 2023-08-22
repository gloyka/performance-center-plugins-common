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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.pacing;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.enums.SimplifiedPacingTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class SimplifiedPacing {


    private int number_of_iterations;

    private String type;

    private int delay;

    private int delay_random_range;

    public SimplifiedPacing() {
        this.number_of_iterations = 1;
        setType(SimplifiedPacingTypeValues.IMMEDIATELY.value());
    }

    public SimplifiedPacing(int number_of_iterations, String type, int delay, int delay_random_range) {
        this.number_of_iterations = number_of_iterations;
        setType(type);
        this.delay = delay;
        this.delay_random_range = delay_random_range;
    }

//    public SimplifiedPacing(int number_of_iterations, SimplifiedPacingTypeValues type, int delay, int delay_random_range) {
//        this.number_of_iterations = number_of_iterations;
//        setType(type);
//        this.delay = delay;
//        this.delay_random_range = delay_random_range;
//    }

    public static SimplifiedPacing xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedPacing", SimplifiedPacing.class);

        xstream.setClassLoader(SimplifiedPacing.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedPacing) xstream.fromXML(xml);
    }

//    public void setType (SimplifiedPacingTypeValues type) {
//        this.type = type.value();
//    }

    @Override
    public String toString() {
        return "SimplifiedPacing {" +
                "number_of_iterations = " + number_of_iterations +
                ", " + "type = " + type +
                ", " + "delay = " + delay +
                ", " + "delay_random_range = " + delay_random_range +
                "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedPacing", SimplifiedPacing.class);
        xstream.aliasField("number_of_iterations", SimplifiedPacing.class, "number_of_iterations");
        xstream.aliasField("type", SimplifiedPacing.class, "type");
        xstream.aliasField("delay", SimplifiedPacing.class, "delay");
        xstream.aliasField("delay_random_range", SimplifiedPacing.class, "delay_random_range");
        xstream.aliasField("SimplifiedPacing", SimplifiedPacing.class, "SimplifiedPacing");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public int getNumber_of_iterations() {
        return number_of_iterations;
    }

    public void setNumber_of_iterations(int number_of_iterations) {
        this.number_of_iterations = number_of_iterations;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay_random_range() {
        return delay_random_range;
    }

    public void setDelay_random_range(int delay_random_range) {
        this.delay_random_range = delay_random_range;
    }
}
