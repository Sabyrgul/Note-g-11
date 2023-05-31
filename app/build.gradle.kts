plugins {
    id(Plugins.APG.application)
    id(Plugins.Kotlin.kotlin)
    id(Plugins.Kotlin.kotlinKapt)
    id(Plugins.hilt)
}

android {
    namespace = "com.geektech.note_g_11"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.geektech.note_g_11"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
    }

    kapt {
        correctErrorTypes = true
    }

}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraint)
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUI)
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.core)

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)

    //Hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    //Coroutine
    implementation(Dependencies.Coroutine.core)

    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.fragment)

}