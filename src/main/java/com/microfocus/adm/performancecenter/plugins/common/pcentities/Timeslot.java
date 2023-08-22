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

public class Timeslot {
    private String Name;
    private int VusersNumber;
    private int VudsNumber;
    private String PostRunAction;
    private String StartTime;
    private int DurationInMinutes;
    private boolean IsTestAutostart;
    private int LoadTestInstanceID;
    private int ID;
    private int LoadTestID;
    private String LoadTestName;
    private String EndTime;
    private String CreatedBy;
    private String CreationDate;
    private String CurrentRunState;
    private int CurrentRunId;
    private boolean IsAdHoc;
    private boolean IsAllocated;
    private boolean IsAutoProlong;
    private String OpenStatus;
    private int ProjectID;

    public static Timeslot xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("ID", Timeslot.class);
        xstream.setClassLoader(Timeslot.class.getClassLoader());
        return (Timeslot) xstream.fromXML(xml);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getVusersNumber() {
        return VusersNumber;
    }

    public void setVusersNumber(int vusersNumber) {
        VusersNumber = vusersNumber;
    }

    public int getVudsNumber() {
        return VudsNumber;
    }

    public void setVudsNumber(int vudsNumber) {
        VudsNumber = vudsNumber;
    }

    public String getPostRunAction() {
        return PostRunAction;
    }

    public void setPostRunAction(String postRunAction) {
        PostRunAction = postRunAction;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public int getDurationInMinutes() {
        return DurationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        DurationInMinutes = durationInMinutes;
    }

    public boolean isTestAutostart() {
        return IsTestAutostart;
    }

    public void setTestAutostart(boolean testAutostart) {
        IsTestAutostart = testAutostart;
    }

    public int getLoadTestInstanceID() {
        return LoadTestInstanceID;
    }

    public void setLoadTestInstanceID(int loadTestInstanceID) {
        LoadTestInstanceID = loadTestInstanceID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLoadTestID() {
        return LoadTestID;
    }

    public void setLoadTestID(int loadTestID) {
        LoadTestID = loadTestID;
    }

    public String getLoadTestName() {
        return LoadTestName;
    }

    public void setLoadTestName(String loadTestName) {
        LoadTestName = loadTestName;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getCurrentRunState() {
        return CurrentRunState;
    }

    public void setCurrentRunState(String currentRunState) {
        CurrentRunState = currentRunState;
    }

    public int getCurrentRunId() {
        return CurrentRunId;
    }

    public void setCurrentRunId(int currentRunId) {
        CurrentRunId = currentRunId;
    }

    public boolean isAdHoc() {
        return IsAdHoc;
    }

    public void setAdHoc(boolean adHoc) {
        IsAdHoc = adHoc;
    }

    public boolean isAllocated() {
        return IsAllocated;
    }

    public void setAllocated(boolean allocated) {
        IsAllocated = allocated;
    }

    public boolean isAutoProlong() {
        return IsAutoProlong;
    }

    public void setAutoProlong(boolean autoProlong) {
        IsAutoProlong = autoProlong;
    }

    public String getOpenStatus() {
        return OpenStatus;
    }

    public void setOpenStatus(String openStatus) {
        OpenStatus = openStatus;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }
}
