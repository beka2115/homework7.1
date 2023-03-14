object Versions{
    const val AGP ="7.3.1"
    const val kotlin = "1.7.21"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constraint = "2.1.4"
    const val jUnit = "4.13.2"
    const val extJUnit = "1.1.5"
    const val espresso = "3.5.1"
    const val fragment = "1.5.5"
    const val room = "2.5.0"
    const val navigation = "2.5.3"
    const val lifecycle = "2.5.1"
    const val coroutines = "1.6.4"
    const val viewBindingDelegate = "1.5.8"
    const val androidCore = "1.7.0"
    const val hilt = "2.44.2"
}

object Deps{

    object UI{
        const val androidCore = "android.core:core-ktx:${Versions.androidCore}"
        const val appCompat = "androidx.appcompat:appcompat-resources:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val jUnit= "junit:junit:${Versions.jUnit}"
        const val extJUnit= "android.test.ext:junit:${Versions.extJUnit}"
        const val espresso= "android.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment= "android.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Room{
        const val runtime = "android.room:room-runtime:${Versions.room}"
        const val compiler = "android.room:room-compiler:${Versions.room}"
        const val room= "android.room:room-ktx${Versions.room}"
    }

    object DaggerHilt{
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }
    object Coroutines{
        const val android = "org.jetbrains.kotlin:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core = "org.jetbrains.kotlin:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object NavigationComponent{
        const val fragment ="androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui="androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Lifecycle{
        const val viewmodel="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime ="androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object ViewBindingDelegate{
        const val viewBindingDelegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingDelegate}"
    }
    object Javax{
        const val inject = "javax.inject.javax.inject:1"
    }

}

object Plugins{


    object AGP{
        const val application ="com.android.application"
        const val library ="com.android.library"
    }
    object Kotlin{
       const val android ="org.jetbrains.kotlin.android"
       const val kapt ="kotlin-kapt"
       const val jvm ="org.jetbrains.kotlin.jvm"

    }

    object DaggerHilt{
        const val hilt = "com.google.dagger.hilt.android"
    }
    object Java {
        const val library = "java-library"
    }

}