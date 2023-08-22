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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.selenium;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class SimplifiedSelenium {


    private String jre_path;

    private String class_path;

    private String test_ng_files;

    public SimplifiedSelenium() {
    }

    public SimplifiedSelenium(String jre_path, String class_path, String test_ng_files) {
        setJre_path(jre_path);
        setClass_path(class_path);
        setTest_ng_files(test_ng_files);
    }

    public static SimplifiedSelenium xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedSelenium", SimplifiedSelenium.class);

        xstream.setClassLoader(SimplifiedSelenium.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedSelenium) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "SimplifiedSelenium {" +
                "jre_path = " + jre_path +
                ", " + "class_path = " + class_path +
                ", " + "test_ng_files = " + test_ng_files +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedSelenium", SimplifiedSelenium.class);
        xstream.aliasField("jre_path", SimplifiedSelenium.class, "jre_path");
        xstream.aliasField("class_path", SimplifiedSelenium.class, "class_path");
        xstream.aliasField("test_ng_files", SimplifiedSelenium.class, "test_ng_files");

        xstream.aliasField("SimplifiedSelenium", SimplifiedSelenium.class, "SimplifiedSelenium");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getJre_path() {
        return this.jre_path;
    }

    public void setJre_path(String jre_path) {
        this.jre_path = jre_path;
    }

    public String getClass_path() {
        return this.class_path;
    }

    public void setClass_path(String class_path) {
        this.class_path = class_path;
    }

    public String getTest_ng_files() {
        return this.test_ng_files;
    }

    public void setTest_ng_files(String test_ng_files) {
        this.test_ng_files = test_ng_files;
    }
}