plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(ProjectProperties.compileSdk)
//    buildToolsVersion(ProjectProperties.buildTools)

    defaultConfig {
        applicationId = ProjectProperties.applicationId
        minSdkVersion(ProjectProperties.minSdk)
        targetSdkVersion(ProjectProperties.targetSdk)
        versionCode = ProjectProperties.versionCode
        versionName = ProjectProperties.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // 配置签名
    signingConfigs {
        getByName("debug") {
            storeFile = file(Signing.StoreFile)
            storePassword = Signing.StorePassword
            keyAlias = Signing.KeyAlias
            keyPassword = Signing.KeyPassword
        }
        register("release") {
            storeFile = file(Signing.StoreFile)
            storePassword = Signing.StorePassword
            keyAlias = Signing.KeyAlias
            keyPassword = Signing.KeyPassword
        }
    }

    // 编译类型
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    // 输出文件名称
    android.applicationVariants.all {
        val buildType = this.buildType.name
        outputs.all {
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                if (buildType == "debug") {
                    this.outputFileName = "app_V${defaultConfig.versionName}_${buildType}.apk"
                } else if (buildType == "release") {
                    this.outputFileName =
                        "app_V${defaultConfig.versionName}_${buildType}_${Deloy.getSystemTime()}.apk"
                }
            }
        }
    }

    // 部署资源文件
    fun listSubFile(): ArrayList<String> {
        // 新资源目录
        val resFolder = "src/main/res/layouts"
        // 新资源目录下的文件夹
        val files = file(resFolder).listFiles()
        val folders = ArrayList<String>()
        // 遍历路径
        files?.let {
            it.forEach { file ->
                folders.add(file.absolutePath)
            }
        }
        // 资源整合
        folders.add(file(resFolder).parentFile.absolutePath)
        return folders
    }

    // 资源重定向
    sourceSets {
        getByName("main") {
            res.srcDirs(listSubFile())
        }
    }

    // 指定JDK
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // 开启ViewBinding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Android
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.appCompat)
    implementation(Libs.constraintlayout)
    implementation(Libs.viewmodel)
    implementation(Libs.livedata)
    implementation(Libs.lifecycle)
    implementation(Libs.lifecycleRT)
    implementation(Libs.material)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExt)
    androidTestImplementation(Libs.espresso)

    // Kotlin
    implementation(Libs.kotlinStdLib)
    implementation(Libs.coreKtx)
    implementation(Libs.coroutines)
    implementation(Libs.coroutinesTest)
    implementation(Libs.coroutinesAndroid)

    //KTX
    implementation(Libs.activityKtx)
    implementation(Libs.fragmentKtx)

    // Network
    implementation(Libs.gson)
    implementation(Libs.retrofit)
    implementation(Libs.moshi)
    implementation(Libs.converterMoshi)
    kapt(Libs.moshiCodeGen)

    // Image
    implementation(Libs.glide)
    kapt(Libs.glideCompiler)
}