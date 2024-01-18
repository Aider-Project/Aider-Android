@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.aider.android.application)
    alias(libs.plugins.aider.android.hilt)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.one.aider"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.one.aider"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(projects.feature.calendar)
    implementation(projects.feature.lecture)
    implementation(projects.feature.assignment)
    implementation(projects.feature.messenger)
    implementation(projects.feature.setting)
    implementation(projects.core.commonUi)
    implementation(projects.core.common)

    implementation(libs.bundles.navigation)
    implementation(libs.bundles.ktx)
    implementation(libs.bundles.flowbinding)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}