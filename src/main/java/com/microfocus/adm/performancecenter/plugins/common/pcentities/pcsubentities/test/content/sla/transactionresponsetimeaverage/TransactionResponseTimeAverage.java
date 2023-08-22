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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimeaverage;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.LoadValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.LoadCriterionValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TransactionResponseTimeAverage")
public class TransactionResponseTimeAverage {
    @XmlElement
    private String LoadCriterion;
    @XmlElement
    private LoadValues LoadValues;
    @XmlElement
    private ArrayList<Transaction> Transactions;

    public TransactionResponseTimeAverage() {
    }

    public TransactionResponseTimeAverage(String loadCriterion, LoadValues loadValues, ArrayList<Transaction> transactions) {
        setLoadCriterion(loadCriterion);
        setLoadValues(loadValues);
        setTransactions(transactions);
    }

    public TransactionResponseTimeAverage(LoadCriterionValues loadCriterion, LoadValues loadValues, ArrayList<Transaction> transactions) {
        setLoadCriterion(loadCriterion);
        setLoadValues(loadValues);
        setTransactions(transactions);
    }

    public static TransactionResponseTimeAverage xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TransactionResponseTimeAverage", TransactionResponseTimeAverage.class);
        xstream.alias("Transaction", Transaction.class, Transaction.class);
        xstream.alias("Between", Between.class, Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.setClassLoader(TransactionResponseTimeAverage.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TransactionResponseTimeAverage) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "TransactionResponseTimeAverage{" + "loadvalues = " + LoadCriterion +
                ", LoadValues = " + LoadValues +
                ", Transactions = " + Transactions + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TransactionResponseTimeAverage", TransactionResponseTimeAverage.class);
        xstream.aliasField("LoadCriterion", TransactionResponseTimeAverage.class, "LoadCriterion");
        xstream.aliasField("LoadValues", TransactionResponseTimeAverage.class, "LoadValues");
        xstream.aliasField("Transactions", TransactionResponseTimeAverage.class, "Transactions");
        xstream.alias("Transaction", Transaction.class, Transaction.class);
        xstream.alias("Between", Between.class, Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.aliasField("TransactionResponseTimeAverage", TransactionResponseTimeAverage.class, "TransactionResponseTimeAverage");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public String getLoadCriterion() {
        return LoadCriterion;
    }

    public void setLoadCriterion(String loadCriterion) {
        this.LoadCriterion = loadCriterion;
    }

    public void setLoadCriterion(LoadCriterionValues loadCriterion) {
        this.LoadCriterion = loadCriterion.value();
    }

    public LoadValues getLoadValues() {
        return LoadValues;
    }

    public void setLoadValues(LoadValues loadValues) {
        LoadValues = loadValues;
    }

    public ArrayList<Transaction> getTransactions() {
        return Transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        Transactions = transactions;
    }
}
