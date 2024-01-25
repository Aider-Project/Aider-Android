import com.one.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("aider.android.library")
                apply("aider.android.hilt")
            }

            dependencies {
                add("implementation", project(":core:common"))
                add("implementation", project(":core:common-ui"))
                add("implementation", libs.findBundle("navigation").get())
                add("implementation", libs.findBundle("ktx").get())
            }
        }
    }
}