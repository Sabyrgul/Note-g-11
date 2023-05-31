// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Plugins.APG.application) version Versions.application apply false
    id (Plugins.APG.library) version Versions.library apply false
    id (Plugins.Kotlin.kotlin) version Versions.kotlinAndroid apply false
    id(Plugins.hilt) version Versions.hilt apply false
    id (Plugins.Kotlin.kotlinJvm) version Versions.kotlinJvm apply false
}