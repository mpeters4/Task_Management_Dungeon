@file:OptIn(ExperimentalLayoutApi::class)

package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.compose.AppTheme
import composable.clickableIconCardNavigate
import composable.title
import icon.squarePlusIcon
import icon.walkingIcon

/**
 * Screen to navigate to the different question creation screens
 */
class QuestionChoiceScreen : Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Box{
                    title("Bitte wählen Sie den Fragetypen")
                    Box(
                        Modifier.fillMaxSize().padding(top = 100.dp).verticalScroll(rememberScrollState()),
                        contentAlignment = Alignment.Center,
                    ) {
                        FlowRow(
                            Modifier.height(intrinsicSize = IntrinsicSize.Max)
                                .width(intrinsicSize = IntrinsicSize.Max)
                                .align(Alignment.Center),
                            horizontalArrangement = Arrangement.Center,
                            maxItemsInEachRow = 3
                        ) {
                            clickableIconCardNavigate(
                                squarePlusIcon(MaterialTheme.colorScheme.onBackground),
                                "Single-Choice",
                                Modifier.padding(8.dp),
                                navigator,
                                CreateSingleChoiceScreen()
                            )
                            clickableIconCardNavigate(
                                squarePlusIcon(MaterialTheme.colorScheme.onBackground),
                                "Multiple-Choice",
                                Modifier.padding(8.dp),
                                navigator,
                                CreateQuestionScreen()
                            )
                            clickableIconCardNavigate(
                                walkingIcon(MaterialTheme.colorScheme.onBackground),
                                "Zuordnungs-\naufgabe",
                                Modifier.padding(8.dp),
                                navigator,
                                CreateQuestionScreen()
                            )
                        }
                    }
                }
            }
        }
    }
}