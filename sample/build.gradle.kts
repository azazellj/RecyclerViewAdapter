import com.android.build.gradle.AppExtension

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
}

configure<AppExtension> {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = "com.azazellj.baservadapter"
        setMinSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        setTargetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        multiDexEnabled = true
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
    implementation(project(ModuleDependency.ADAPTER_BINDING))
    implementation(project(ModuleDependency.ADAPTER_BINDING_KT))
    implementation(project(ModuleDependency.ADAPTER_BUTTERKNIFE))
    implementation(project(ModuleDependency.ADAPTER_BUTTERKNIFE_KT))
    implementation(LibraryDependency.APP_COMPACT)
    implementation(LibraryDependency.RECYCLER_VIEW)
    implementation(LibraryDependency.GLIDE)
    annotationProcessor(LibraryDependency.GLIDE_COMPILER)
}
