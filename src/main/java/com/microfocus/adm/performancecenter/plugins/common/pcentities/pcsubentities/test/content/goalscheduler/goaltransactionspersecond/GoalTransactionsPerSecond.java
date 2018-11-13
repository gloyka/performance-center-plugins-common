package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goaltransactionspersecond;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="GoalTransactionsPerSecond")
public class GoalTransactionsPerSecond {

    @XmlElement
    private String TargetTransactionsPerSecond;

    @XmlElement
    private String TransactionName;

    @XmlElement
    private String MinVusers;

    @XmlElement
    private String MaxVusers;

    public GoalTransactionsPerSecond() {}

    public GoalTransactionsPerSecond(String targetTransactionsPerSecond, String transactionName, int minVusers, int maxVusers) {
        setTargetTransactionsPerSecond(targetTransactionsPerSecond);
        setTransactionName(transactionName);
        setMinVusers(minVusers);
        setMaxVusers(maxVusers);
    }

    public void setMinVusers(int minVusers) {
            this.MinVusers = Common.integerToString(minVusers);
    }

    public void setMaxVusers(int maxVusers) {
            this.MaxVusers = Common.integerToString(maxVusers);
    }

    @Override
    public String toString() {
        return "GoalTransactionsPerSecond{" + "TargetTransactionsPerSecond = " + TargetTransactionsPerSecond +
                ", TransactionName = " + TransactionName +
                ", MinVusers = " + MinVusers +
                ", MaxVusers = " + MaxVusers +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("GoalTransactionsPerSecond", GoalTransactionsPerSecond.class);
        xstream.aliasField("TargetTransactionsPerSecond", GoalTransactionsPerSecond.class, "TargetTransactionsPerSecond");
        xstream.aliasField("MinVusers", GoalTransactionsPerSecond.class, "MinVusers");
        xstream.aliasField("MaxVusers", GoalTransactionsPerSecond.class, "MaxVusers");
        xstream.aliasField("GoalTransactionsPerSecond", GoalTransactionsPerSecond.class, "GoalTransactionsPerSecond");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static GoalTransactionsPerSecond xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GoalTransactionsPerSecond" , GoalTransactionsPerSecond.class);
        xstream.setClassLoader(GoalTransactionsPerSecond.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GoalTransactionsPerSecond)xstream.fromXML(xml);
    }
}
