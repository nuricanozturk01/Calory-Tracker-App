pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "CaloryTrackerApp"
include(":app")
include(":appBuild")
include(":core")
include(":core-ui")
include(":onboarding")
include(":onboarding:onboarding-domain")
include(":onboarding:onboarding-presentation")
include(":tracker")
include(":tracker:tracker-domain")
include(":tracker:tracker-presentation")
