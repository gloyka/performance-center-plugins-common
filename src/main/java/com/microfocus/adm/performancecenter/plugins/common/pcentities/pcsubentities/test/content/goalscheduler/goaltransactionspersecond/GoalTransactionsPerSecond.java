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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.goalscheduler.goaltransactionspersecond;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GoalTransactionsPerSecond")
public class GoalTransactionsPerSecond {

    @XmlElement
    private String TargetTransactionsPerSecond;

    @XmlElement
    private String TransactionName;

    @XmlElement
    private String MinVusers;

    @XmlElement
    private String MaxVusers;

    public GoalTransactionsPerSecond() {
    }

    public GoalTransactionsPerSecond(String targetTransactionsPerSecond, String transactionName, int minVusers, int maxVusers) {
        setTargetTransactionsPerSecond(targetTransactionsPerSecond);
        setTransactionName(transactionName);
        setMinVusers(minVusers);
        setMaxVusers(maxVusers);
    }

    public static GoalTransactionsPerSecond xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GoalTransactionsPerSecond", GoalTransactionsPerSecond.class);
        xstream.setClassLoader(GoalTransactionsPerSecond.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GoalTransactionsPerSecond) xstream.fromXML(xml);
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

    public String getTargetTransactionsPerSecond() {
        return TargetTransactionsPerSecond;
    }

    public void setTargetTransactionsPerSecond(String targetTransactionsPerSecond) {
        TargetTransactionsPerSecond = targetTransactionsPerSecond;
    }

    public String getTransactionName() {
        return TransactionName;
    }

    public void setTransactionName(String transactionName) {
        TransactionName = transactionName;
    }

    public String getMinVusers() {
        return MinVusers;
    }

    public void setMinVusers(int minVusers) {
        this.MinVusers = Common.integerToString(minVusers);
    }

    public void setMinVusers(String minVusers) {
        MinVusers = minVusers;
    }

    public String getMaxVusers() {
        return MaxVusers;
    }

    public void setMaxVusers(int maxVusers) {
        this.MaxVusers = Common.integerToString(maxVusers);
    }

    public void setMaxVusers(String maxVusers) {
        MaxVusers = maxVusers;
    }
}
