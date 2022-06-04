package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

open class BasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureBuild()
    }
}
