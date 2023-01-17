import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.parcelize")
    kotlin("android")
    kotlin("kapt")
    `maven-publish`
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.ajou4095"
            artifactId = "Ray-Design-System"
            version = libs.versions.app.versionname.get()
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

android {
    namespace = "com.ray.rds"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
    }

    buildTypes {
        debug {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    /**
     * Gradle 7.0.0 이상에서는 JDK 11 을 기본으로 사용한다.
     * url : https://cliearl.github.io/posts/android/android-gradle-java-11/
     */
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    libraryVariants.all {
        val variant = this
        variant.outputs.map {
            it as com.android.build.gradle.internal.api.BaseVariantOutputImpl
        }.forEach { output ->
            val outputFileName = "${project.name}-${libs.versions.app.versionname.get()}-${variant.name}.aar"
            output.outputFileName = outputFileName
        }
    }
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.bundles.androidx.presentation)
    implementation(libs.google.material)
    implementation(libs.glide)
    kapt(libs.glide.compiler)
    implementation(libs.lottie)
    implementation(libs.shimmer)

    implementation(libs.timber)
    // TODO : Firebase Crashlytics 추가 - jitpack.io google-services.json System.getEnv
}

fun getLocalProperty(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}
