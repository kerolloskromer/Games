plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(ConfigData.compileSdkVersion)
    buildToolsVersion(ConfigData.buildToolsVersion)

    defaultConfig {
        applicationId = "com.kromer.games"
        minSdkVersion(ConfigData.minSdkVersion)
        targetSdkVersion(ConfigData.targetSdkVersion)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://api.rawg.io/api/\"")
        buildConfigField("String", "API_KEY", "\"d05720313e1a4ee1892a1ced9961b459\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Kotlin
    implementation(Deps.kotlin)

    // UI
    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.recyclerView)
    implementation(Deps.constraintLayout)
    implementation(Deps.fragment)
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUI)

    // LifeCycle
    implementation(Deps.lifecycleExtensions)
    implementation(Deps.viewModel)
    implementation(Deps.liveData)
    implementation(Deps.lifecycleRuntime)

    // Retrofit
    implementation(Deps.retrofit)
    implementation(Deps.converterGson)
    implementation(Deps.loggingInterceptor)

    // Room
    implementation(Deps.roomRuntime)
    kapt(Deps.roomCompiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(Deps.roomKtx)

    // Dagger-Hilt
    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)

    // Timber for logging
    implementation(Deps.timber)

    // Leak Canary - memory leak detection
    debugImplementation(Deps.leakcanary)

    // UNIT TEST
    testImplementation(Deps.junit)
    testImplementation(Deps.mockito)

    // UI TEST
    androidTestImplementation(Deps.androidJunit)
    androidTestImplementation(Deps.espresso)
}