object Libs {
    //Android
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycle = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleRT = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"

    //Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //KTX
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    //other
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}
