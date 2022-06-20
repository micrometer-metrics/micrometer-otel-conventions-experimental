# Micrometer OTel conventions

[![Build Status](https://circleci.com/gh/micrometer-metrics/micrometer-otel-conventions-experimental.svg?style=shield)](https://circleci.com/gh/micrometer-metrics/micrometer-otel-conventions-experimental)
[![Apache 2.0](https://img.shields.io/github/license/micrometer-metrics/micrometer-otel-conventions-experimental.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/io.micrometer/micrometer-otel-conventions-experimental.svg)](https://search.maven.org/artifact/io.micrometer/micrometer-otel-conventions-experimental)
[![Javadocs](https://www.javadoc.io/badge/io.micrometer/micrometer-otel-conventions-experimental.svg)](https://www.javadoc.io/doc/io.micrometer/micrometer-otel-conventions-experimental)
[![Revved up by Gradle Enterprise](https://img.shields.io/badge/Revved%20up%20by-Gradle%20Enterprise-06A0CE?logo=Gradle&labelColor=02303A)](https://ge.micrometer.io/)

Implementation of Micrometer Conventions with OpenTelemetry.

## Join the discussion

Join the [Micrometer Slack](https://slack.micrometer.io) to share your questions, concerns, and feature requests.

## Snapshot builds

Snapshots are published to `repo.spring.io` for every successful build on the `main` branch and maintenance branches.

To use:

```groovy
repositories {
    maven { url 'https://repo.spring.io/libs-snapshot' }
}

dependencies {
    implementation 'io.micrometer:micrometer-otel-conventions:latest.integration'
}
```

## Milestone releases

Milestone releases are published to https://repo.spring.io/milestone. Include that as a maven repository in your build configuration to use milestone releases. Note that milestone
releases are for testing purposes and are not intended for production use.

## Contributing

See our [Contributing Guide](CONTRIBUTING.md) for information about contributing to Micrometer Docs Generator.

-------------------------------------
_Licensed under [Apache Software License 2.0](https://www.apache.org/licenses/LICENSE-2.0)_

_Sponsored by [VMware](https://tanzu.vmware.com)_
