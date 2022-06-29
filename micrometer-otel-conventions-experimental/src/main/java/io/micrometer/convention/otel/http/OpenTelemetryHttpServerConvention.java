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
package io.micrometer.convention.otel.http;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.transport.http.*;
import io.micrometer.observation.transport.http.context.HttpServerContext;
import io.micrometer.observation.transport.http.tags.HttpServerKeyValuesConvention;

/**
 * Conventions for HTTP key values implemented with OpenTelemetry.
 *
 * @author Marcin Grzejszczak
 * @since 1.10.0
 */
// TODO: What to do if request is not set? UNKNOWN?
public class OpenTelemetryHttpServerConvention  extends OpenTelemetryHttpConvention<HttpServerRequest, HttpServerResponse, HttpServerContext>
        implements HttpServerKeyValuesConvention {

    @Override
    public KeyValue serverName(HttpRequest request) {
        return OpenTelemetryHttpServerLowCardinalityKeyNames.SERVER_NAME.of("UNKNOWN");
    }

    @Override
    public KeyValue route(HttpRequest request) {
        return OpenTelemetryHttpServerLowCardinalityKeyNames.ROUTE.of("UNKNOWN");
    }

    @Override
    public KeyValue templatedRoute(HttpRequest request) {
        return OpenTelemetryHttpServerLowCardinalityKeyNames.TEMPLATED_ROUTE.of("UNKNOWN");
    }

    @Override
    public KeyValue clientIp(HttpRequest request) {
        return OpenTelemetryHttpServerLowCardinalityKeyNames.CLIENT_IP.of("UNKNOWN");
    }

    @Override
    public String getName() {
        return "http.server.duration";
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return context instanceof HttpServerContext;
    }
}
