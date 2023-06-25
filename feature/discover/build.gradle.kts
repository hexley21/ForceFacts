@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "org.hxl.discover"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "org.hxl.common.test_conf.AppTestRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        dataBinding = true
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        animationsDisabled = true
        unitTests {
            isIncludeAndroidResources = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    implementation(libs.core.ktx)
    implementation(libs.kotlinx.coroutines)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.swiperefreshlayout)

    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.common)

    implementation(libs.retrofit)

    implementation(libs.androidx.paging.runtime)

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    implementation(libs.espresso.idling)

    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.kotlinx.coroutines.test)

    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.test.runner)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.espresso.contrib)

    androidTestImplementation(libs.mockito.core)
    androidTestImplementation(libs.mockito.android)

    testImplementation(libs.dagger.hilt.testing)
    kaptTest(libs.dagger.hilt.compiler)

    androidTestImplementation(libs.dagger.hilt.testing)
    kaptAndroidTest(libs.dagger.hilt.compiler)

    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.androidx.fragment.testing)

    debugImplementation(libs.androidx.fragment.testing.manifest)
}