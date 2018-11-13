package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.SimplifiedContent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedTest {

//    @XmlElement
//    @JsonProperty
    private String name;

//    @XmlElement
//    @JsonProperty
    private String testfolderpath;

//    @XmlElement
//    @JsonProperty
    private SimplifiedContent content;

    public SimplifiedTest() {}

    public SimplifiedTest(String name, String testfolderpath, SimplifiedContent content) {
        this.name = name;
        this.testfolderpath = testfolderpath;
        this.content = content;
    }


    @Override
    public String toString() {
        return "SimplifiedTest {" +
                "name = " + name +
                ", " + "testfolderpath = " + testfolderpath +
                ", " + "content = " + content +
                "}";
    }

}
