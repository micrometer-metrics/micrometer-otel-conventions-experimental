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
package io.micrometer.convention.otel;

import io.micrometer.convention.otel.http.OpenTelemetryHttpClientConventions;
import io.micrometer.convention.otel.http.OpenTelemetryHttpServerConvention;
import io.micrometer.observation.Observation;

import java.util.Arrays;
import java.util.Collection;

/**
 * Conventions for HTTP key values implemented with OpenTelemetry.
 *
 * @author Marcin Grzejszczak
 * @since 1.0.0
 */
public final class OpenTelemetryConventions {

    /**
     * Provides all HTTP related conventions.
     * @return collection of HTTP conventions
     */
    public static Collection<Observation.ObservationConvention<?>> http(OpenTelemetryHttpClientConventions<?, ?> client,
            OpenTelemetryHttpServerConvention<?, ?> server) {
        return Arrays.asList(client, server);
    }

    /**
     * Provides all OTel conventions.
     * @return all OTel conventions
     */
    public static Collection<Observation.ObservationConvention<?>> all(OpenTelemetryHttpClientConventions<?, ?> client,
            OpenTelemetryHttpServerConvention<?, ?> server) {
        return http(client, server);
    }

}
