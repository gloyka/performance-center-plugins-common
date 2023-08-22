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

public class PcTestInstance {
    private int TestID;
    private int TestSetID;
    private int TestInstanceID;

    public static PcTestInstance xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("TestInstanceID", PcTestInstance.class);
        xstream.setClassLoader(PcTestInstance.class.getClassLoader());
        return (PcTestInstance) xstream.fromXML(xml);
    }

    public int getInstanceId() {
        return TestInstanceID;
    }

    public int getTestId() {
        return TestID;
    }

    public int getTestSetId() {
        return TestSetID;
    }

    public void setTestID(int testID) {
        TestID = testID;
    }

    public void setTestSetID(int testSetID) {
        TestSetID = testSetID;
    }

    public void setTestInstanceID(int testInstanceID) {
        TestInstanceID = testInstanceID;
    }
}
