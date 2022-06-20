/**
 * Copyright 2022 VMware, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.convention.http.tag;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.transport.http.HttpRequest;
import io.micrometer.observation.transport.http.tags.HttpClientKeyValuesConvention;

/**
 * Conventions for HTTP key values implemented with OpenTelemetry.
 *
 * @author Marcin Grzejszczak
 * @since 1.10.0
 */
// TODO: What to do if request is not set? UNKNOWN?
public class OpenTelemetryHttpClientKeyValuesConvention extends OpenTelemetryHttpKeyValuesConvention
        implements HttpClientKeyValuesConvention {

    @Override
    public KeyValue peerName(HttpRequest request) {
        return OpenTelemetryHttpClientLowCardinalityKeyNames.PEER_NAME.of("UNKNOWN");
    }

}
