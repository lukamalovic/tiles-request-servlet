/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.github.weblegacy.tiles.request.servlet.extractor;

import java.util.Enumeration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.tiles.request.attribute.EnumeratedValuesExtractor;

/**
 * Extract header values from an HTTP request.
 * <p>Copied from Apache tiles-request-servlet 1.0.7 and adapted for Jakarta EE 9 </p>
 *
 * @version $Rev$ $Date$
 */
public class HeaderExtractor implements EnumeratedValuesExtractor {

    /**
     * The request.
     */
    private HttpServletRequest request;

    /**
     * The response.
     */
    private HttpServletResponse response;

    /**
     * Constructor.
     *
     * @param request The request.
     * @param response The response.
     */
    public HeaderExtractor(HttpServletRequest request,
            HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public Enumeration<String> getKeys() {
        return request.getHeaderNames();
   }

    @Override
    public String getValue(String key) {
        return request.getHeader(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Enumeration<String> getValues(String key) {
        return request.getHeaders(key);
    }

    @Override
    public void setValue(String key, String value) {
        response.setHeader(key, value);
    }
}