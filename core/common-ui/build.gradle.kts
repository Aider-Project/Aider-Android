@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.aider.android.library)
    alias(libs.plugins.aider.android.hilt)
}

android {
    namespace = "com.one.core.common_ui"
}

dependencies {
    api(projects.core.model)
    implementation(projects.core.common)

    // navigation
    implementation(libs.bundles.navigation)
    // FlowBinding
    implementation(libs.bundles.flowbinding)
    // ConstraintLayout
    implementation(libs.androidx.constraintlayout)
    // Appcompat
    implementation(libs.androidx.appcompat)
    // Material
    implementation(libs.material)
}

//plugins {
//    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
//}
//
//android {
//    namespace = "com.one.core.common_ui"
//    compileSdk = 33
//
//    defaultConfig {
//        minSdk = 26
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}
//
//dependencies {
//
//    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//}