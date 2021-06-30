/**
 Copyright 2018 Micro Focus International plc

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.microfocus.adm.performancecenter.plugins.common.pcentities;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;

/**
 * Created by bemh on 6/1/2017.
 */
public class Timeslot {
    public String Name;
    public int VusersNumber;
    public int VudsNumber;
    public String PostRunAction;
    public String StartTime;
    public int DurationInMinutes;
    public boolean IsTestAutostart;
    public int LoadTestInstanceID;
    public int ID;
    public int LoadTestID;
    public String LoadTestName;
    public String EndTime;
    public String CreatedBy;
    public String CreationDate;
    public String CurrentRunState;
    public int CurrentRunId;
    public boolean IsAdHoc;
    public boolean IsAllocated;
    public boolean IsAutoProlong;
    public String OpenStatus;
    public int ProjectID;

    public static Timeslot xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ID" , Timeslot.class);
        xstream.setClassLoader(Timeslot.class.getClassLoader());
        return (Timeslot)xstream.fromXML(xml);
    }

    public String getName() {
        return Name;
    }

    public int getVusersNumber() {
        return VusersNumber;
    }

    public int getVudsNumber() {
        return VudsNumber;
    }

    public String getPostRunAction() {
        return PostRunAction;
    }

    public String getStartTime() {
        return StartTime;
    }

    public int getDurationInMinutes() {
        return DurationInMinutes;
    }

    public boolean isTestAutostart() {
        return IsTestAutostart;
    }

    public int getLoadTestInstanceID() {
        return LoadTestInstanceID;
    }

    public int getID() {
        return ID;
    }

    public int getLoadTestID() {
        return LoadTestID;
    }

    public String getLoadTestName() {
        return LoadTestName;
    }

    public String getEndTime() {
        return EndTime;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public String getCurrentRunState() {
        return CurrentRunState;
    }

    public int getCurrentRunId() {
        return CurrentRunId;
    }

    public boolean isAdHoc() {
        return IsAdHoc;
    }

    public boolean isAllocated() {
        return IsAllocated;
    }

    public boolean isAutoProlong() {
        return IsAutoProlong;
    }

    public String getOpenStatus() {
        return OpenStatus;
    }

    public int getProjectID() {
        return ProjectID;
    }
}
