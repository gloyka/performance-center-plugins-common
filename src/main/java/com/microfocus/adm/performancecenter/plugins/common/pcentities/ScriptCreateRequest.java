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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ScriptCreateRequest {
    private String xmlns = PcRestProxy.PC_API_XMLNS;
    private String testFolderPath;
    private boolean overwrite;
    private boolean runtimeOnly;
    private boolean keepCheckedOut;

    public ScriptCreateRequest() {
    }

    public ScriptCreateRequest(String testFolderPath, boolean overwrite,
                               boolean runtimeOnly, boolean keepCheckedOut) {
        this.testFolderPath = testFolderPath;
        this.overwrite = overwrite;
        this.runtimeOnly = runtimeOnly;
        this.keepCheckedOut = keepCheckedOut;
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.useAttributeFor(ScriptCreateRequest.class, "xmlns");
        xstream.alias("Script", ScriptCreateRequest.class);
        xstream.aliasField("TestFolderPath", ScriptCreateRequest.class, "testFolderPath");
        xstream.aliasField("Overwrite", ScriptCreateRequest.class, "overwrite");
        xstream.aliasField("RuntimeOnly", ScriptCreateRequest.class, "runtimeOnly");
        xstream.aliasField("KeepCheckedOut", ScriptCreateRequest.class, "keepCheckedOut");
        return xstream.toXML(this);
    }

    public int getScriptIdFromResponse(String xml, String getScriptID)
            throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8")));
        Document doc = builder.parse(is);
        Element element = doc.getDocumentElement();
        NodeList nListTrendedRun = doc.getElementsByTagName("ID");
        return Integer.parseInt(nListTrendedRun.item(0).getTextContent());
    }

    public String getTestFolderPath() {
        return testFolderPath;
    }

    public void setTestFolderPath(String testFolderPath) {
        this.testFolderPath = testFolderPath;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public boolean isRuntimeOnly() {
        return runtimeOnly;
    }

    public void setRuntimeOnly(boolean runtimeOnly) {
        this.runtimeOnly = runtimeOnly;
    }

    public boolean isKeepCheckedOut() {
        return keepCheckedOut;
    }

    public void setKeepCheckedOut(boolean keepCheckedOut) {
        this.keepCheckedOut = keepCheckedOut;
    }
}

