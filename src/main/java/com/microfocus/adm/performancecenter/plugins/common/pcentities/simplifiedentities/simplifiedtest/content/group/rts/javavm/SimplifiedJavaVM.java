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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.javavm;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class SimplifiedJavaVM {

    private String jdk_home;

    private String java_vm_parameters;

    private boolean use_xboot;

    private boolean enable_classloader_per_vuser;

    private String[] java_env_class_paths;

    public SimplifiedJavaVM() {
    }

    public SimplifiedJavaVM(String jdk_home, String java_vm_parameters, boolean use_xboot, boolean enable_classloader_per_vuser, String[] java_env_class_paths) {
        this.jdk_home = jdk_home;
        this.java_vm_parameters = java_vm_parameters;
        this.use_xboot = use_xboot;
        this.enable_classloader_per_vuser = enable_classloader_per_vuser;
        this.java_env_class_paths = java_env_class_paths;
    }

    public static SimplifiedJavaVM xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedJavaVM", SimplifiedJavaVM.class);

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.setClassLoader(SimplifiedJavaVM.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedJavaVM) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "SimplifiedJavaVM {" +
                "jdk_home = " + jdk_home +
                ", " + "java_vm_parameters = " + java_vm_parameters +
                ", " + "use_xboot = " + use_xboot +
                ", " + "enable_classloader_per_vuser = " + enable_classloader_per_vuser +
                ", " + "java_env_class_paths = " + java_env_class_paths +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedJavaVM", SimplifiedJavaVM.class);
        xstream.aliasField("jdk_home", SimplifiedJavaVM.class, "jdk_home");
        xstream.aliasField("java_vm_parameters", SimplifiedJavaVM.class, "java_vm_parameters");
        xstream.aliasField("use_xboot", SimplifiedJavaVM.class, "use_xboot");
        xstream.aliasField("enable_classloader_per_vuser", SimplifiedJavaVM.class, "enable_classloader_per_vuser");

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.aliasField("SimplifiedJavaVM", SimplifiedJavaVM.class, "SimplifiedJavaVM");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getJdk_home() {
        return jdk_home;
    }

    public void setJdk_home(String jdk_home) {
        this.jdk_home = jdk_home;
    }

    public String getJava_vm_parameters() {
        return java_vm_parameters;
    }

    public void setJava_vm_parameters(String java_vm_parameters) {
        this.java_vm_parameters = java_vm_parameters;
    }

    public boolean isUse_xboot() {
        return use_xboot;
    }

    public void setUse_xboot(boolean use_xboot) {
        this.use_xboot = use_xboot;
    }

    public boolean isEnable_classloader_per_vuser() {
        return enable_classloader_per_vuser;
    }

    public void setEnable_classloader_per_vuser(boolean enable_classloader_per_vuser) {
        this.enable_classloader_per_vuser = enable_classloader_per_vuser;
    }

    public String[] getJava_env_class_paths() {
        return java_env_class_paths;
    }

    public void setJava_env_class_paths(String[] java_env_class_paths) {
        this.java_env_class_paths = java_env_class_paths;
    }
}
