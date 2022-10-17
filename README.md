### Issue
* A module contains `proto` files emits the following error when it's compiled with
  `line-gradle-scripts` grpc preset.
  ```bash
  $ ./gradlew clean :protocol:build

  Type-safe dependency accessors is an incubating feature.
  > Task :protocol:sourcesJar FAILED

  FAILURE: Build failed with an exception.

  * What went wrong:
  Execution failed for task ':protocol:sourcesJar'.
  > Entry com/example/foo/FooOuterClass.java is a duplicate but no duplicate handling strategy has been set. Please refer to https://docs.gradle.org/7.4/dsl/org.gradle.api.tasks.Copy.html#org.gradle.api.tasks.Copy:duplicatesStrategy for details.
  ```

### Cause
* Files under `gen-src/main/java` gets registered twice as `sourceSet` once by `line-gradle-scripts` at [java.gradle:L58](https://github.com/line/gradle-scripts/blob/master/lib/java.gradle#L58)
  and again by `protobuf-gradle-plugin`.

### Workaround
1. Comment out [java.gradle:L58](https://github.com/line/gradle-scripts/blob/master/lib/java.gradle#L58)
2. Define `Jar` task duplicatesStrategy as follows:
   ```kotlin
   tasks.withType<Jar> {
       duplicatesStrategy = DuplicatesStrategy.INCLUDE
   }
   ```
