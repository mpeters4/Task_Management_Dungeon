import org.jetbrains.compose.desktop.application.dsl.TargetFormat



plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("app.cash.sqldelight") version "2.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

//Set Compiler to Java 21.01
compose {
    kotlinCompilerPlugin.set("androidx.compose.compiler:compiler:1.5.7")
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}


dependencies {
    val voyagerVersion = "1.0.0"
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)

    // Navigator
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")

    // Screen Model
    implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")

    // BottomSheetNavigator
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")

    // TabNavigator
    implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")

    // Transitions
    implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

    //Material 3
    implementation("org.jetbrains.compose.material3:material3-desktop:1.2.1")
    //SQLdelight
   // implementation("app.cash.sqldelight:native-driver:2.0.1")


}

//Database
sqldelight {
    databases {
        create("Database") {
            packageName.set("frage")
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Task_Management_Dungeon"
            packageVersion = "1.0.0"
        }
    }
}
