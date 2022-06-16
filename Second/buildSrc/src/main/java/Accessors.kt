import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/*
 * Extensions that used to provide above dependency syntax that mimics Gradle Kotlin DSL syntax
 * in module\build.gradle.kts.kts.kts files. Mimics to extensions that are generated on the fly by Gradle.
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.projectImplementation(dependencyNotation: String): Dependency? =
    add("implementation", project(dependencyNotation))

fun DependencyHandler.projectApi(dependencyNotation: String): Dependency? =
    add("api", project(dependencyNotation))

private fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency = uncheckedCast(
    project(
        if (configuration != null) mapOf("path" to path, "configuration" to configuration)
        else mapOf("path" to path)
    )
)

@Suppress("unchecked_cast", "nothing_to_inline")
private inline fun <T> uncheckedCast(obj: Any?): T =
    obj as T
