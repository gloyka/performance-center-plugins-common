package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

public class PcTestPlanFolders {



    private ArrayList<PcTestPlanFolder> pcTestPlanFolderList;

    public PcTestPlanFolders() {
        pcTestPlanFolderList = new ArrayList<PcTestPlanFolder>();
    }

    public ArrayList<PcTestPlanFolder> getPcTestPlanFolderList() {
        return pcTestPlanFolderList;
    }

    public static PcTestPlanFolders xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TestPlanFolder" , PcTestPlanFolder.class);
        xstream.alias("TestPlanFolders" , PcTestPlanFolders.class);
        xstream.addImplicitCollection(PcTestPlanFolders.class, "pcTestPlanFolderList");
        xstream.setClassLoader(PcScripts.class.getClassLoader());
        return (PcTestPlanFolders)xstream.fromXML(xml);
    }

}
