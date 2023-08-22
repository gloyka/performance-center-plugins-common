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
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestPlanFolderCreateRequest {
    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private String path;
    private String name;

    public TestPlanFolderCreateRequest() {
    }

    public TestPlanFolderCreateRequest(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(TestPlanFolderCreateRequest.class, "xmlns");
        xstream.alias("TestPlanFolder", TestPlanFolderCreateRequest.class);
        xstream.aliasField("Path", TestPlanFolderCreateRequest.class, "path");
        xstream.aliasField("Name", TestPlanFolderCreateRequest.class, "name");
        return xstream.toXML(this);
    }

    public PcTestPlanFolder getPcTestPlanFolderFromResponse(String xml)
            throws IOException, SAXException, ParserConfigurationException {
        PcTestPlanFolder pcTestPlanFolder = new PcTestPlanFolder();
        return pcTestPlanFolder.xmlToObject(xml);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
