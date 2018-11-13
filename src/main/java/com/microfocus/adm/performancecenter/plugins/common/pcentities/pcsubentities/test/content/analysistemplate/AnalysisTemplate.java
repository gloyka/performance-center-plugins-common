package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.analysistemplate;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.Content;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AnalysisTemplate")
public class AnalysisTemplate {

    @XmlElement
    private String ID;

    public AnalysisTemplate() { }

    public AnalysisTemplate(int ID) {
        setID(ID);
    }

    public void setID(int id) {
            this.ID = Common.integerToString(id);
    }

    @Override
    public String toString() {
        return "AnalysisTemplate{" + "ID = " + ID + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("AnalysisTemplate", AnalysisTemplate.class);
        xstream.aliasField("ID", AnalysisTemplate.class, "ID");
        xstream.aliasField("AnalysisTemplate", AnalysisTemplate.class, "AnalysisTemplate");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static AnalysisTemplate xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("AnalysisTemplate" , AnalysisTemplate.class);
        xstream.setClassLoader(AnalysisTemplate.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (AnalysisTemplate)xstream.fromXML(xml);
    }

}
