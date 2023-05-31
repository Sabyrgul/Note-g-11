plugins {
    id(Plugins.javaLibrary)
    id(Plugins.Kotlin.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

    implementation(Dependencies.javax)

    implementation(Dependencies.Coroutine.core)
}