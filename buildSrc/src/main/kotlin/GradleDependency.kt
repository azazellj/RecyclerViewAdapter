object GradlePluginVersion {
    const val ANDROID_GRADLE = "3.5.0"
    const val ANDROID_MAVEN = "2.1"
}

object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_MAVEN = "com.github.dcendents.android-maven"
    const val ANDROID_KOTLIN = "kotlin-android"
    const val ANDROID_KOTLIN_KAPT = "kotlin-kapt"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val GRADLE_VERSION_PLUGIN = "com.github.ben-manes.versions"
}

object GradleDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${CoreVersion.KOTLIN}"
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID_GRADLE}"
    const val ANDROID_MAVEN = "com.github.dcendents:android-maven-gradle-plugin:${GradlePluginVersion.ANDROID_MAVEN}"
}
