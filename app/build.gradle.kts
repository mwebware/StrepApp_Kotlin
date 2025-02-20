plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.android_strepapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android_strepapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            storeFile = file("D:/StrepApp_Android_Kotlin/Andriod_StrepApp/kotlin_apk.jks")
            storePassword = "Welcome1!" // Keystore password
            keyAlias = "key0" // Key alias
            keyPassword = "Welcome1!" // Key password
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
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
    // AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    // Jetpack Compose Libraries
    implementation("androidx.compose.ui:ui:1.5.0") // Specify the correct version
    implementation("androidx.compose.ui:ui-graphics:1.5.0") // Specify the correct version
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0") // Specify the correct version
    implementation("androidx.compose.material3:material3:1.1.0") // Specify the correct version

    // Optional Libraries
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // ViewModel for Compose
    implementation("androidx.navigation:navigation-compose:2.7.0") // Navigation for Compose
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("androidx.biometric:biometric:1.2.0-alpha05")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")

    implementation(libs.androidx.constraintlayout)
    implementation(libs.volley) // Coroutines for Android

    // Testing Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0") // Specify the correct version
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0") // Specify the correct version
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0") // Specify the correct version

    // CameraX Libraries
    implementation("androidx.camera:camera-core:1.2.0")
    implementation("androidx.camera:camera-camera2:1.2.1")
    implementation("androidx.camera:camera-lifecycle:1.2.1")
    implementation("androidx.camera:camera-view:1.2.1")
    implementation("androidx.camera:camera-extensions:1.2.0")

    // ML Kit Face Detection
    implementation("com.google.mlkit:face-detection:16.1.2")

    // Image Processing for ML Kit (optional, uncomment if needed)
    // implementation("com.google.mlkit:vision-common:19.0.0")
    // implementation("com.google.mlkit:vision-image-labeling:19.0.4")

    // Retrofit for API calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coil for Image Loading (for Compose)
    implementation("io.coil-kt:coil-compose:2.3.0")

}
