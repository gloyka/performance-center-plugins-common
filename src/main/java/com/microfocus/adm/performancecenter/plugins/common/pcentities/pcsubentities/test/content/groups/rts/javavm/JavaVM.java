/**
 * Copyright © 2023 Open Text Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "JavaVM")
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

    public JavaVM() {
    }

    public JavaVM(JavaEnvClassPaths javaEnvClassPaths, boolean userSpecifiedJdk, String jdkHome, String javaVmParameters, boolean useXboot, boolean enableClassLoaderPerVuser) {
        this.setJavaEnvClassPaths(javaEnvClassPaths);
        setUserSpecifiedJdk(userSpecifiedJdk);
        setJdkHome(jdkHome);
        setJavaVmParameters(javaVmParameters);
        setUseXboot(useXboot);
        setEnableClassLoaderPerVuser(enableClassLoaderPerVuser);
    }

    public static JavaVM xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("JavaVM", JavaVM.class);

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.setClassLoader(JavaVM.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (JavaVM) xstream.fromXML(xml);
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

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.aliasField("UserSpecifiedJdk", JavaVM.class, "UserSpecifiedJdk");
        xstream.aliasField("JMeterUseDefaultPort", JavaVM.class, "JMeterUseDefaultPort");
        xstream.aliasField("JMeterMinPort", JavaVM.class, "JMeterMinPort");
        xstream.aliasField("JMeterMaxPort", JavaVM.class, "JMeterMaxPort");
        xstream.aliasField("JavaVM", JavaVM.class, "JavaVM");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public JavaEnvClassPaths getJavaEnvClassPaths() {
        return JavaEnvClassPaths;
    }

    public void setJavaEnvClassPaths(JavaEnvClassPaths javaEnvClassPaths) {
        JavaEnvClassPaths = javaEnvClassPaths;
    }

    public boolean isUserSpecifiedJdk() {
        return UserSpecifiedJdk;
    }

    public void setUserSpecifiedJdk(boolean userSpecifiedJdk) {
        UserSpecifiedJdk = userSpecifiedJdk;
    }

    public String getJdkHome() {
        return JdkHome;
    }

    public void setJdkHome(String jdkHome) {
        JdkHome = jdkHome;
    }

    public String getJavaVmParameters() {
        return JavaVmParameters;
    }

    public void setJavaVmParameters(String javaVmParameters) {
        JavaVmParameters = javaVmParameters;
    }

    public boolean isUseXboot() {
        return UseXboot;
    }

    public void setUseXboot(boolean useXboot) {
        UseXboot = useXboot;
    }

    public boolean isEnableClassLoaderPerVuser() {
        return EnableClassLoaderPerVuser;
    }

    public void setEnableClassLoaderPerVuser(boolean enableClassLoaderPerVuser) {
        EnableClassLoaderPerVuser = enableClassLoaderPerVuser;
    }
}
