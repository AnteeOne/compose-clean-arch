package plugins

import org.gradle.api.Project

open class BaseAndroidPlugin : BasePlugin() {
    override fun apply(project: Project) {
        project.configureDefaultPlugins()
        project.configureAndroid()
    }
}
