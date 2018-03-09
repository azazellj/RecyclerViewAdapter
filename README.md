# RecyclerViewAdapter
This library is used for adding simply core of `RecyclerView.Adapter`.
You just need to implement already created classes.  

There are such available classes now:
* BaseAdapter - base adapter class with base methods.
* AdapterViewHolder - base holder class.
* BindingViewHolder - holder with binding support.
* ButterKnifeViewHolder - holder with ButterKnife support.

# Downloads
You need to add this `jitpack` repository to the main app module.
```
repositories {
       maven { url "https://jitpack.io" }
}
```

Than you should choose that dependencies that you need.
Current las t version is `0.4.1`

```groovy
dependencies {
    implementation 'com.github.Azazellj:adapter-binding-kt:${lastVersion}'        // databinding + kotlin
    implementation 'com.github.Azazellj:adapter-binding:${lastVersion}'           // databinging only
    implementation 'com.github.Azazellj:adapter-butterknife-kt:${lastVersion}'    // butterknife + kotlin
    implementation 'com.github.Azazellj:adapter-butterknife:${lastVersion}'       // butterknife only
    implementation 'com.github.Azazellj:adapter-kt:${lastVersion}'                // only adapter and holder + kotlin
    implementation 'com.github.Azazellj:adapter:${lastVersion}'                   // only adapter and holder
}
```