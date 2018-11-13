package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.automatictrending;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.TrendRangeTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums.MaxRunsReachedOptionValues;
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
@XmlRootElement(name="AutomaticTrending")
public class AutomaticTrending {

    @XmlElement
    private String ReportId;

    @XmlElement
    private String MaxRunsInReport;

    /*Possible values: CompleteRun, PartOfRun*/
    @XmlElement
    private String  TrendRangeType;

    /*Possible values: DoNotPublishAdditionalRuns, DeleteFirstSetNewBaseline.*/
    @XmlElement
    private String MaxRunsReachedOption;

    public AutomaticTrending() {}

    public AutomaticTrending(int reportId, int maxRunsInReport, TrendRangeTypeValues trendRangeType, MaxRunsReachedOptionValues maxRunsReachedOption) {
        setReportId(reportId);
        setMaxRunsInReport(maxRunsInReport);
        setTrendRangeType(trendRangeType);
        setMaxRunsReachedOption(maxRunsReachedOption);
    }

    public AutomaticTrending(int reportId, int maxRunsInReport, String trendRangeType, String maxRunsReachedOption) {
        setReportId(reportId);
        setMaxRunsInReport(maxRunsInReport);
        setTrendRangeType(trendRangeType);
        setMaxRunsReachedOption(maxRunsReachedOption);
    }

    public void setTrendRangeType(String trendRangeType) {
        this.TrendRangeType = trendRangeType;
    }

    public void setTrendRangeType(TrendRangeTypeValues trendRangeType) {
        this.TrendRangeType = trendRangeType.value();
    }

    public void setMaxRunsReachedOption(String maxRunsReachedOption) {
        this.MaxRunsReachedOption = maxRunsReachedOption;
    }


    public void setMaxRunsReachedOption(MaxRunsReachedOptionValues maxRunsReachedOption) {
        this.MaxRunsReachedOption = maxRunsReachedOption.value();
    }

    public void setReportId(int reportId) {
            this.ReportId = Common.integerToString(reportId);
    }

    public void setMaxRunsInReport(int maxRunsInReport) {
            this.MaxRunsInReport = Common.integerToString(maxRunsInReport);
    }

    @Override
    public String toString() {
        return "AutomaticTrending{" + "ReportId = " + ReportId +
                ", MaxRunsInReport = " + MaxRunsInReport +
                ", TrendRangeTypeValues = " + TrendRangeType +
                ", MaxRunsReachedOptionValues = " + MaxRunsReachedOption + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        //xstream.useAttributeFor(Content.class, "xmlns");
        xstream.alias("AutomaticTrending", AutomaticTrending.class);
        xstream.aliasField("ReportId", AutomaticTrending.class, "ReportId");
        xstream.aliasField("MaxRunsInReport", AutomaticTrending.class, "MaxRunsInReport");
        xstream.aliasField("TrendRangeTypeValues", AutomaticTrending.class, "TrendRangeTypeValues");
        xstream.aliasField("MaxRunsReachedOptionValues", AutomaticTrending.class, "MaxRunsReachedOptionValues");
        xstream.aliasField("AnalysisTemplate", AutomaticTrending.class, "AnalysisTemplate");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static AutomaticTrending xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("AutomaticTrending" , AutomaticTrending.class);
        xstream.setClassLoader(AutomaticTrending.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (AutomaticTrending)xstream.fromXML(xml);
    }

}
