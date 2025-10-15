/**
 Copyright © 2023 Open Text Corporation

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
package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common;


public class Common {

    public static String integerToString(int value) {
        if (value > 0)
            return Integer.toString(value);
        else
            return null;
    }

    public static int stringToInteger(String value) {
        if (value != null && !value.isEmpty())
            return Integer.parseInt(value);
        else
            return 0;
    }

    public static String floatToString(float value) {
        if (value > 0)
            return Float.toString(value);
        else
            return null;
    }
}
