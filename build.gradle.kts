plugins {
    id("java")
}

group = "fr.esgi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.assertj:assertj-core:3.27.6")
}

tasks.test {
    useJUnitPlatform()
}

// Task to generate a ZIP containing the src directory, with a configurable name
abstract class RenduZip : Zip() {

    // Command-line option: --name AL1
    @get:org.gradle.api.tasks.Input
    @set:org.gradle.api.tasks.options.Option(option = "group", description = "produces gr-<GROUP>.zip)")
    var renduName: String? = null

    // Also allow -PrenduName=AL1 as a fallback
    private fun resolveName(): String {
        val cli = renduName?.trim().orEmpty()
        if (cli.isNotEmpty()) return cli
        val prop = (project.findProperty("renduName") as String?)?.trim()
        return if (!prop.isNullOrEmpty()) prop else "AL1"
    }

    @org.gradle.api.tasks.TaskAction
    override fun copy() {
        val name = resolveName()
        archiveFileName.set("rendu-gr-$name.zip")
        super.copy()
    }
}

tasks.register<RenduZip>("rendu") {
    group = "build"
    description = "Generates a ZIP archive containing the src directory. Use --group 1 or -PrenduName=1 to set the archive label."
    destinationDirectory.set(layout.projectDirectory)
    from("src") {
        into("src")
    }
}