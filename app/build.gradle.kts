
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

apply(from = "../shared_dependencies.gradle")

android {
    namespace = "com.dokari4.submission1_pokeapi"
    compileSdk = 33

    lint {
        baseline = file("lint-baseline.xml")
        disable += "OldTargetApi"
        disable += "Typos"
        disable += "Overdraw"
        disable += "UnusedResources"
        disable += "TypographyEllipsis"
        disable += "HardcodedText"
        disable += "RtlHardcoded"
        disable += "GradleDependency"
    }

    defaultConfig {
        applicationId = "com.dokari4.submission1_moviedbapi"
        multiDexEnabled = true
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = true
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
    dynamicFeatures += setOf(":favorite2")
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.12")
}