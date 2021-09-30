# Applovin_Test_Project

This is an Android project where we have used Test Ads on Applovin and create a mediation with Facebook Audience Network. You can use the following codes on your app to
place applovin ads on your android app.

## Applovin Facebook Adapter
To create a successful mediation with facebook audience network and Applovin then use this Adapter
download from this link
https://search.maven.org/artifact/com.applovin.mediation/facebook-adapter/6.6.0.3/aar

###### Uses of Facebook Adapter and Applovin Ads dependecies on build.gradle file (App Level)
```
plugins {
    id 'com.android.application'
}

android {
    compileSdkVersion 30
    buildToolsVersion "29.0.3"

    defaultConfig {
        applicationId "com.eduwala.testapplovinad"
        minSdkVersion 16
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    repositories {
        google()
        mavenCentral()
    }
}

dependencies {

    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'com.applovin:applovin-sdk:+'
    implementation 'com.applovin.mediation:facebook-adapter:6.6.0.1'
    implementation 'androidx.annotation:annotation:1.0.0'
    implementation 'com.facebook.android:audience-network-sdk:6.+'

}

apply plugin: 'applovin-quality-service'
applovin {
    apiKey "0cQa_IQxTWWzOeDhKJwsLViEllWNVNsDJhGR8nuhJ6LeXaDPqu2k92dTa3__M0w-uL4FI9N8AHVQrRThsiDhDF"
}
```

###### Adding Dependencies on Build.gradle (Root Level)

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        maven { url 'https://artifacts.applovin.com/android' }

    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.1.3"
        classpath "com.applovin.quality:AppLovinQualityServiceGradlePlugin:+"


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```
