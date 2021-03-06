// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libraries.classpathBuildGradle)
        classpath(Libraries.classpathKotlinGradle)
        classpath(Libraries.classpathHiltAndroidGradle)
        classpath(Libraries.classpathSafeArgs)


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
tasks.register("clean", Delete::class) {
    rootProject.buildDir.delete()
}