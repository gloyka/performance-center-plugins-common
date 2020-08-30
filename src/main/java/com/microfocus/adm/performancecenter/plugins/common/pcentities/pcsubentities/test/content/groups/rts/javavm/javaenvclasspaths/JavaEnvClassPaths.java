package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="JavaEnvClassPaths")
public class JavaEnvClassPaths {

    @XmlElement
    private ArrayList<String> JavaEnvClassPath;

    public JavaEnvClassPaths() { }

    public JavaEnvClassPaths(ArrayList<String> javaEnvClassPath) {
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

        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.aliasField("JavaEnvClassPaths", JavaEnvClassPaths.class, "JavaEnvClassPaths");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static JavaEnvClassPaths xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JavaEnvClassPaths", JavaEnvClassPaths.class);

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.setClassLoader(JavaEnvClassPaths.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (JavaEnvClassPaths)xstream.fromXML(xml);
    }

    public ArrayList<String> getJavaEnvClassPath() {
        return JavaEnvClassPath;
    }

    public void setJavaEnvClassPath(ArrayList<String> javaEnvClassPath) {
        JavaEnvClassPath = javaEnvClassPath;
    }
}
