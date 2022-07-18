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
import io.micrometer.common.KeyValues;
import io.micrometer.convention.HttpClientKeyValuesConvention;
import io.micrometer.observation.Observation;
import io.micrometer.observation.transport.RequestReplySenderContext;

/**
 * Conventions for HTTP key values implemented with OpenTelemetry.
 *
 * @author Marcin Grzejszczak
 * @since 1.0.0
 */
// TODO: What to do if request is not set? UNKNOWN?
public abstract class OpenTelemetryHttpClientConventions<REQ, RES>
        extends OpenTelemetryHttpConvention<REQ, RES, RequestReplySenderContext<REQ, RES>>
        implements HttpClientKeyValuesConvention<REQ, RES> {

    @Override
    public KeyValue peerName(REQ request) {
        return OpenTelemetryHttpClientLowCardinalityKeyNames.PEER_NAME.of("UNKNOWN");
    }

    @Override
    public String getName() {
        return "http.client.duration";
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return context instanceof RequestReplySenderContext;
    }

    @Override
    public KeyValues getLowCardinalityKeyValues(RequestReplySenderContext context) {
        return all((REQ) context.getCarrier(), (RES) context.getResponse());
    }

}
