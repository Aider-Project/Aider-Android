pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Aider"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":feature:calendar")
include(":feature:lecture")
include(":feature:assignment")
include(":core:database")
include(":core:network")
include(":core:data")
include(":core:common")
include(":core:common-ui")
include(":core:model")
include(":feature:messenger")
include(":feature:setting")
