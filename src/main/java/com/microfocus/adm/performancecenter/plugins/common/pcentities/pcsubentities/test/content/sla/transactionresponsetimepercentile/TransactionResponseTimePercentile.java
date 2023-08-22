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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimepercentile;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TransactionResponseTimePercentile")
public class TransactionResponseTimePercentile {

    @XmlElement
    private ArrayList<Transaction> Transactions;

    @XmlElement
    private String Percentile;

    public TransactionResponseTimePercentile() {
    }

    public TransactionResponseTimePercentile(ArrayList<Transaction> transactions, int percentile) {
        setTransactions(transactions);
        setPercentile(percentile);
    }

    public static TransactionResponseTimePercentile xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TransactionResponseTimePercentile", TransactionResponseTimePercentile.class);

        xstream.alias("Transaction", com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction.class, com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.alias("Between", Between.class, Between.class);

        xstream.setClassLoader(TransactionResponseTimePercentile.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TransactionResponseTimePercentile) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "TransactionResponseTimePercentile{" + "Transactions = " + Transactions +
                ", Percentile = " + Percentile + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TransactionResponseTimePercentile", TransactionResponseTimePercentile.class);
        xstream.aliasField("Transactions", TransactionResponseTimePercentile.class, "Transactions");
        xstream.aliasField("Percentile", TransactionResponseTimePercentile.class, "Percentile");

        xstream.alias("Transaction", com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction.class, com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.alias("Between", Between.class, Between.class);

        xstream.aliasField("TransactionResponseTimePercentile", TransactionResponseTimePercentile.class, "TransactionResponseTimePercentile");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public ArrayList<Transaction> getTransactions() {
        return Transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        Transactions = transactions;
    }

    public String getPercentile() {
        return Percentile;
    }

    public void setPercentile(int value) {
        this.Percentile = Common.integerToString(value);
    }

    public void setPercentile(String percentile) {
        Percentile = percentile;
    }
}