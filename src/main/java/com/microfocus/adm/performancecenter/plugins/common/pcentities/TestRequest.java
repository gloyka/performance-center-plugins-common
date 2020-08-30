package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;



import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Test")
public class TestRequest
{

    private String xmlns = PcRestProxy.PC_API_XMLNS;

    private String Name;

    private String TestFolderPath;

    private Content Content;

    public TestRequest(){}


    public TestRequest(String name, String testFolderPath, Content content){
        this.Name = name;
        this.TestFolderPath = testFolderPath;
        this.Content = content;
    }

    @XmlAttribute
    public String getXmlns() {
        return xmlns;
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
    public Content getContent() {
        return Content;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setTestFolderPath(String testFolderPath) {
        TestFolderPath = testFolderPath;
    }

    public void setContent(Content content) {
        Content = content;
    }


    @Override
    public String toString(){
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

    public static TestRequest xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Test" , TestRequest.class);
        xstream.setClassLoader(TestRequest.class.getClassLoader());
        return (TestRequest)xstream.fromXML(xml);
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
}