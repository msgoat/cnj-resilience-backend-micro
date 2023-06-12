# cnj-resilience-backend-micro

Simple cloud native java application based on Eclipse Microprofile demonstrating the application of resilience patterns
with [MicroProfile Fault Tolerance](https://github.com/eclipse/microprofile-fault-tolerance) when calls to downstream services are failing.

## Status

![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoibkRGVDR3MWtiZ3hwRWg2YmExM2wrRVBwUkNoVzJVZ01MVFJMeFI4SWd3UWcxUktvWTJzRTlKWWVsSHF5MHJwK1VBRlZzcFZncVl5d3poM3hLcHhPUW4wPSIsIml2UGFyYW1ldGVyU3BlYyI6ImhQT0huZDdOTzhSNDZldDMiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=mains)

## Release information

Check [changelog](changelog.md) for latest version and release information.

## Synopsis

The [WelcomeResource] (src/main/java/group/msg/at/cloud/cloudtrain/adapter/rest/in/WelcomeResource.java) returns
[WelcomeItems](src/main/java/group/msg/at/cloud/cloudtrain/core/entity/WelcomeItems.java)
for a given user.

Each `WelcomeItem` is made of domain objects retrieved via downstream services:

* [cnj-resilience-downstream-a](https://github.com/msgoat/cnj-resilience-downstream-a/blob/main/README.md) returns a list of `RecommendedItem`s representing recommended movies or TV series.
* [cnj-resilience-downstream-b](https://github.com/msgoat/cnj-resilience-downstream-b/blob/main/README.md) returns a list of `WatchedItem`s representing watched movies or TV series.

The applied resilience patterns make sure that this service stays at least partially functional even
if any the downstream services shows abnormal behaviour.

The application itself offers two REST endpoints:

* GET on `/api/v1/welcome/{userId}` is not resilient and will fail if any of the downstream services breaks.
* GET on `/api/v1/resilient/welcome/{userId}` is resilient and will keep on working even if any of the downstream services breaks.

## HOW-TO build this application locally

If all prerequisites are met, just run the following Maven command in the project folder:

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing the showcase application.

## HOW-TO run this showcase locally

In order to run the whole showcase locally, just run the following docker commands in the project folder:

```shell 
docker compose up -d
docker compose logs -f 
```
The showcase application will be accessible via `http://localhost:38080`.

The downstream recommendation service will be accessible via `http://localhost:31080`.

The downstream watchlist service will be accessible via `http://localhost:32080`.

Press `Ctlr+c` to stop tailing the container logs and run the following docker command to stop the show case:

```shell 
docker compose down
```
