package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimepercentile;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.LoadValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimeaverage.TransactionResponseTimeAverage;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TransactionResponseTimePercentile")
public class TransactionResponseTimePercentile
{

    @XmlElement
    private ArrayList<Transaction> Transactions;

    @XmlElement
    private String Percentile;

    public TransactionResponseTimePercentile() { }

    public TransactionResponseTimePercentile(ArrayList<Transaction> transactions, int percentile) {
        setTransactions(transactions);
        setPercentile(percentile);
    }

    public void setPercentile(int value) {
        this.Percentile = Common.integerToString(value);
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
        xstream.alias("Between", Between.class,Between.class);

        xstream.aliasField("TransactionResponseTimePercentile", TransactionResponseTimePercentile.class, "TransactionResponseTimePercentile");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static TransactionResponseTimePercentile xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TransactionResponseTimePercentile" , TransactionResponseTimePercentile.class);

        xstream.alias("Transaction", com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction.class, com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);
        xstream.alias("Between", Between.class,Between.class);

        xstream.setClassLoader(TransactionResponseTimePercentile.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (TransactionResponseTimePercentile)xstream.fromXML(xml);
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

    public void setPercentile(String percentile) {
        Percentile = percentile;
    }
}