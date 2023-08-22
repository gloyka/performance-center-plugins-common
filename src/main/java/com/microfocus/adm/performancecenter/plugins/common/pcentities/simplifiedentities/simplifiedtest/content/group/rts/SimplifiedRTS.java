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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.javavm.SimplifiedJavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.jmeter.SimplifiedJMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.pacing.SimplifiedPacing;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.selenium.SimplifiedSelenium;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.thinktime.SimplifiedThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class SimplifiedRTS {

    private SimplifiedJavaVM java_vm;

    private SimplifiedJMeter jmeter;

    private SimplifiedSelenium selenium;

    private SimplifiedPacing pacing;

    private SimplifiedThinkTime thinktime;

    public SimplifiedRTS() {
    }

    public SimplifiedRTS(SimplifiedJavaVM java_vm, SimplifiedJMeter jmeter, SimplifiedPacing pacing, SimplifiedThinkTime thinktime, SimplifiedSelenium selenium) {
        this.java_vm = java_vm;
        this.jmeter = jmeter;
        this.pacing = pacing;
        this.thinktime = thinktime;
        this.selenium = selenium;
    }

    public static SimplifiedRTS xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedRTS", SimplifiedRTS.class);

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.setClassLoader(SimplifiedRTS.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedRTS) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "SimplifiedRTS {" +
                "java_vm = " + java_vm +
                ", " + "pacing = " + pacing +
                ", " + "thinktime = " + thinktime +
                ", " + "jmeter = " + jmeter +
                ", " + "selenium = " + selenium +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedRTS", SimplifiedRTS.class);
        xstream.aliasField("java_vm", SimplifiedRTS.class, "java_vm");
        xstream.aliasField("pacing", SimplifiedRTS.class, "pacing");
        xstream.aliasField("thinktime", SimplifiedRTS.class, "thinktime");
        xstream.aliasField("jmeter", SimplifiedRTS.class, "jmeter");
        xstream.aliasField("selenium", SimplifiedRTS.class, "selenium");

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.aliasField("SimplifiedRTS", SimplifiedRTS.class, "SimplifiedRTS");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public SimplifiedJavaVM getJava_vm() {
        return java_vm;
    }

    public void setJava_vm(SimplifiedJavaVM java_vm) {
        this.java_vm = java_vm;
    }

    public SimplifiedJMeter getJmeter() {
        return jmeter;
    }

    public void setJmeter(SimplifiedJMeter jmeter) {
        this.jmeter = jmeter;
    }

    public SimplifiedSelenium getSelenium() {
        return selenium;
    }

    public SimplifiedPacing getPacing() {
        return pacing;
    }

    public void setPacing(SimplifiedPacing pacing) {
        this.pacing = pacing;
    }

    public SimplifiedThinkTime getThinktime() {
        return thinktime;
    }

    public void setThinktime(SimplifiedThinkTime thinktime) {
        this.thinktime = thinktime;
    }
}
