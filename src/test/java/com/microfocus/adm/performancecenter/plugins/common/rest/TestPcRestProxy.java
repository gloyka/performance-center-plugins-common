package com.microfocus.adm.performancecenter.plugins.common.rest;

//import com.microfocus.adm.performancecenter.plugins.common.pcentities.RunState;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.IOException;

public class TestPcRestProxy {

    private PcRestProxy pcRestProxy;

    public final String RESOURCES_DIR = getClass().getResource("").getPath();

//    @BeforeClass
    public void setUp() throws  PcException, Exception {
        System.out.println("setUp: starts");
        try {
            pcRestProxy = new PcRestProxy(PcRestProxyBase.WEB_PROTOCOL, PcRestProxyBase.PC_SERVER_NAME, PcRestProxyBase.ALM_DOMAIN, PcRestProxyBase.ALM_PROJECT, "","","");
            System.out.println("setUp: setUp done.");
        } catch (PcException ex) {
            System.out.println("setUp: setUp failed. PcException = " + ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("setUp: ends");
    }


//    @Test
    public void verifyAll() throws  PcException, Exception {
        System.out.println("verify starts");
        try {
            setUp();
            testLogin();
            getTestInstancesByTestId(9);
            getTestPlanFolders();
            PcTestPlanFolder pcTestPlanFolder = CreateTestPlanFolder("Subject\\coucou", "scripts2");
            verifyTestPlanFolderExist("Subject\\1coucou1");
            String[] subjectPaths = {"Subject\\1coucou1\\coucou1\\coucou1", "Subject\\1coucou1\\coucou1\\coucou2", "Subject\\1coucou2\\coucou2\\coucou1", "Subject\\1coucou2\\coucou2\\coucou2", "Subject\\1coucou2\\coucou2\\coucou2"};
            createTestPlanFolders(subjectPaths);
            testGetAllTestSets();
            int scriptId = testUploadScript();
            getScripts();
            PcScript pcScript = getScript(scriptId);
            PcScript pcScript2 = getScript(pcScript.getTestFolderPath());
            if(pcScript.getID() == pcScript2.getID())
                System.out.println("both scripts are similar");
            if (scriptId > 0)
                deleteScript(scriptId);
            testLogout();

        } catch (PcException ex) {
            System.out.println("verify failed. PcException = " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("verify failed. Exception = " + ex.getMessage());
        }
        System.out.println("verify ends");
    }




    public void testLogin() throws PcException, IOException {
        System.out.println("testLogin: starts");
        try {
            System.out.println("testLogin: Testing Login to PC server");
            Assert.assertTrue("testLogin: Authenticate success", pcRestProxy.authenticate(PcRestProxyBase.ALM_USER_NAME, PcRestProxyBase.ALM_PASSWORD));
        }
        catch (PcException ex) {
            System.out.println("testLogin: Failed to Authenticate. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("testLogin: Failed to Authenticate. IOException = " + ex.getMessage());
        }
        System.out.println("testLogin: ends");
    }

    public PcTestInstances getTestInstancesByTestId(int testID) {
        System.out.println("getTestInstancesByTestId: starts");
        try {
            PcTestInstances pcTestInstances = pcRestProxy.getTestInstancesByTestId(testID);
            System.out.println(String.format("getTestInstancesByTestId: pcTestInstances are: %s", pcTestInstances.getTestInstancesList().toString()));
            return pcTestInstances;
        } catch (PcException|IOException ex) {
            System.out.println(String.format("getTestInstancesByTestId: failed getting TestInstances for test %s. PcException = %s", testID, ex.getMessage()));
        }
        System.out.println("testGetAllTestSets: ends");
        return  null;
    }


    public void testGetAllTestSets () throws PcException, IOException {
        System.out.println("testGetAllTestSets: starts");
        try {
            PcTestSets pcTestSets = pcRestProxy.GetAllTestSets();
            Assert.assertTrue("testGetAllTestSets: testsets received", !pcTestSets.getPcTestSetsList().isEmpty());
        }
        catch (PcException ex) {
            System.out.println("testGetAllTestSets: failed getting testsets. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("testGetAllTestSets: failed getting testsets. IOException = " + ex.getMessage());
        }
        System.out.println("testGetAllTestSets: ends");
    }

    public int testUploadScript() throws PcException, IOException {
        System.out.println("testUploadScript: starts");
        try {
            System.out.println("testUploadScript: Uploading script to project");
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("microfocus/adm/performancecenter/plugins/common/rest/kilimanjaro.zip").getFile());
            int scriptId = pcRestProxy.uploadScript(PcRestProxyBase.testFolderPath, PcRestProxyBase.Overwrite, PcRestProxyBase.RuntimeOnly, PcRestProxyBase.KeepCheckedOut, file.getPath());
            System.out.println("testUploadScript: Uploading script to project to scriptID " + scriptId);
            System.out.println("testUploadScript: ends");
            return scriptId;
        }
        catch (PcException ex) {
            System.out.println("testUploadScript: Uploading script failed. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("testUploadScript: Uploading script failed. IOException = " + ex.getMessage());
        }
        System.out.println("testUploadScript: ends");
        return 0;
    }

    public boolean getScripts() throws PcException, IOException {
        System.out.println("getScripts: starts");
        try {
            System.out.println("getScripts: getting all scripts from the project");
            PcScripts pcScripts = pcRestProxy.getScripts();
            String scriptIdsList = "ID of scripts in the project: ";
            for (PcScript pcScript: pcScripts.getPcScriptList()
                 ) {
                scriptIdsList = scriptIdsList.concat(String.format("%d, ", pcScript.getID()));
//                System.out.println(String.format("ID = %s, Name = %s, CreatedBy = %s, TestFolderPath = %s, WorkingMode = %s, Protocol = %s",
//                        Integer.toString(pcScript.getId()), pcScript.getParentId(), pcScript.getParentId(),
//                        pcScript.getFullPath(), pcScript.getWorkingMode(), pcScript.getProtocol()));

            }
            scriptIdsList = scriptIdsList.substring(0, scriptIdsList.length() - 2);
            System.out.println(scriptIdsList);
            return true;
        }
        catch (PcException ex) {
            System.out.println("getScripts: getting all scripts failed. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("getScripts: getting all scripts failed. IOException = " + ex.getMessage());
        }
        System.out.println("getScripts: ends");
        return false;
    }

    public PcScript getScript (int Id) throws PcException, IOException {
        System.out.println("getScript: starts");
        try {
            System.out.println(String.format("getScript: getting script ID = %s from the project", Id));
            PcScript pcScript = pcRestProxy.getScript(Id);
            System.out.println(String.format("ID = %s, Name = %s, CreatedBy = %s, TestFolderPath = %s, WorkingMode = %s, Protocol = %s,",
                    Integer.toString(pcScript.getID()), pcScript.getName(), pcScript.getCreatedBy(),
                    pcScript.getTestFolderPath(), pcScript.getWorkingMode(), pcScript.getProtocol()));
            return pcScript;
        }
        catch (PcException ex) {
            System.out.println("getScript: getting script failed. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("getScript: getting script failed. IOException = " + ex.getMessage());
        }
        System.out.println("getScript: ends");
        return null;
    }

    public PcTestPlanFolders getTestPlanFolders () throws PcException, IOException {
        System.out.println("getTestPlan: starts");
        try {
            System.out.println(String.format("getTestPlan"));
            PcTestPlanFolders pcTestPlanFolders = pcRestProxy.getTestPlanFolders();
            for (PcTestPlanFolder pcTestPlanFolder : pcTestPlanFolders.getPcTestPlanFolderList()
                 ) {
                System.out.println(String.format("Id = %s, Name = %s, ParentId = %s, FullPath = %s", pcTestPlanFolder.getId(), pcTestPlanFolder.getName(), pcTestPlanFolder.getParentId(), pcTestPlanFolder.getFullPath() ));
            }

            return pcTestPlanFolders;
        }
        catch (PcException|IOException ex) {
            System.out.println("getTestPlan: getting TestPlanFolders failed. PcException = " + ex.getMessage());
        }

        System.out.println("getTestPlan: ends");
        return null;
    }


    public PcTestPlanFolder CreateTestPlanFolder (String path, String name) throws PcException, IOException {
        System.out.println("CreateTestPlanFolder: starts");
        try {

            System.out.println(String.format("CreateTestPlanFolder: requesting to create Folder '%s' under folder path '%s'", path, name));
            PcTestPlanFolder pcTestPlanFolder = pcRestProxy.createTestPlanFolder(path, name);
            System.out.println(String.format("Folder created: Id = %s, Name = %s, ParentId = %s, FullPath = %s", pcTestPlanFolder.getId(), pcTestPlanFolder.getName(), pcTestPlanFolder.getParentId(), pcTestPlanFolder.getFullPath() ));


            return pcTestPlanFolder;
        }
        catch (PcException|IOException ex) {
            System.out.println("CreateTestPlanFolder: creating TestPlan Folder failed. PcException = " + ex.getMessage());
        }

        System.out.println("CreateTestPlanFolder: ends");
        return null;
    }

    public boolean verifyTestPlanFolderExist(String path) {
        System.out.println("verifyTestPlanFolderExist: starts");
        try {

            System.out.println(String.format("verifyTestPlanFolderExist: Verifying if Folder '%s' exists", path));
            boolean testPlanfolderExist = pcRestProxy.verifyTestPlanFolderExist(path);
            System.out.println(String.format(testPlanfolderExist ? "verifyTestPlanFolderExist: Folder '%s' does exist" : "verifyTestPlanFolderExist: Folder '%s' does not exist", path));

            return testPlanfolderExist;
        }
        catch (PcException|IOException ex) {
            System.out.println("verifyTestPlanFolderExist: creating TestPlan Folder failed. PcException = " + ex.getMessage());
        }

        System.out.println("verifyTestPlanFolderExist: ends");
        return false;
    }

    public ArrayList<PcTestPlanFolder> createTestPlanFolders(String[] paths) {
        System.out.println("verifyTestPlanFolderExist: starts");
        ArrayList<PcTestPlanFolder> pcTestPlanFolders = null;
        try {
        pcTestPlanFolders = pcRestProxy.createTestPlanFolders(paths);
        for (PcTestPlanFolder pcTestPlanFolder: pcTestPlanFolders
                ) {
            System.out.println(String.format("Id = %s, Name = %s, ParentId = %s, FullPath = %s", pcTestPlanFolder.getId(), pcTestPlanFolder.getName(), pcTestPlanFolder.getParentId(), pcTestPlanFolder.getFullPath() ));
        }
        }
        catch (PcException|IOException ex) {
            System.out.println("verifyTestPlanFolderExist: creating TestPlan Folder failed. PcException = " + ex.getMessage());
        }
        System.out.println("verifyTestPlanFolderExist: ends");
        return pcTestPlanFolders;
    }


    public PcScript getScript (String testFolderPath) throws PcException, IOException {
        System.out.println("getScript: starts");
        try {
            System.out.println(String.format("getScript: getting script folder = %s from the project", testFolderPath));
            PcScript pcScript = pcRestProxy.getScript(testFolderPath);
            System.out.println(String.format("ID = %s, Name = %s, CreatedBy = %s, TestFolderPath = %s, WorkingMode = %s, Protocol = %s,",
                    Integer.toString(pcScript.getID()), pcScript.getName(), pcScript.getCreatedBy(),
                    pcScript.getTestFolderPath(), pcScript.getWorkingMode(), pcScript.getProtocol()));
            return pcScript;
        }
        catch (PcException ex) {
            System.out.println("getScript: getting script failed. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("getScript: getting script failed. IOException = " + ex.getMessage());
        }
        System.out.println("getScript: ends");
        return null;
    }





    public boolean deleteScript(int scriptId) throws PcException, IOException {
        System.out.println("deleteScript: starts");
        try {
            System.out.println("deleteScript: deleting script from project");
            boolean deleteSuccess = pcRestProxy.deleteScript(scriptId);
            System.out.println(String.format("deleteScript: deleting script %s from project to  ", scriptId));
            System.out.println("deleteScript: ends");
            return deleteSuccess;
        }
        catch (PcException ex) {
            System.out.println("deleteScript: deleting script failed. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("deleteScript: deleting script failed. IOException = " + ex.getMessage());
        }
        System.out.println("deleteScript: ends");
        return false;
    }

    public void testLogout() throws PcException, IOException {
        System.out.println("testLogout: starts");
        try {
        System.out.println("testLogout: Testing Logout from PC server");
        Assert.assertTrue("testLogout: Failed to logout with pcClient", pcRestProxy.logout());
        }
        catch (PcException ex) {
            System.out.println("testLogout: logout failed. PcException = " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("testLogout: logout failed. IOException = " + ex.getMessage());
        }
        System.out.println("testLogout: ends");
    }

}