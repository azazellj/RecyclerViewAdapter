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
}

dependencies {
    implementation(LibraryDependency.RECYCLER_VIEW)
}

apply(from = "https://raw.githubusercontent.com/Commit451/gradle-android-javadocs/1.0.0/gradle-android-javadocs.gradle")