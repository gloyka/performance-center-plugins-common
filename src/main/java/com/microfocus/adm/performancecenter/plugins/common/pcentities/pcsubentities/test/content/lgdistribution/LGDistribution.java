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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.lgdistribution;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.LGDistributionTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LGDistribution")
public class LGDistribution {

    /*
    Required value. One of:
    all to each group
    manual */
    @XmlElement
    private String Type;

    @XmlElement
    private String Amount;

    public LGDistribution() {
    }

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

    public static LGDistribution xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("LGDistribution", LGDistribution.class);
        xstream.setClassLoader(LGDistribution.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (LGDistribution) xstream.fromXML(xml);
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setType(LGDistributionTypeValues type) {
        this.Type = type.value();
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        this.Amount = Common.integerToString(amount);
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}