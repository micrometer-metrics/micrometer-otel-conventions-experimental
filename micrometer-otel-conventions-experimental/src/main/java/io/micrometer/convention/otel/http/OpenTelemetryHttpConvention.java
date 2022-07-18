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
import io.micrometer.convention.HttpKeyValuesConvention;
import io.micrometer.conventions.common.AttributeType;
import io.micrometer.observation.Observation;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Conventions for HTTP key values implemented with OpenTelemetry.
 *
 * @author Marcin Grzejszczak
 * @since 1.0.0
 */
// TODO: What to do if request is not set? UNKNOWN?
abstract class OpenTelemetryHttpConvention<REQ, RES, CONTEXT extends Observation.Context>
        implements HttpKeyValuesConvention<REQ, RES>, Observation.ObservationConvention<CONTEXT> {

    // TODO: This is just an example
    private static final Predicate<Object> METHOD_PREDICATE = s -> isTypeCorrect(
            io.micrometer.conventions.semantic.SemanticAttributes.HTTP_METHOD.getType(), s)
            && Stream.of("GET", "POST", "PATCH", "HEAD", "DELETE", "PUT")
                    .anyMatch(method -> method.equalsIgnoreCase(((String) s)));

    @Override
    public KeyValue method(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.METHOD.of(methodValue(request), METHOD_PREDICATE);
    }

    protected abstract String methodValue(REQ request);

    @Override
    public KeyValue url(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.URL.of("UNKNOWN");
    }

    @Override
    public KeyValue target(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.TARGET.of("UNKNOWN");
    }

    @Override
    public KeyValue host(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.HOST.of("UNKNOWN");
    }

    @Override
    public KeyValue scheme(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.SCHEME.of("UNKNOWN");
    }

    @Override
    public KeyValue statusCode(RES response) {
        return OpenTelemetryHttpLowCardinalityKeyNames.STATUS_CODE.of("UNKNOWN");
    }

    @Override
    public KeyValue flavor(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.FLAVOR.of("UNKNOWN");
    }

    @Override
    public KeyValue userAgent(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.USER_AGENT.of("UNKNOWN");
    }

    @Override
    public KeyValue requestContentLength(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.REQUEST_CONTENT_LENGTH.of("UNKNOWN");
    }

    @Override
    public KeyValue responseContentLength(RES response) {
        return OpenTelemetryHttpLowCardinalityKeyNames.RESPONSE_CONTENT_LENGTH.of("UNKNOWN");
    }

    @Override
    public KeyValue ip(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.IP.of("UNKNOWN");
    }

    @Override
    public KeyValue port(REQ request) {
        return OpenTelemetryHttpLowCardinalityKeyNames.PORT.of("UNKNOWN");
    }

    static boolean isTypeCorrect(AttributeType type, Object value) {
        switch (type) {
        case STRING:
            return value instanceof String;
        case BOOLEAN:
            return value instanceof Boolean;
        case LONG:
            return value instanceof Long;
        case DOUBLE:
            return value instanceof Double;
        case STRING_ARRAY:
        case BOOLEAN_ARRAY:
        case LONG_ARRAY:
        case DOUBLE_ARRAY:
        default:
            throw new UnsupportedOperationException("TODO");
        }
    }

}
