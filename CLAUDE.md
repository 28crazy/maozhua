# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A WeChat mini-program backend (猫抓/maozhua) — multi-module Spring Boot 2.7.18 project using Java 11 + Maven. Follows a layered (DDD-inspired) architecture.

## Architecture (5 Modules)

The dependency chain is: `common` → `domain` → `infra` + `api` → `app`

| Module | Purpose | Key Dependencies |
|--------|---------|-----------------|
| `common` | Shared utilities (PageInfo, base types) | none |
| `domain` | Domain models (DailyModel) & repository interfaces | common |
| `api` | Service interfaces (DailyService), DTOs (DailyDto) | common, domain, infra |
| `infra` | Persistence adapters (DailyRepositoryImpl), MySQL via JDBC | domain, common |
| `app` | Composition root: entry point, controllers, views, response types | api, infra, common |

- **Entry point**: `AppApplication.main()` in `app` module, scans `com.maozhua.mz` package
- **Controller layer**: `app` module holds `@RestController` classes, request/response views
- **Service layer**: Interfaces in `api`, implementations in `api/service/impl`
- **Repository layer**: Interfaces in `domain/repository`, implementations in `infra/repository`
- **No JPA** — uses `spring-boot-starter-jdbc` + MySQL connector directly
- **DataSource auto-config excluded** — database config must be provided externally

## Current State

Early-stage scaffold. Most service/repo methods return null stubs. `DailyRequest` references a `DailyInfo` class that does not yet exist.

## Build Commands

```bash
# Build entire project (from repo root)
mvn -s settings.xml -B clean package -DskipTests

# Build a single module
mvn -s settings.xml -pl common -am clean package -DskipTests

# Run tests for entire project
mvn -s settings.xml test

# Run tests for a specific module
mvn -s settings.xml -pl common test

# Run a single test class
mvn -s settings.xml -pl common test -Dtest=CommonApplicationTests

# Run app locally
mvn -s settings.xml -pl app spring-boot:run

# Docker build (from repo root)
docker build -t maozhua .

# Run Docker container
docker run -p 80:80 maozhua
```

Uses Tencent Maven mirror (`settings.xml`). Maven wrapper is not included.

## Key Patterns

- **Response wrapper**: All API responses use `BaseResponse<T>` with `ErrorConst` codes (`SUCCESS(200)`, `ERROR(500)`)
- **Pagination**: `PageInfo<T>` with `of(pageNo, pageSize, total, list)` factory and `defaultPageInfo()` defaults
- **Auto-wired**: Field injection with `@Autowired`
- **View/DTO separation**: `app/view` (presentation layer) vs `api/dto` (service DTOs) vs `domain` (domain models)
