package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.lgdistribution;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.LGDistributionTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.*;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="LGDistribution")
public class LGDistribution
{

    /*
    Required value. One of:
    all to each group
    manual */
    @XmlElement
    private String Type;

    @XmlElement
    private String Amount;

    public LGDistribution() {}

    public LGDistribution(String type) {
        setType(type);
        setAmount(-1);
    }

    public LGDistribution(LGDistributionTypeValues type) {
        setType(type);
        setAmount(-1);
    }

    public LGDistribution(String type, int amount) {
        setType(type);
        setAmount(amount);
    }

    public LGDistribution(LGDistributionTypeValues type, int amount) {
        setType(type);
        setAmount(amount);
    }

    public void setAmount(int amount) {
        this.Amount = Common.integerToString(amount);
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(LGDistributionTypeValues type) {
        this.Type = type.value();
    }


    @Override
    public String toString() {
        return "LGDistribution{" + "Type = " + Type +
                ", Amount = " + Amount + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("LGDistribution", LGDistribution.class);
        xstream.aliasField("Type", LGDistribution.class, "Type");
        xstream.aliasField("Amount", LGDistribution.class, "Amount");
        xstream.aliasField("LGDistribution", LGDistribution.class, "LGDistribution");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static LGDistribution xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("LGDistribution" , LGDistribution.class);
        xstream.setClassLoader(LGDistribution.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (LGDistribution)xstream.fromXML(xml);
    }



}