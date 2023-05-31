plugins {
    id(Plugins.APG.library)
    id(Plugins.Kotlin.kotlin)
    id(Plugins.Kotlin.kotlinKapt)
}

android {
    namespace = "com.geektech.note_g_11"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(Dependencies.UI.core)

    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)

    implementation(Dependencies.Coroutine.android)

    implementation(Dependencies.javax)

    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.core)
}