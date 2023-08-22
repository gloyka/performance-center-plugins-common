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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.Thresholds;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Transaction")
public class Transaction {
    @XmlElement
    private String Name;
    @XmlElement
    private Thresholds Thresholds;
    @XmlElement
    private String Threshold;

    public Transaction() {
    }

    public Transaction(String name, Thresholds thresholds) {
        setName(name);
        setThresholds(thresholds);
        setThreshold(-1);
    }

    public Transaction(String name, int threshold) {
        setName(name);
        setThresholds(null);
        setThreshold(threshold);
    }

    public static Transaction xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Transaction", Transaction.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.setClassLoader(Transaction.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Transaction) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "Transaction{" + "Name = " + Name +
                ", Thresholds = " + Thresholds +
                ", Threshold = " + Threshold + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Transaction", Transaction.class);
        xstream.aliasField("Name", Transaction.class, "Name");
        xstream.aliasField("Thresholds", Transaction.class, "Thresholds");
        xstream.aliasField("Threshold", Transaction.class, "Threshold");
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.aliasField("Transaction", Transaction.class, "Transaction");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Thresholds getThresholds() {
        return Thresholds;
    }

    public void setThresholds(Thresholds thresholds) {
        Thresholds = thresholds;
    }

    public String getThreshold() {
        return Threshold;
    }

    public void setThreshold(int threshold) {
        this.Threshold = Common.integerToString(threshold);
    }

    public void setThreshold(String threshold) {
        Threshold = threshold;
    }
}

