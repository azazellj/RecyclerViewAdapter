private object LibraryVersion {
    const val APP_COMPACT       = "1.0.2"
    const val RECYCLER_VIEW     = "1.0.0"
    const val BUTTERKNIFE       = "10.1.0"
    const val GLIDE             = "4.9.0"
    const val ANNOTATION        = "1.1.0"
}

object LibraryDependency {
    const val DATA_BINDING_COMPILER = "androidx.databinding:databinding-compiler:${GradlePluginVersion.ANDROID_GRADLE}"
    const val KOTLIN                = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersion.KOTLIN}"
    const val APP_COMPACT           = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPACT}"
    const val RECYCLER_VIEW         = "androidx.recyclerview:recyclerview:${LibraryVersion.RECYCLER_VIEW}"
    const val BUTTERKNIFE           = "com.jakewharton:butterknife:${LibraryVersion.BUTTERKNIFE}"
    const val BUTTERKNIFE_COMPILER  = "com.jakewharton:butterknife-compiler:${LibraryVersion.BUTTERKNIFE}"
    const val GLIDE                 = "com.github.bumptech.glide:glide:${LibraryVersion.GLIDE}"
    const val GLIDE_COMPILER        = "com.github.bumptech.glide:compiler:${LibraryVersion.GLIDE}"
    const val ANNOTATION            = "androidx.annotation:annotation:${LibraryVersion.ANNOTATION}"
}
