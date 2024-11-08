plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

}

android {
    namespace = "com.example.android_ecommerce_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.android_ecommerce_app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }

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
    // Androidx
    implementation(libs.bundles.androidx)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.tooling)
    implementation(libs.bundles.ui)

    /// Material3
    implementation(libs.androidx.material3)
}




