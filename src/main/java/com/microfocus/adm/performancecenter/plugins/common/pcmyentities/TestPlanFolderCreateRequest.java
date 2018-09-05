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

public class TestPlanFolderCreateRequest {

    private String xmlns = PcRestProxy.PC_API_XMLNS;

    private String path;
    private String name;

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

    public PcTestPlanFolder getPcTestPlanFolderFromResponse(String xml) throws IOException, SAXException, ParserConfigurationException {

        PcTestPlanFolder pcTestPlanFolder = new PcTestPlanFolder();
        return pcTestPlanFolder.xmlToObject(xml);

    }

}
