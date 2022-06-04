package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

open class ComposePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureCompose()
    }
}
