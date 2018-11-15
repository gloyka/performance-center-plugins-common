package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
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
@XmlRootElement(name="JavaVM")
public class JavaVM {


    @XmlElement
    private JavaEnvClassPaths JavaEnvClassPaths;

    @XmlElement
    private boolean UserSpecifiedJdk;

    @XmlElement
    private String JdkHome;

    @XmlElement
    private String JavaVmParameters;

    @XmlElement
    private boolean UseXboot;

    @XmlElement
    private boolean EnableClassLoaderPerVuser;

    public JavaVM() {}

    public JavaVM(JavaEnvClassPaths javaEnvClassPaths, boolean userSpecifiedJdk, String jdkHome, String javaVmParameters, boolean useXboot, boolean enableClassLoaderPerVuser) {
        setJavaEnvClassPaths(javaEnvClassPaths);
        setUserSpecifiedJdk(userSpecifiedJdk);
        setJdkHome(JdkHome);
        setJavaVmParameters(javaVmParameters);
        setUseXboot(useXboot);
        setEnableClassLoaderPerVuser(enableClassLoaderPerVuser);
    }


    @Override
    public String toString() {
        return "JavaVM{" + "JavaEnvClassPaths = " + JavaEnvClassPaths +
                ", UserSpecifiedJdk = " + UserSpecifiedJdk +
                ", JdkHome = " + JdkHome +
                ", JavaVmParameters = " + JavaVmParameters +
                ", UseXboot = " + UseXboot +
                ", EnableClassLoaderPerVuser = " + EnableClassLoaderPerVuser + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JavaVM", JavaVM.class);
        xstream.aliasField("JavaEnvClassPaths", JavaVM.class, "JavaEnvClassPaths");
        xstream.aliasField("UserSpecifiedJdk", JavaVM.class, "UserSpecifiedJdk");
        xstream.aliasField("JMeterUseDefaultPort", JavaVM.class, "JMeterUseDefaultPort");
        xstream.aliasField("JMeterMinPort", JavaVM.class, "JMeterMinPort");
        xstream.aliasField("JMeterMaxPort", JavaVM.class, "JMeterMaxPort");
        xstream.aliasField("JavaVM", JavaVM.class, "JavaVM");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static JavaVM xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JavaVM" , JavaVM.class);
        xstream.setClassLoader(JavaVM.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (JavaVM)xstream.fromXML(xml);
    }

}
