@file:OptIn(ExperimentalLayoutApi::class)

package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.compose.AppTheme
import composable.clickableIconCardExit
import composable.clickableIconCardNavigate
import icon.Exit
import icon.RectangleList
import icon.SquarePlus
import icon.Walking

class HomeScreen : Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column (
                    Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(8.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Willkommen!",
                        textAlign = TextAlign.Left,
                        fontSize = 50.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Box(
                        Modifier.fillMaxSize().padding(top = 30.dp)
                    ) {
                        FlowRow(
                            Modifier.height(intrinsicSize = IntrinsicSize.Max)
                                .width(intrinsicSize = IntrinsicSize.Max)
                                .align(Alignment.Center),
                            maxItemsInEachRow = 3
                        ) {
                            clickableIconCardNavigate(
                                SquarePlus(MaterialTheme.colorScheme.onBackground),
                                "Projekte",
                                Modifier.padding(8.dp),
                                navigator,
                                EditProjectScreen()
                            )
                            clickableIconCardNavigate(
                                Walking(MaterialTheme.colorScheme.onBackground),
                                "Aufgabendatei\ngenerieren",
                                Modifier.padding(8.dp),
                                navigator,
                                CreateTaskFileScreen()
                            )
                            clickableIconCardNavigate(
                                SquarePlus(MaterialTheme.colorScheme.onBackground),
                                "Neue Aufgabe",
                                Modifier.padding(8.dp),
                                navigator,
                                CreateQuestionScreen()
                            )
                            clickableIconCardNavigate(
                                Walking(MaterialTheme.colorScheme.onBackground),
                                "Simulieren",
                                Modifier.padding(8.dp),
                                navigator,
                                HomeScreen()
                            )
                            clickableIconCardNavigate(
                                RectangleList(MaterialTheme.colorScheme.onBackground),
                                "Fragenliste",
                                Modifier.padding(8.dp),
                                navigator,
                                QuestionOverviewScreen()
                            )
                            clickableIconCardExit(
                                Exit(MaterialTheme.colorScheme.onBackground),
                                "Beenden",
                                Modifier.padding(8.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}