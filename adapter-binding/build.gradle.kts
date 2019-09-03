import com.android.build.gradle.LibraryExtension

group = "com.github.Azazellj"

plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_MAVEN)
}

configure<LibraryExtension> {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(ModuleDependency.ADAPTER))

    implementation(LibraryDependency.RECYCLER_VIEW)
    implementation(LibraryDependency.APP_COMPACT)
}

apply(from = "https://raw.githubusercontent.com/Commit451/gradle-android-javadocs/1.0.0/gradle-android-javadocs.gradle")