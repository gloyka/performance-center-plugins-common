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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.thinktime;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.enums.SimplifiedThinkTimeTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class SimplifiedThinkTime {

    private String type;

    private int min_percentage;

    private int max_percentage;

    private int limit_seconds;

    private int multiply_factor;

    public SimplifiedThinkTime() {
        setType(SimplifiedThinkTimeTypeValues.IGNORE.value());
    }

    public SimplifiedThinkTime(String type, int min_percentage, int max_percentage, int limit_seconds, int multiply_factor) {
        setType(type);
        this.min_percentage = min_percentage;
        this.max_percentage = max_percentage;
        this.limit_seconds = limit_seconds;
        this.multiply_factor = multiply_factor;
    }

//    public SimplifiedThinkTime(SimplifiedThinkTimeTypeValues type, int min_percentage, int max_percentage, int limit_seconds, int multiply_factor) {
//        setType(type);
//        this.min_percentage = min_percentage;
//        this.max_percentage = max_percentage;
//        this.limit_seconds = limit_seconds;
//        this.multiply_factor = multiply_factor;
//    }

    public static SimplifiedThinkTime xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedThinkTime", SimplifiedThinkTime.class);

        xstream.setClassLoader(SimplifiedThinkTime.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedThinkTime) xstream.fromXML(xml);
    }

//    public void setType(SimplifiedThinkTimeTypeValues type) {
//        this.type = type.value();
//    }

    @Override
    public String toString() {
        return "SimplifiedThinkTime {" +
                "type = " + type +
                ", " + "min_percentage = " + min_percentage +
                ", " + "max_percentage = " + max_percentage +
                ", " + "limit_seconds = " + limit_seconds +
                ", " + "multiply_factor = " + multiply_factor +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedThinkTime", SimplifiedThinkTime.class);
        xstream.aliasField("type", SimplifiedThinkTime.class, "type");
        xstream.aliasField("min_percentage", SimplifiedThinkTime.class, "min_percentage");
        xstream.aliasField("max_percentage", SimplifiedThinkTime.class, "max_percentage");
        xstream.aliasField("limit_seconds", SimplifiedThinkTime.class, "limit_seconds");
        xstream.aliasField("multiply_factor", SimplifiedThinkTime.class, "multiply_factor");
        xstream.aliasField("SimplifiedThinkTime", SimplifiedThinkTime.class, "SimplifiedThinkTime");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMin_percentage() {
        return min_percentage;
    }

    public void setMin_percentage(int min_percentage) {
        this.min_percentage = min_percentage;
    }

    public int getMax_percentage() {
        return max_percentage;
    }

    public void setMax_percentage(int max_percentage) {
        this.max_percentage = max_percentage;
    }

    public int getLimit_seconds() {
        return limit_seconds;
    }

    public void setLimit_seconds(int limit_seconds) {
        this.limit_seconds = limit_seconds;
    }

    public int getMultiply_factor() {
        return multiply_factor;
    }

    public void setMultiply_factor(int multiply_factor) {
        this.multiply_factor = multiply_factor;
    }
}
