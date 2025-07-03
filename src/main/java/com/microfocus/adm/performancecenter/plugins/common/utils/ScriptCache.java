package com.microfocus.adm.performancecenter.plugins.common.utils;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcException;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.PcScript;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ScriptCache {
    private final Map<String, PcScript> scriptByNameAndPath;
    private final Map<Integer, PcScript> scriptById;

    public ScriptCache(List<PcScript> pcScriptList) {
        scriptByNameAndPath = new HashMap<>();
        scriptById = new HashMap<>();

        for (PcScript script : pcScriptList) {
            String key = buildKey(script.getTestFolderPath(), script.getName()).toLowerCase();
            scriptByNameAndPath.put(key, script);
            scriptById.put(script.getID(), script);
        }
    }

    public PcScript getScript(String testFolderPath, String scriptName) throws PcException {
        String key = buildKey(testFolderPath, scriptName).toLowerCase();
        PcScript script = scriptByNameAndPath.get(key);
        if (script == null) {
            throw new PcException(String.format("No script named '%s' was found under folder path '%s'.", scriptName, testFolderPath));
        }
        return script;
    }

    public PcScript getScript(int scriptId) throws PcException {
        PcScript script = scriptById.get(scriptId);
        if (script == null) {
            throw new PcException(String.format("No script with ID '%d' was found.", scriptId));
        }
        return script;
    }

    private String buildKey(String folderPath, String name) {
        return folderPath + "|" + name;
    }
}
