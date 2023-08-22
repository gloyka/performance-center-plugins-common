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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagehitspersecond.AverageHitsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.averagethroughput.AverageThroughput;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.Thresholds.betweenthreshold.BetweenThreshold;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.loadvalues.betweens.Between;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.common.transactions.Transaction;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.errorspersecond.ErrorsPerSecond;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalhits.TotalHits;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.totalthroughput.TotalThroughput;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimeaverage.TransactionResponseTimeAverage;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.sla.transactionresponsetimepercentile.TransactionResponseTimePercentile;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SLA")
public class SLA {

    @XmlElement
    private AverageThroughput AverageThroughput;

    @XmlElement
    private TransactionResponseTimeAverage TransactionResponseTimeAverage;

    @XmlElement
    private TransactionResponseTimePercentile TransactionResponseTimePercentile;

    @XmlElement
    private AverageHitsPerSecond AverageHitsPerSecond;

    @XmlElement
    private TotalThroughput TotalThroughput;

    @XmlElement
    private ErrorsPerSecond ErrorsPerSecond;

    @XmlElement
    private TotalHits TotalHits;

    public SLA() {
    }

    public SLA(AverageThroughput averageThroughput, TransactionResponseTimeAverage transactionResponseTimeAverage, TransactionResponseTimePercentile transactionResponseTimePercentile, AverageHitsPerSecond averageHitsPerSecond, TotalThroughput totalThroughput, ErrorsPerSecond errorsPerSecond, TotalHits totalHits) {
        setAverageThroughput(averageThroughput);
        setTransactionResponseTimeAverage(transactionResponseTimeAverage);
        setTransactionResponseTimePercentile(transactionResponseTimePercentile);
        setAverageHitsPerSecond(averageHitsPerSecond);
        setTotalThroughput(totalThroughput);
        setErrorsPerSecond(errorsPerSecond);
        setTotalHits(totalHits);
    }

    public static SLA xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SLA", SLA.class);

        xstream.alias("Transaction", Transaction.class, Transaction.class);
        xstream.alias("Between", Between.class, Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.setClassLoader(SLA.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SLA) xstream.fromXML(xml);
    }

    @Override
    public String toString() {
        return "SLA{" + "AverageThroughput = " + AverageThroughput +
                ", TransactionResponseTimeAverage = " + TransactionResponseTimeAverage +
                ", AverageHitsPerSecond = " + AverageHitsPerSecond +
                ", TotalThroughput = " + TotalThroughput +
                ", ErrorsPerSecond = " + ErrorsPerSecond +
                ", TotalHits = " + TotalHits + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SLA", SLA.class);
        xstream.aliasField("AverageThroughput", SLA.class, "AverageThroughput");
        xstream.aliasField("TransactionResponseTimeAverage", SLA.class, "TransactionResponseTimeAverage");
        xstream.aliasField("TransactionResponseTimePercentile", SLA.class, "TransactionResponseTimePercentile");
        xstream.aliasField("AverageHitsPerSecond", SLA.class, "AverageHitsPerSecond");
        xstream.aliasField("TotalThroughput", SLA.class, "TotalThroughput");
        xstream.aliasField("ErrorsPerSecond", SLA.class, "ErrorsPerSecond");
        xstream.aliasField("TotalHits", SLA.class, "TotalHits");

        xstream.alias("Transaction", Transaction.class, Transaction.class);
        xstream.alias("Between", Between.class, Between.class);
        xstream.alias("Threshold", String.class);
        xstream.addImplicitCollection(BetweenThreshold.class, "Threshold", "Threshold", String.class);

        xstream.aliasField("SLA", SLA.class, "SLA");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public AverageThroughput getAverageThroughput() {
        return AverageThroughput;
    }

    public void setAverageThroughput(AverageThroughput averageThroughput) {
        AverageThroughput = averageThroughput;
    }

    public TransactionResponseTimeAverage getTransactionResponseTimeAverage() {
        return TransactionResponseTimeAverage;
    }

    public void setTransactionResponseTimeAverage(TransactionResponseTimeAverage transactionResponseTimeAverage) {
        TransactionResponseTimeAverage = transactionResponseTimeAverage;
    }

    public TransactionResponseTimePercentile getTransactionResponseTimePercentile() {
        return TransactionResponseTimePercentile;
    }

    public void setTransactionResponseTimePercentile(TransactionResponseTimePercentile transactionResponseTimePercentile) {
        TransactionResponseTimePercentile = transactionResponseTimePercentile;
    }

    public AverageHitsPerSecond getAverageHitsPerSecond() {
        return AverageHitsPerSecond;
    }

    public void setAverageHitsPerSecond(AverageHitsPerSecond averageHitsPerSecond) {
        AverageHitsPerSecond = averageHitsPerSecond;
    }

    public TotalThroughput getTotalThroughput() {
        return TotalThroughput;
    }

    public void setTotalThroughput(TotalThroughput totalThroughput) {
        TotalThroughput = totalThroughput;
    }

    public ErrorsPerSecond getErrorsPerSecond() {
        return ErrorsPerSecond;
    }

    public void setErrorsPerSecond(ErrorsPerSecond errorsPerSecond) {
        ErrorsPerSecond = errorsPerSecond;
    }

    public TotalHits getTotalHits() {
        return TotalHits;
    }

    public void setTotalHits(TotalHits totalHits) {
        TotalHits = totalHits;
    }
}