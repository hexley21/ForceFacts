pluginManagement {
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

rootProject.name = "ForceFacts"
include(":app")
include(":core:data")
include(":core:common")
include(":core:model")
include(":core:domain")
include(":feature:navigator")
include(":feature:discover")
include(":core:network")
include(":core:common-test")
