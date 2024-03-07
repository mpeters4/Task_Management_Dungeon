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
import composable.ClickableIconCardNavigate
import composable.clickableIconCardExit
import icon.SquarePlus
import icon.Walking
import icon.Exit
import icon.RectangleList

class Homescreen : Screen {
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
                        ClickableIconCardNavigate(SquarePlus(), navigator, Homescreen(), "Neue Aufgabe")
                        ClickableIconCardNavigate(Walking(), navigator, Homescreen(), "Simulieren")
                    }
                    Column {
                        ClickableIconCardNavigate(RectangleList(), navigator, Homescreen(), "Fragenliste")
                        clickableIconCardExit(Exit(), "Beenden")
                    }
                }
            }
        }
    }
}