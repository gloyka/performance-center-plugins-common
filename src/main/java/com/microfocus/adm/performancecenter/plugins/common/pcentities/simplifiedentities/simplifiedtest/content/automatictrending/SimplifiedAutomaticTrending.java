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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.automatictrending;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

public class SimplifiedAutomaticTrending {
    private int report_id;
    private int max_runs_in_report;

    public SimplifiedAutomaticTrending() {
    }

    public SimplifiedAutomaticTrending(int report_id, int max_runs_in_report) {
        this.report_id = report_id;
        this.max_runs_in_report = max_runs_in_report;
    }

    public static SimplifiedAutomaticTrending xmlToObject(String xml) {
        XStream xstream = Helper.xstreamPermissions(new XStream());
        xstream.alias("SimplifiedAutomaticTrending", SimplifiedAutomaticTrending.class);
        xstream.setClassLoader(SimplifiedAutomaticTrending.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedAutomaticTrending) xstream.fromXML(xml);
    }

    public String objectToXML() {
        XStream xstream = Helper.xstreamPermissions(new XStream());
        xstream.alias("SimplifiedAutomaticTrending", SimplifiedAutomaticTrending.class);
        xstream.aliasField("report_id", SimplifiedAutomaticTrending.class, "report_id");
        xstream.aliasField("max_runs_in_report", SimplifiedAutomaticTrending.class, "max_runs_in_report");
        xstream.aliasField("SimplifiedAutomaticTrending", SimplifiedAutomaticTrending.class, "SimplifiedAutomaticTrending");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    @Override
    public String toString() {
        return "SimplifiedAutomaticTrending {" +
                "report_id = " + report_id +
                ", " + "max_runs_in_report = " + max_runs_in_report +
                "}";
    }

    public int getReport_id() {
        return this.report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public int getMax_runs_in_report() {
        return this.max_runs_in_report;
    }

    public void setMax_runs_in_report(int max_runs_in_report) {
        this.max_runs_in_report = max_runs_in_report;
    }
}
