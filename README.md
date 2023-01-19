# Ktor HttpRequestRetry issue example
A barebone project to reproduce `io.ktor.client.plugins.HttpTimeout` plugin issue when used in parallel with
`io.ktor.client.plugins.HttpRequestRetry`

## How to build and run

### Local

```bash
gradle installDist
```
```bash
./build/install/ktor-retry-plugin-issue-example/bin/ktor-retry-plugin-issue-example
```

### Docker
```bash
docker build -t example .
```
```bash
docker run example
```

## Issue
The `connectTimeoutMillis` is not respected and the `HttpRequestRetry` plugin starts retrying requests. 
In addition, if the `HttpTimeout` plugin is installed after `HttpRequestRetry` the `requestTimeoutMillis` is not
respected as well.
