package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.SimplifiedContent;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedTest {

//    @XmlElement
//    @JsonProperty
    private String test_name;

//    @XmlElement
//    @JsonProperty
    private String test_folder_path;

//    @XmlElement
//    @JsonProperty
    private SimplifiedContent test_content;

    public SimplifiedTest() {}

    public SimplifiedTest(String test_name, String test_folder_path, SimplifiedContent test_content) {
        this.test_name = test_name;
        this.test_folder_path = test_folder_path;
        this.test_content = test_content;
    }


    @Override
    public String toString() {
        return "SimplifiedTest {" +
                "test_name = " + test_name +
                ", " + "test_folder_path = " + test_folder_path +
                ", " + "test_content = " + test_content +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Test", SimplifiedTest.class);
        xstream.aliasField("test_name", SimplifiedTest.class, "test_name");
        xstream.aliasField("test_folder_path", SimplifiedTest.class, "test_folder_path");
        xstream.aliasField("test_content", SimplifiedTest.class, "test_content");


        xstream.alias("group", SimplifiedGroup.class);
        xstream.addImplicitCollection(SimplifiedContent.class, "group", "group", SimplifiedGroup.class);

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.aliasField("Test", SimplifiedTest.class, "SimplifiedTest");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static SimplifiedTest xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Test" , SimplifiedTest.class);

        xstream.alias("group", SimplifiedGroup.class);
        xstream.addImplicitCollection(SimplifiedContent.class, "group", "group", SimplifiedGroup.class);

        xstream.aliasField("scheduler", SimplifiedContent.class, "scheduler");

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.setClassLoader(SimplifiedTest.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedTest)xstream.fromXML(xml);
    }
}