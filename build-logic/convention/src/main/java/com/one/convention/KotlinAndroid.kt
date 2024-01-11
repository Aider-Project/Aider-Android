package com.one.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.Project
import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = 34

        defaultConfig { // 모듈의 기본 설정을 정의하는 블록
            minSdk = 26

            //  이 러너는 안드로이드에서 JUnit 테스트를 실행할 수 있게 해주는 러너입니다. JUnit은 자바의 단위 테스트 프레임워크입니다.
            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
            // 벡터 드로어블을 사용할 때 지원 라이브러리를 사용하도록 설정합니다. 벡터 드로어블은 안드로이드에서 확장성 있는 그래픽을 표현하는 방식입니다.
            vectorDrawables.useSupportLibrary = true
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}

/**
 * Kotlin options
 *
 * 이 함수는 코틀린의 JVM 컴파일러 옵션을 설정하는 함수 : 람다식을 통해 코틀린의 JVM 컴파일러 옵션을 원하는 대로 설정할 수 있습니다.
 *
 * 사용법 :
 * commonExtension.kotlinOptions {
 *     jvmTarget = "17"
 *     freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
 *     useIR = true
 * }
 *
 * @param block
 * @receiver
 */
fun CommonExtension<*, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    //  CommonExtension : 안드로이드 플러그인이 제공하는 클래스로, 안드로이드 앱의 빌드 설정을 정의하는 역할을 합니다.
    //  이 클래스는 다섯 개의 타입 파라미터를 가지는데, 이 코드에서는 *로 표시되어 있습니다.
    //  이는 타입 파라미터가 정해지지 않았음을 의미합니다.

    // (this as ExtensionAware) :  CommonExtension 객체를 ExtensionAware 인터페이스로 캐스팅합니다.
    // ExtensionAware 인터페이스는 Gradle의 확장 기능을 사용할 수 있게 해주는 인터페이스입니다.
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}