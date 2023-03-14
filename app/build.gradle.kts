plugins {
    id (Plugins.AGP.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
}

android {
    namespace ="com.example.homework71"
    compileSdk =AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.homework71"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled  = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation (Deps.UI.androidCore)
    implementation (Deps.UI.appCompat)
    implementation (Deps.UI.material)
    implementation (Deps.UI.constraint)
    testImplementation (Deps.UI.jUnit)
    androidTestImplementation (Deps.UI.extJUnit)
    androidTestImplementation (Deps.UI.espresso)
    implementation (Deps.UI.fragment)

    //room

    implementation (Deps.Room.runtime)
    kapt( Deps.Room.compiler)
    implementation (Deps.Room.room)

    //Dagger-Hilt
    implementation (Deps.DaggerHilt.hilt)
    kapt (Deps.DaggerHilt.compiler)

    implementation (Deps.Coroutines.android)

    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")

    //nav_graph

    implementation (Daps.NavigationComponent.fragment)
    implementation(Deps.NavigationComponent.ui)
    //circleImage
    implementation(Deps.Coroutines.android)

    //viewBinding
    implementation(Deps.ViewBinding.Delegate.viewBindingDelegate)

}