package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import composable.clickableIconCardExit
import composable.clickableIconCardNavigate
import icon.Exit
import icon.RectangleList
import icon.SquarePlus
import icon.Walking

class HomeScreen: Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        MaterialTheme {


        }
        Box(Modifier.fillMaxSize().background(Color.DarkGray)) {
            Text("Willkommen!", fontSize = 50.sp, color = Color.LightGray)
            Box(Modifier.align(Alignment.Center)) {
                Row {
                    Column {
                        clickableIconCardNavigate(SquarePlus(), navigator, EditProjectScreen(), "Projekte")
                        clickableIconCardNavigate(Walking(), navigator, CreateTaskFileScreen(), "Aufgabendatei generieren")
                    }
                    Column {
                        clickableIconCardNavigate(SquarePlus(), navigator, CreateQuestionScreen(), "Neue Aufgabe")
                        clickableIconCardNavigate(Walking(), navigator, HomeScreen(), "Simulieren")
                    }
                    Column {
                        clickableIconCardNavigate(RectangleList(), navigator, QuestionOverviewScreen(), "Fragenliste")
                        clickableIconCardExit(Exit(), "Beenden")
                    }
                }
            }
        }
    }
}