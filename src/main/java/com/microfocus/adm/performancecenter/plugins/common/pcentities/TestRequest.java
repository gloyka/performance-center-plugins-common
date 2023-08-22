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
package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Test")
public class TestRequest {
    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private String Name;
    private String TestFolderPath;
    private Content Content;

    public TestRequest() {
    }

    public TestRequest(String name, String testFolderPath, Content content) {
        this.Name = name;
        this.TestFolderPath = testFolderPath;
        this.Content = content;
    }

    public static TestRequest xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Test", TestRequest.class);
        xstream.setClassLoader(TestRequest.class.getClassLoader());
        return (TestRequest) xstream.fromXML(xml);
    }

    @XmlAttribute
    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @XmlElement
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @XmlElement
    public String getTestFolderPath() {
        return TestFolderPath;
    }

    public void setTestFolderPath(String testFolderPath) {
        TestFolderPath = testFolderPath;
    }

    @XmlElement
    public Content getContent() {
        return Content;
    }

    public void setContent(Content content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "TestRequest{" + "Name = " + Name +
                ", TestFolderPath = " + TestFolderPath +
                ", Content = " + Content + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(TestRequest.class, "xmlns");
        xstream.alias("Test", TestRequest.class);
        xstream.aliasField("Name", TestRequest.class, "Name");
        xstream.aliasField("TestFolderPath", TestRequest.class, "TestFolderPath");
        xstream.aliasField("Content", TestRequest.class, "cCntent");
        return xstream.toXML(this);
    }
}