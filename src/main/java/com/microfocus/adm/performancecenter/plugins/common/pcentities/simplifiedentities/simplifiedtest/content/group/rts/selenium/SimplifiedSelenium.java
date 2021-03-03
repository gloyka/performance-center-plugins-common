package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.selenium;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import javax.xml.bind.annotation.XmlElement;

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

    public static SimplifiedSelenium xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedSelenium", SimplifiedSelenium.class);

        xstream.setClassLoader(SimplifiedSelenium.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedSelenium) xstream.fromXML(xml);
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