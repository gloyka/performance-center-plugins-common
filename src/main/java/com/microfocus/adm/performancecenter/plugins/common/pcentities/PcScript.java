package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;


public class PcScript {

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public String getTestFolderPath() {
        return TestFolderPath;
    }

    public String getWorkingMode() {
        return WorkingMode;
    }

    public String getProtocol() {
        return Protocol;
    }

    public String getLastModifyDate() { return LastModifyDate; }

    public String getCreationDate() { return CreationDate; }

    public boolean getIsScriptLocked() { return IsScriptLocked; }

    public static PcScript xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script" , PcScript.class);
        xstream.useAttributeFor(PcScript.class, "xmlns");
        xstream.setClassLoader(PcScript.class.getClassLoader());
        return (PcScript)xstream.fromXML(xml);
    }

    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private int ID;
    private String Name;
    private String CreatedBy;
    private String TestFolderPath;
    private String WorkingMode;
    private  String Protocol;
    private String LastModifyDate;
    private String CreationDate;
    private boolean IsScriptLocked;

}
