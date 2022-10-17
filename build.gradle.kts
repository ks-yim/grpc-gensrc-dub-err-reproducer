plugins {
    java
    idea
    eclipse

    // line-gradle-scripts pre-requisites
    id("com.google.osdetector") version "1.6.2" apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0" apply false
    id("com.google.protobuf") version "0.9.1" apply false
}

rootProject.apply {
    from("gradle/scripts/build-flags.gradle")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

val projectsWithFlags: org.codehaus.groovy.runtime.CurriedClosure<Iterable<Project>> by extra
