plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.marketplacepuj"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.marketplacepuj"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        freeCompilerArgs += "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }



    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("com.google.android.material:material:1.12.0")
    implementation("com.valentinilk.shimmer:compose-shimmer:1.0.5")
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.github.leonard-palm:compose-state-events:2.1.0")
    //firebase messaging
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.fragment:fragment-ktx:1.7.0")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.ai.client.generativeai:generativeai:0.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("com.google.firebase:firebase-database-ktx:21.0.0")
    //Jetpack navigation component
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-android-compiler:2.45")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.compose.material:material:1.7.3")
    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("io.coil-kt.coil3:coil-compose:3.0.0-rc01")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.0-rc01")


    val koin_version = "3.4.3"
    implementation("io.insert-koin:koin-androidx-compose:$koin_version")
    implementation("io.insert-koin:koin-androidx-workmanager:$koin_version")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))

    // Add the dependency for the Performance Monitoring library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-perf")
}