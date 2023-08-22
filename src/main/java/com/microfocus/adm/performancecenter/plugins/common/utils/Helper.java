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

package com.microfocus.adm.performancecenter.plugins.common.utils;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcException;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcTestPlanFolder;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcTestPlanFolders;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common.stringToInteger;

public class Helper {
    public static XStream xstreamPermissions(XStream xstream) {
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(Collection.class);
        xstream.allowTypesByWildcard(new String[]{
                "com.microfocus.adm.performancecenter.plugins.common.pcentities.**"
        });
        xstream.ignoreUnknownElements();
        return xstream;
    }

    //verifying the items in ArrayList list exist in PC, if yes, removing them from ArrayList
    //+ sorting the list so the folders creations depending on other folders creation come last .
    public static ArrayList<String[]> getCleanAndNonExistingAndSortedArrayList(ArrayList<String[]> pathFromSubjectAndFolders, PcTestPlanFolders pcTestPlanFolders) throws IOException, PcException {

        ArrayList<String[]> pathFromSubjectAndFoldersFiltered = new ArrayList<String[]>();
        for (String[] pathFromSubjectAndFolder : pathFromSubjectAndFolders
        ) {
            String fullpath = pathFromSubjectAndFolder[0] + '\\' + pathFromSubjectAndFolder[1];
            boolean exist = false;
            if (pcTestPlanFolders != null) {
                for (PcTestPlanFolder pcTestPlanFolder : pcTestPlanFolders.getPcTestPlanFolderList()
                ) {
                    if (pcTestPlanFolder.getFullPath().equalsIgnoreCase(fullpath)) {
                        exist = true;
                        break;
                    }
                }
                if (!exist)
                    pathFromSubjectAndFoldersFiltered.add(pathFromSubjectAndFolder);
            }
        }
        Collections.sort(pathFromSubjectAndFoldersFiltered, new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[0].compareTo(otherStrings[0]);
            }
        });
        return pathFromSubjectAndFoldersFiltered;
    }

    //transforming paths string array to ArrayList string arrays:
    // one for the folder path where the folder should be created and the other for the folder name to be created
    public static ArrayList<String[]> getArrayListOfStringArray(String[] paths) {
        //creating array list of all paths + folder combination to be created.
        ArrayList<String[]> pathFromSubjectAndFolders = new ArrayList<String[]>();
        for (String path : paths
        ) {
            List<String> folders = Arrays.asList(path.split("\\\\"));
            for (int i = 1; i < folders.size(); i++) {
                String pathFromSubject = join("\\", folders.subList(0, i));
                String folder = folders.get(i);
                String[] pathFromSubjectAndFolder = {pathFromSubject, folder};
                if (!IsArrayExistInArrayList(pathFromSubjectAndFolders, pathFromSubjectAndFolder))
                    pathFromSubjectAndFolders.add(pathFromSubjectAndFolder);
            }
        }
        return pathFromSubjectAndFolders;
    }

    private static boolean IsArrayExistInArrayList(ArrayList<String[]> arrayList, String[] arrayToVerify) {
        for (String[] array : arrayList
        ) {
            if (Arrays.equals(array, arrayToVerify))
                return true;
        }
        return false;
    }

    public static String join(CharSequence delimiter, List<String> tokens) {
        final int length = tokens.size();
        if (length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(tokens.get(0));
        for (int i = 1; i < length; i++) {
            sb.append(delimiter);
            sb.append(tokens.get(i));
        }
        return sb.toString();
    }

    public static String[] GetLreServerAndTenant(String lreServer) {
        String delimiterSlash = "/";
        String delimiterQuestionMark = "\\?";
        String useDelimiter = delimiterSlash;
        String[] strServerAndTenant = {lreServer, ""};
        String theLreServer = lreServer;
        //replace for common mistakes
        if (lreServer != null && !lreServer.isEmpty()) {
            theLreServer = lreServer.toLowerCase().replace("http://", "");
            theLreServer = theLreServer.replace("https://", "");
            theLreServer = theLreServer.replace("/lre", "");
            theLreServer = theLreServer.replace("/site", "");
            theLreServer = theLreServer.replace("/loadtest", "");
            theLreServer = theLreServer.replace("/pcx", "");
            theLreServer = theLreServer.replace("/adminx", "");
            theLreServer = theLreServer.replace("/admin", "");
            theLreServer = theLreServer.replace("/login", "");
        }
        if (theLreServer != null && !theLreServer.isEmpty()) {
            if (theLreServer.contains("/")) {
                useDelimiter = delimiterSlash;
            } else if (theLreServer.contains("?")) {
                useDelimiter = delimiterQuestionMark;
            }
            String[] severTenantArray = theLreServer.split(useDelimiter);
            if (severTenantArray.length > 0) {
                strServerAndTenant[0] = severTenantArray[0];
                if (severTenantArray.length > 1) {
                    if (useDelimiter.equals(delimiterQuestionMark)) {
                        strServerAndTenant[1] = delimiterQuestionMark + severTenantArray[1];
                    } else {
                        strServerAndTenant[1] = severTenantArray[1];
                    }
                }
            }
        }
        return strServerAndTenant;
    }

    public static int extractTestIdFromString(String value) {
        if (value != null && !value.isEmpty()) {
            Pattern pattern = Pattern.compile("ID:\'([^\']*)\'");
            Matcher matcher = pattern.matcher(value);
            while (matcher.find()) {
                return stringToInteger(matcher.group(1));
            }
        }
        return 0;
    }

    public static Path getParent(Path path) {
        if (path.getParent() != null)
            return path.getParent();
        return Paths.get(getParent(path.toString()));
    }

    public static String getName(String strPath) {
        char chrSeparatorBackward = '\\';
        char chrSeparatorForward = '/';
        String strPathToHandle = strPath;
        if (strPathToHandle == null || strPathToHandle.isEmpty() || !(strPathToHandle.indexOf(chrSeparatorBackward) != -1 || strPathToHandle.indexOf(chrSeparatorForward) != -1))
            return strPathToHandle;
        if (strPathToHandle.indexOf(chrSeparatorForward) != -1)
            strPathToHandle = strPathToHandle.replace(chrSeparatorForward, chrSeparatorBackward);
        if (strPathToHandle.endsWith(String.valueOf(chrSeparatorBackward)))
            strPathToHandle = strPathToHandle.replaceAll("\\$", "");

        int index = strPathToHandle.lastIndexOf(chrSeparatorBackward);
        strPathToHandle = strPathToHandle.substring(index + 1);
        return strPathToHandle;
    }

    private static String getParent(String strPath) {
        char chrSeparatorBackward = '\\';
        char chrSeparatorForward = '/';
        String strPathToHandle = strPath;
        if (strPathToHandle == null || strPathToHandle.isEmpty() || !(strPathToHandle.indexOf(chrSeparatorBackward) != -1 || strPathToHandle.indexOf(chrSeparatorForward) != -1))
            return "";
        if (strPathToHandle.indexOf(chrSeparatorForward) != -1)
            strPathToHandle = strPathToHandle.replace(chrSeparatorForward, chrSeparatorBackward);
        if (strPathToHandle.endsWith(String.valueOf(chrSeparatorBackward)))
            strPathToHandle = strPathToHandle.replaceAll("\\$", "");

        int index = strPathToHandle.lastIndexOf(chrSeparatorBackward);
        strPathToHandle = strPathToHandle.substring(0, index);
        return strPathToHandle;
    }
}
