package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.elasticconfiguration;


import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedElasticConfiguration {

    private int image_id;

    private int memory_limit;

    private int cpu_limit;

    public SimplifiedElasticConfiguration() {}

    public SimplifiedElasticConfiguration(int image_id, int memory_limit, int cpu_limit) {
        this.image_id = image_id;
        this.memory_limit = memory_limit;
        this.cpu_limit = cpu_limit;
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

    public static SimplifiedElasticConfiguration xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedElasticConfiguration" , SimplifiedElasticConfiguration.class);
        xstream.setClassLoader(SimplifiedElasticConfiguration.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedElasticConfiguration)xstream.fromXML(xml);
    }

}
