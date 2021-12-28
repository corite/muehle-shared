# muehle-shared [![Java CI with Gradle](https://github.com/corite/muehle-client/actions/workflows/build.yml/badge.svg)](https://github.com/corite/muehle-client/actions/workflows/build.yml)
Repository containing classes that can be used in both the client- and the serverside application. 
## Usage
### Integration
To use this project as a dependency, you have to add jitpack as in the `repositories` section in your `build.gradle`:
```groovy
    maven { url 'https://jitpack.io' }
```

Then, put this line under `dependencies`:
```groovy
    implementation 'com.github.corite:muehle-shared:main-SNAPSHOT'
```
The version has to be a valid tag from the repository, a commit-hash or `<branch>-SNAPSHOT`, where `<branch>` has to be replaced by the desired branch to get the snapshot from.
### Environment Variables
- `logLevel`: specifies a log-level for Logback (p.e. `INFO`, `WARN` )
