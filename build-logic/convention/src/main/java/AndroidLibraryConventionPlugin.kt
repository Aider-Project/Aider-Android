import com.android.build.gradle.LibraryExtension
import com.one.convention.configureKotlinAndroid
import com.one.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                defaultConfig.targetSdk = 34

                defaultConfig {
                    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
                    vectorDrawables.useSupportLibrary = true
                }

                buildFeatures {
                    dataBinding = true
                    viewBinding = true
                }

                buildTypes {
                    getByName("debug") {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }

                    getByName("release") {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                        ndk {
                            debugSymbolLevel = "FULL"
                        }
                    }
                }
            }
            dependencies {
                "implementation"(libs.findBundle("coroutine").get())
            }
        }
    }
}