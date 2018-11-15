package com.microfocus.adm.performancecenter.plugins.common.pcentities;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.SLA;
import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Test")
public class TestResponse
{

    private String xmlns = PcRestProxy.PC_API_XMLNS;

    private int ID;

    private String Name;

    private String TestFolderPath;

    private String CreatedBy;

    private String LastModified;

    private Content Content;

    public TestResponse(){}


    public TestResponse(int ID, String name, String testFolderPath, String createdBy, String lastModified, Content content){
        this.ID = ID;
        this.Name = name;
        this.TestFolderPath = testFolderPath;
        this.CreatedBy = createdBy;
        this.LastModified = lastModified;
        this.Content = content;
    }

    @XmlAttribute
    public String getXmlns() {
        return xmlns;
    }

    @XmlAttribute
    public int getID() {
        return ID;
    }

    @XmlElement
    public String getName() {
        return Name;
    }

    @XmlElement
    public String getTestFolderPath() {
        return TestFolderPath;
    }

    @XmlElement
    public String getCreatedBy() {
        return CreatedBy;
    }

    @XmlElement
    public String getLastModified() {
        return LastModified;
    }

    public Content getContent() {
        return Content;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public void setLastModified(String lastModified) {
        LastModified = lastModified;
    }

    public void setTestFolderPath(String testFolderPath) {
        TestFolderPath = testFolderPath;
    }

    public void setContent(Content content) {
        Content = content;
    }


    @Override
    public String toString(){
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

    public static TestResponse xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Test" , TestResponse.class);
        xstream.setClassLoader(TestResponse.class.getClassLoader());
        return (TestResponse)xstream.fromXML(xml);
    }

}

