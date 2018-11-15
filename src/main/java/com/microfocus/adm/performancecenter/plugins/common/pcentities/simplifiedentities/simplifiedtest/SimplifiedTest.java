package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.SimplifiedContent;
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

}
