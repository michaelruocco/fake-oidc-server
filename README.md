# Fake OIDC Server

[![Build](https://github.com/michaelruocco/fake-oidc-server/workflows/pipeline/badge.svg)](https://github.com/michaelruocco/fake-oidc-server/actions)
[![codecov](https://codecov.io/gh/michaelruocco/fake-oidc-server/branch/master/graph/badge.svg?token=FWDNP534O7)](https://codecov.io/gh/michaelruocco/fake-oidc-server)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/272889cf707b4dcb90bf451392530794)](https://www.codacy.com/gh/michaelruocco/fake-oidc-server/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/fake-oidc-server&amp;utm_campaign=Badge_Grade)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/fake-oidc-server?branch=master)](https://bettercodehub.com/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_fake-oidc-server&metric=alert_status)](https://sonarcloud.io/dashboard?id=michaelruocco_fake-oidc-server)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_fake-oidc-server&metric=sqale_index)](https://sonarcloud.io/dashboard?id=michaelruocco_fake-oidc-server)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_fake-oidc-server&metric=coverage)](https://sonarcloud.io/dashboard?id=michaelruocco_fake-oidc-server)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_fake-oidc-server&metric=ncloc)](https://sonarcloud.io/dashboard?id=michaelruocco_fake-oidc-server)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.michaelruocco/fake-oidc-server.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.michaelruocco%22%20AND%20a:%22fake-oidc-server%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Overview

This repo will contain a fake OIDC server for use when testing applications that use OIDC for
security.

## Useful Commands

```gradle
// cleans build directories
// prints currentVersion
// formats code
// builds code
// runs tests
// checks for gradle issues
// checks dependency versions
./gradlew clean currentVersion dependencyUpdates lintGradle spotlessApply build
```