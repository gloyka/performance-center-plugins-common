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
package com.microfocus.adm.performancecenter.plugins.common.rest;

/**
 *
 * @author Amir Zahavi
 *
 */
public interface RESTConstants {

    // HttpHeaders
    String PtaL = "PtAL";
    String PvaL = "PvAL";
    String CONTENT_TYPE = "Content-Type";
    String SET_COOKIE = "Set-Cookie";
    String ACCEPT = "Accept";
    String AUTHORIZATION = "Authorization";
    String APP_XML = "application/xml";
    String TEXT_PLAIN = "text/plain";
    String APP_XML_BULK = "application/xml;type=collection";

    String REST_PROTOCOL = "rest";

    String GET = "GET";
    String POST = "POST";
    String PUT = "PUT";
    String COOKIE = "Cookie";
}
