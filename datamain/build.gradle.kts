import Plugins.Kotlin.kapt

plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.homework71"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    //Module
    implementation(project(":domain"))

    //Android
    implementation(Deps.UI.androidCore)

    //Test
    testImplementation(Deps.UI.jUnit)
    androidTestImplementation(Deps.UI.extJUnit)

    //Room
    implementation(Deps.Room.room)
    implementation(Deps.Room.runtime)
    kapt(Deps.Room.compiler)

    //Javax
    implementation(Deps.Javax.inject)

    //Coroutines
    implementation(Deps.Coroutines.android)

}