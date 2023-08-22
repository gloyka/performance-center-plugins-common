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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.selenium;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Selenium")
public class Selenium {

    @XmlElement
    private String JREPath;

    @XmlElement
    private String ClassPath;

    @XmlElement
    private String TestNgFiles;


    public Selenium() {
    }

    public Selenium(String jrePath, String classPath, String testNgFiles) {
        setJREPath(jrePath);
        setClassPath(classPath);
        setTestNgFiles(testNgFiles);
    }

    public static Selenium xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Selenium", Selenium.class);
        xstream.setClassLoader(Selenium.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Selenium) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Selenium{" + "JREPath = " + JREPath +
                ", ClassPath = " + ClassPath +
                ", TestNgFiles = " + TestNgFiles +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Selenium", Selenium.class);
        xstream.aliasField("JREPath", Selenium.class, "JREPath");
        xstream.aliasField("ClassPath", Selenium.class, "ClassPath");
        xstream.aliasField("TestNgFiles", Selenium.class, "TestNgFiles");
        xstream.aliasField("JMeter", Selenium.class, "JMeter");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getJREPath() {
        return this.JREPath;
    }

    public void setJREPath(String jrePath) {
        this.JREPath = jrePath;
    }

    public String getClassPath() {
        return this.ClassPath;
    }

    public void setClassPath(String classPath) {
        this.ClassPath = classPath;
    }

    public String getTestNgFiles() {
        return this.TestNgFiles;
    }

    public void setTestNgFiles(String testNgFiles) {
        this.TestNgFiles = testNgFiles;
    }
}
