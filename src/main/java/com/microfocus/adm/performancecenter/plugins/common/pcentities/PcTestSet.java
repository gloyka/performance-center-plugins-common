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

public class PcTestSet {
    private String TestSetName;
    private String TestSetComment;
    private int TestSetParentId;
    private int TestSetID;

    public static PcTestSet xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TestSetID", PcRunResult.class);
        return (PcTestSet) xstream.fromXML(xml);
    }

    public String getTestSetName() {
        return TestSetName;
    }

    public void setTestSetName(String testSetName) {
        TestSetName = testSetName;
    }

    public String getTestSetComment() {
        return TestSetComment;
    }

    public void setTestSetComment(String testSetComment) {
        TestSetComment = testSetComment;
    }

    public int getTestSetParentId() {
        return TestSetParentId;
    }

    public void setTestSetParentId(int testSetParentId) {
        TestSetParentId = testSetParentId;
    }

    public int getTestSetID() {
        return TestSetID;
    }

    public void setTestSetID(int testSetID) {
        TestSetID = testSetID;
    }
}
