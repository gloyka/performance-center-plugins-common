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
package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

/**
 * Holds Trending Regular data
 */
public class TrendReportRegularDataRow {
    private String PCT_TYPE;
    private String PCT_NAME;
    private String PCT_MINIMUM;
    private String PCT_MAXIMUM;
    private String PCT_AVERAGE;
    private String PCT_MEDIAN;
    private String PCT_STDDEVIATION;
    private String PCT_SUM1;

    public static TrendReportRegularDataRow xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("RegularDataRow", TrendReportRegularDataRow.class);
        return (TrendReportRegularDataRow) xstream.fromXML(xml);
    }

    public String getPCT_TYPE() {
        return PCT_TYPE;
    }

    public void setPCT_TYPE(String PCT_TYPE) {
        this.PCT_TYPE = PCT_TYPE;
    }

    public String getPCT_NAME() {
        return PCT_NAME;
    }

    public void setPCT_NAME(String PCT_NAME) {
        this.PCT_NAME = PCT_NAME;
    }

    public String getPCT_MINIMUM() {
        return PCT_MINIMUM;
    }

    public void setPCT_MINIMUM(String PCT_MINIMUM) {
        this.PCT_MINIMUM = PCT_MINIMUM;
    }

    public String getPCT_MAXIMUM() {
        return PCT_MAXIMUM;
    }

    public void setPCT_MAXIMUM(String PCT_MAXIMUM) {
        this.PCT_MAXIMUM = PCT_MAXIMUM;
    }

    public String getPCT_AVERAGE() {
        return PCT_AVERAGE;
    }

    public void setPCT_AVERAGE(String PCT_AVERAGE) {
        this.PCT_AVERAGE = PCT_AVERAGE;
    }

    public String getPCT_MEDIAN() {
        return PCT_MEDIAN;
    }

    public void setPCT_MEDIAN(String PCT_MEDIAN) {
        this.PCT_MEDIAN = PCT_MEDIAN;
    }

    public String getPCT_STDDEVIATION() {
        return PCT_STDDEVIATION;
    }

    public void setPCT_STDDEVIATION(String PCT_STDDEVIATION) {
        this.PCT_STDDEVIATION = PCT_STDDEVIATION;
    }

    public String getPCT_SUM1() {
        return PCT_SUM1;
    }

    public void setPCT_SUM1(String PCT_SUM1) {
        this.PCT_SUM1 = PCT_SUM1;
    }
}
