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

import com.microfocus.adm.performancecenter.plugins.common.rest.PcRestProxy;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

public class PcScript {
    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private int ID;
    private String Name;
    private String CreatedBy;
    private String TestFolderPath;
    private String WorkingMode;
    private String Protocol;
    private String LastModifyDate;
    private String CreationDate;
    private boolean IsScriptLocked;

    public static PcScript xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Script", PcScript.class);
        xstream.useAttributeFor(PcScript.class, "xmlns");
        xstream.setClassLoader(PcScript.class.getClassLoader());
        return (PcScript) xstream.fromXML(xml);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getTestFolderPath() {
        return TestFolderPath;
    }

    public void setTestFolderPath(String testFolderPath) {
        TestFolderPath = testFolderPath;
    }

    public String getWorkingMode() {
        return WorkingMode;
    }

    public void setWorkingMode(String workingMode) {
        WorkingMode = workingMode;
    }

    public String getProtocol() {
        return Protocol;
    }

    public void setProtocol(String protocol) {
        Protocol = protocol;
    }

    public String getLastModifyDate() {
        return LastModifyDate;
    }

    public void setLastModifyDate(String lastModifyDate) {
        LastModifyDate = lastModifyDate;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public boolean getIsScriptLocked() {
        return IsScriptLocked;
    }

    public void setScriptLocked(boolean scriptLocked) {
        IsScriptLocked = scriptLocked;
    }
}
