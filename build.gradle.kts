buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(GradleDependency.ANDROID_GRADLE)
        classpath(GradleDependency.KOTLIN)
        classpath(GradleDependency.ANDROID_MAVEN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}