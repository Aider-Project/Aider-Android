import com.android.build.api.dsl.ApplicationExtension
import com.one.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                // 안드로이드 앱을 개발하기 위한 플러그인입니다. 이 플러그인은 안드로이드의 빌드 설정, 컴파일, 테스트, 배포 등의 기능을 제공
                apply("com.android.application")
                // 코틀린 언어를 사용하여 안드로이드 앱을 개발하기 위한 플러그인입니다.
                // 이 플러그인은 코틀린 컴파일러와 안드로이드 플러그인을 연동하고, 코틀린의 표준 라이브러리와 안드로이드 확장 라이브러리를 추가하는 기능을 제공
                apply("org.jetbrains.kotlin.android")
            }

            // extensions는 Project 클래스의 프로퍼티로, 프로젝트의 확장 기능을 관리하는 역할
            // configure 함수는 ExtensionContainer 인터페이스의 함수로, 특정 타입의 확장을 설정하는 역할
            // ApplicationExtension은 안드로이드 플러그인이 제공하는 클래스로, 안드로이드 앱의 빌드 설정을 정의하는 역할
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
            }
        }
    }
}