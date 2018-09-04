package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

public class PcScripts {

    private ArrayList<PcScript> pcScriptList;

    public PcScripts() {
        pcScriptList = new ArrayList<PcScript>();
    }

    public static PcScripts xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script" , PcScript.class);
        xstream.alias("Scripts" , PcScripts.class);
        xstream.addImplicitCollection(PcScripts.class, "pcScriptList");
        xstream.setClassLoader(PcScripts.class.getClassLoader());
        return (PcScripts)xstream.fromXML(xml);
    }

    public ArrayList<PcScript> getPcScriptList() {
        return pcScriptList;
    }

}
