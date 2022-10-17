rootProject.name = "gradle-scripts-grpc"

apply {
    from("${rootDir}/gradle/scripts/settings-flags.gradle")
}

val includeWithFlags: org.codehaus.groovy.runtime.MethodClosure by extra

includeWithFlags(":protocol", "java", "kotlin-grpc")
