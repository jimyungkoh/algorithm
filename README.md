# algorithm monorepo

This repository contains two algorithm practice projects.

## Structure

- `java`: Java + Gradle + JUnit 5
- `javascript`: JavaScript + Jest

## Java tests

```bash
cd java
bash ./gradlew test
```

## JavaScript tests

```bash
cd javascript
npm install
npm test
```

## IntelliJ IDEA setup (monorepo)

1. Open the repository root (`algorithm`) as a project.
2. Ensure the Gradle project at `java/` is loaded (wrapper based).
3. Open `javascript/package.json` and run `Install` once to prepare Node dependencies.
4. Use the IDE test runners:
   - Java: run Gradle/JUnit tests from `java/src/test/...`
   - JavaScript: run Jest tests from `javascript/__tests__/...`
