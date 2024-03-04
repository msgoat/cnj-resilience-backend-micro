# Changelog
All notable changes to `cnj-resilience-backend-micro` will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [3.1.0] - 2024-03-04
### Added
- commit-stage builds produce Docker images for linux/amd64 and linux/arm64/v8 platforms now
- added JSON-B configuration class
- Tagging of git branch
### Changed
- upgraded Payara to version 6.2024.2
- simplified POM
- consolidated common dependencies
- consolidated common cloudtrain dependencies
- upgraded Java to version 21
- upgraded Maven plugins and dependencies
- consolidated POM with other showcases
- consolidated system tests with other showcases
- Docker images use Generational Z garbage collector by default
- Upgraded to helm-maven-plugin version 5.0.0
- Now a helm chart is packaged and pushed as an artifact during the commit-stage build
- Now the helm chart is pulled before deploying during the integration-test-stage build
- removed dependency on cnj-common-test-jakarta by switching to model based system tests
- added missing dependency on assertj for testing
- upgraded Payara version to 6.2023.10
- consolidated dependencies
### Fixed
- improved test coverage measurement with Jacoco to include all coverage data in reports
- log messages of test runs are displayed correctly now after upgrade to SLF4J 2.0.9 and using ServiceLoader for log provider lookup
- application logs are actually written to console after (re-)adding dependency slf4j-jdk14

## [3.0.0] - 2023-06-11
### Changed
- moved to new AWS CodeBuild pipeline
- moved to new AWS EKS cluster
- upgraded everything

## [2.0.0] - 2023-02-23
### Changed
- upgraded to Java 17
- consolidated with cnj-hello use case

## [1.0.1] - 2022-09-09
### Fixed
- added JSON logging

## [1.0.0] - 2022-09-02
### Added
### Changed
- first re-release after repository split
