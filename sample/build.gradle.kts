import com.android.build.gradle.AppExtension

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_KOTLIN)
    id(GradlePluginId.ANDROID_KOTLIN_KAPT)
}

configure<AppExtension> {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = "com.azazellj.baservadapter"
        setMinSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        setTargetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(ModuleDependency.ADAPTER))
    implementation(project(ModuleDependency.ADAPTER_KT))
    implementation(project(ModuleDependency.ADAPTER_COMMON))
    implementation(project(ModuleDependency.ADAPTER_BINDING))
    implementation(project(ModuleDependency.ADAPTER_BINDING_KT))
    implementation(project(ModuleDependency.ADAPTER_BUTTERKNIFE))
    implementation(project(ModuleDependency.ADAPTER_BUTTERKNIFE_KT))
    implementation(LibraryDependency.APP_COMPACT)
    implementation(LibraryDependency.RECYCLER_VIEW)
    implementation(LibraryDependency.GLIDE)
    implementation(LibraryDependency.KOTLIN)
    kapt(LibraryDependency.GLIDE_COMPILER)

    androidTestImplementation(TestLibraryDependency.TEST_RUNNER)
    androidTestImplementation(TestLibraryDependency.TEST_EXT)
}
