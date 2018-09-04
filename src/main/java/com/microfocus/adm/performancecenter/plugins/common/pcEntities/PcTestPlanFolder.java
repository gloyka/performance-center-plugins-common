package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

public class PcTestPlanFolder {


    public int getId() {
        return Id;
    }

    public int getParentId() {
        return ParentId;
    }

    public String getName() {
        return Name;
    }

    public String getFullPath() {
        return FullPath;
    }



    public static PcTestPlanFolder xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TestPlanFolder" , PcTestPlanFolder.class);
        xstream.useAttributeFor(PcTestPlanFolder.class, "xmlns");
        xstream.setClassLoader(PcTestPlanFolder.class.getClassLoader());
        return (PcTestPlanFolder)xstream.fromXML(xml);
    }

    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private int Id;
    private int ParentId;
    private String Name;
    private String FullPath;

}
