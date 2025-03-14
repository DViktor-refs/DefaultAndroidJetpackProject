plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "1.5.31"
}

android {
    namespace = "com.example.demo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.demo"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation(libs.okhttp)

    //Coil
    implementation(libs.coil.compose)

    //koin
    implementation (libs.insert.koin.koin.android)
    implementation (libs.insert.koin.koin.androidx.compose)

    //ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.compose)  // ViewModel utilities for Compose
    implementation (libs.androidx.lifecycle.livedata.ktx)  // LiveData
    implementation (libs.androidx.lifecycle.runtime.ktx)  // Lifecycles only (without ViewModel or LiveData)
    implementation (libs.androidx.lifecycle.runtime.compose)  // Lifecycle utilities for Compose
    implementation (libs.androidx.lifecycle.viewmodel.savedstate)  // Saved state module for ViewModel
    implementation (libs.androidx.lifecycle.service)  // optional - helpers for implementing LifecycleOwner in a Service
    implementation (libs.androidx.lifecycle.process)  // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation (libs.androidx.lifecycle.reactivestreams.ktx)  // optional - ReactiveStreams support for LiveData

    //Serialization
    implementation(libs.kotlinx.serialization.json)

    // ----------------- Test Implementations ------------------------------ //
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    //Viewmodel
    testImplementation (libs.androidx.core.testing)  // optional - Test helpers for LiveData
    testImplementation (libs.androidx.lifecycle.runtime.testing)   // optional - Test helpers for Lifecycle runtime

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}