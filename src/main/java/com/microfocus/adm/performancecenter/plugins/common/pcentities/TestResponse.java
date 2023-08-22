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
public class TestResponse {
    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private int ID;
    private String Name;
    private String TestFolderPath;
    private String CreatedBy;
    private String LastModified;
    private Content Content;

    public TestResponse() {
    }

    public TestResponse(int ID, String name, String testFolderPath,
                        String createdBy, String lastModified, Content content) {
        this.ID = ID;
        this.Name = name;
        this.TestFolderPath = testFolderPath;
        this.CreatedBy = createdBy;
        this.LastModified = lastModified;
        this.Content = content;
    }

    public static TestResponse xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Test", TestResponse.class);
        xstream.setClassLoader(TestResponse.class.getClassLoader());
        return (TestResponse) xstream.fromXML(xml);
    }

    @XmlAttribute
    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @XmlAttribute
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    @XmlElement
    public String getLastModified() {
        return LastModified;
    }

    public void setLastModified(String lastModified) {
        LastModified = lastModified;
    }

    public Content getContent() {
        return Content;
    }

    public void setContent(Content content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "TestRequest{" + "ID = " + ID +
                ", Name = " + Name +
                ", TestFolderPath = " + TestFolderPath +
                ", CreatedBy = " + CreatedBy +
                ", LastModified = " + LastModified +
                ", Content = " + Content + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(TestResponse.class, "xmlns");
        xstream.alias("Test", TestResponse.class);
        xstream.aliasField("ID", TestResponse.class, "ID");
        xstream.aliasField("Name", TestResponse.class, "Name");
        xstream.aliasField("TestFolderPath", TestResponse.class, "TestFolderPath");
        xstream.aliasField("CreatedBy", TestResponse.class, "CreatedBy");
        xstream.aliasField("LastModified", TestResponse.class, "LastModified");
        xstream.aliasField("Content", TestResponse.class, "Content");
        return xstream.toXML(this);
    }
}

