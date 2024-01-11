@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
}

// 그룹 ID는 프로젝트를 고유하게 식별하는 데 사용되며, 일반적으로 회사의 도메인 이름을 역순으로 사용
group = "com.one.aider.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}


tasks {
    //  Gradle의 플러그인 유효성 검사 작업(task)입니다. 이 작업은 플러그인이 제대로 작성되었는지 검사하고, 문제가 있으면 경고나 오류를 출력
    validatePlugins {
        // 더 엄격한 유효성 검사를 활성화합니다. 이 설정이 활성화되면, Gradle은 플러그인의 메타데이터 문제를 찾기 위해 보다 엄격한 검사를 실시
        enableStricterValidation.set(true)
//        // 경고가 발생했을 때 빌드를 실패하게 합니다. 일반적으로 경고는 빌드 실패의 원인이 되지 않지만, 이 설정을 활성화하면 경고가 발생했을 때 빌드가 실패하게 됩니다.
//        failOnWarning = true
    }
}


gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "aider.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "aider.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("javaLibrary") {
            id = "aider.java.library"
            implementationClass = "JavaLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "aider.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "aider.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}