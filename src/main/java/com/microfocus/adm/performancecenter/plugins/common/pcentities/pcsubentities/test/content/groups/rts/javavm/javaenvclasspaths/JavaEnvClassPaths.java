package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="JavaEnvClassPaths")
public class JavaEnvClassPaths {

    @XmlAttribute
    private String JavaEnvClassPath;


    public JavaEnvClassPaths() { }

    public JavaEnvClassPaths(String javaEnvClassPath) {
        setJavaEnvClassPath(javaEnvClassPath);
    }


    @Override
    public String toString() {
        return "JavaEnvClassPaths{" + "JavaEnvClassPath = " + JavaEnvClassPath +
                 "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JavaEnvClassPaths", JavaEnvClassPaths.class);
        xstream.aliasField("JavaEnvClassPath", JavaEnvClassPaths.class, "JavaEnvClassPath");
        xstream.aliasField("JavaEnvClassPaths", JavaEnvClassPaths.class, "JavaEnvClassPaths");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static JavaEnvClassPaths xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JavaEnvClassPaths" , JavaEnvClassPaths.class);
        xstream.setClassLoader(JavaEnvClassPaths.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (JavaEnvClassPaths)xstream.fromXML(xml);
    }

}
