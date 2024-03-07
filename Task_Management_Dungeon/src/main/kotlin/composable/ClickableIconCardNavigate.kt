package composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

/**
 * Clickable Card to novigate to a Screen
 * @param icon ImageVector of the Icon that is shown in the card
 * @param text Text that is shown in the Card
 * @param navigator Navigator that is used to navigate to another screen
 * @param location Screen to navigate to
 */
@Composable
fun ClickableIconCardNavigate(icon : ImageVector, navigator: Navigator, location: Screen, text : String) {
    Card(elevation = 15.dp,modifier = Modifier.padding(10.dp).size(width = 120.dp, height = 120.dp).clickable {
        navigator.push(location)
    }, backgroundColor = Color.DarkGray, border = BorderStroke(1.dp, color = Color.Black))
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(icon, "Icon", Modifier.padding(10.dp))
            Text(
                text = text,
                modifier = Modifier.padding(2.dp),
                color = Color.LightGray
            )
        }
    }
}

