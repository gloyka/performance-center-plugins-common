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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.elasticconfiguration;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

public class SimplifiedElasticConfiguration {

    private int image_id;

    private int memory_limit;

    private int cpu_limit;

    public SimplifiedElasticConfiguration() {
    }

    public SimplifiedElasticConfiguration(int image_id, int memory_limit, int cpu_limit) {
        this.image_id = image_id;
        this.memory_limit = memory_limit;
        this.cpu_limit = cpu_limit;
    }

    public static SimplifiedElasticConfiguration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedElasticConfiguration", SimplifiedElasticConfiguration.class);
        xstream.setClassLoader(SimplifiedElasticConfiguration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedElasticConfiguration) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "SimplifiedElasticConfiguration {" +
                "image_id = " + image_id + ", " +
                "memory_limit = " + memory_limit + ", " +
                "cpu_limit = " + cpu_limit + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedElasticConfiguration", SimplifiedElasticConfiguration.class);
        xstream.aliasField("image_id", SimplifiedElasticConfiguration.class, "image_id");
        xstream.aliasField("memory_limit", SimplifiedElasticConfiguration.class, "memory_limit");
        xstream.aliasField("cpu_limit", SimplifiedElasticConfiguration.class, "cpu_limit");
        xstream.aliasField("SimplifiedElasticConfiguration", SimplifiedElasticConfiguration.class, "SimplifiedElasticConfiguration");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getMemory_limit() {
        return memory_limit;
    }

    public void setMemory_limit(int memory_limit) {
        this.memory_limit = memory_limit;
    }

    public int getCpu_limit() {
        return cpu_limit;
    }

    public void setCpu_limit(int cpu_limit) {
        this.cpu_limit = cpu_limit;
    }
}
