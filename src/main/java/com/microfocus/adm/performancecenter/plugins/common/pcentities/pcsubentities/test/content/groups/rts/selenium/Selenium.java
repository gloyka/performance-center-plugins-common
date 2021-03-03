package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.selenium;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Selenium")
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

    public static Selenium xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Selenium" , Selenium.class);
        xstream.setClassLoader(Selenium.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Selenium)xstream.fromXML(xml);
    }

    public void setJREPath(String jrePath) {
        this.JREPath = jrePath;
    }

    public String getJREPath() {
        return this.JREPath;
    }

    public void setClassPath(String classPath) {
        this.ClassPath = classPath;
    }

    public String getClassPath() {
        return this.ClassPath;
    }

    public void setTestNgFiles(String testNgFiles) {
        this.TestNgFiles = testNgFiles;
    }

    public String getTestNgFiles() {
        return this.TestNgFiles;
    }
}
