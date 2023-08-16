
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.dokari4.submission1_pokeapi"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.dokari4.submission1_moviedbapi"
        multiDexEnabled = true
        minSdk = 14
        targetSdk = 33
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
    }
}

kapt {
    correctErrorTypes = true
}

val glideVersion = rootProject.extra["glide_version"]
val roomVersion = rootProject.extra["room_version"]
val retrofitVersion = rootProject.extra["retrofit_version"]
val loggingInterceptorVersion = rootProject.extra["logging_interceptor_version"]
val kotlinVersion = rootProject.extra["kotlin_version"]

val lifecycleVersion = rootProject.extra["lifecycle_version"]

val rxLifecycleVersion = rootProject.extra["rxlifecycle_version"]
val rxAndroidVersion = rootProject.extra["rxandroid_version"]
val rxJavaVersion = rootProject.extra["rxjava_version"]

val daggerVersion = rootProject.extra["dagger_version"]

val activityKtxVersion = rootProject.extra["activity_ktx_version"]
val fragmentKtxVersion = rootProject.extra["fragment_ktx_version"]


dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")

    implementation ("com.github.bumptech.glide:glide:$glideVersion")

    implementation ("androidx.room:room-runtime:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation ("androidx.room:room-testing:$roomVersion")

    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")

    implementation ("io.reactivex.rxjava2:rxjava:$rxJavaVersion")
    implementation ("io.reactivex.rxjava2:rxandroid:$rxAndroidVersion")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation ("androidx.room:room-rxjava2:$roomVersion")
    implementation ("androidx.lifecycle:lifecycle-reactivestreams-ktx:$rxLifecycleVersion")

    implementation ("com.google.dagger:dagger:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation ("androidx.activity:activity-ktx:$activityKtxVersion")
    implementation ("androidx.fragment:fragment-ktx:$fragmentKtxVersion")


}