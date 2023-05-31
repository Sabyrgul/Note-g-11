object Dependencies {

    object UI {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
        const val lifecycleLivedata =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedata}"
        const val lifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Coroutine {
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    }

    object Lifecycle {
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    }

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    const val jUnit = "junit:junit:${Versions.jUnit}"

    object Test {
        const val jUnit = "androidx.test.ext:junit:${Versions.testJUnit}"
        const val core = "androidx.test.espresso:espresso-core:${Versions.testCore}"
    }

    // const val kotlin_bom=platform "org.jetbrains.kotlin:kotlin-bom:1.8.0"

    const val javax = "javax.inject:javax.inject:1"

}