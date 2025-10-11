plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    alias(libs.plugins.google.gms.google.services)
    kotlin("plugin.serialization") version "2.2.20"
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.devapps.justspeak"
    compileSdk = 36

    signingConfigs {
        create("release") {
            storeFile = file("C:/Users/Artska/Desktop/keystores/JustSpeakKey.jks")
            storePassword = (project.findProperty("KEYSTORE_PASSWORD") ?: "").toString()
            keyAlias = "JustSpeak"
            keyPassword = (project.findProperty("KEY_PASSWORD") ?: "").toString()
        }
    }

    defaultConfig {
        applicationId = "com.devapps.justspeak"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlin {
        compilerOptions {
            optIn.add("kotlin.RequiresOptIn")
        }
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
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    //koin dependency
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.android)

    //lifecycle
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    //material extended icons
    implementation(libs.material.icons.extended)

    //coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    //navigation
    implementation(libs.androidx.navigation.compose)

    //serializable
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.coroutines.test)

    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(platform(libs.firebase.bom))


    //splashscreen
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.play.services.auth)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.ui.graphics)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}