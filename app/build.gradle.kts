plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  id("com.google.devtools.ksp")
  id("com.google.dagger.hilt.android")

}

android {
  namespace = "com.samuel.technical_test_agiletv"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.samuel.technical_test_agiletv"
    minSdk = 29
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
  packagingOptions {
    resources.excludes += listOf(
      "META-INF/LICENSE.md",
      "META-INF/LICENSE-notice.md",
      "META-INF/LICENSE.txt",
      "META-INF/NOTICE.md",
      "META-INF/NOTICE.txt",
      "META-INF/notice.txt",
      "META-INF/ASL-2.0.txt"
    )
  }
}

dependencies {


  ksp(libs.hilt.android.compiler)
  implementation(libs.hilt.android)

  implementation(libs.hilt.compose.navigation)

  implementation(libs.retrofit)
  implementation(libs.retrofit.gson.convertor)

  implementation(libs.coil.compose)
  implementation(libs.coil.network.okhttp)

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  testImplementation(libs.junit)
  testImplementation (libs.kotlinx.coroutines.test)
  testImplementation(libs.mockk)

  testImplementation(libs.mockito.core)
  testImplementation(libs.mockito.kotlin)
  testImplementation(libs.kotlinx.coroutines.test.v164)

  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation (libs.mockk.android)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}