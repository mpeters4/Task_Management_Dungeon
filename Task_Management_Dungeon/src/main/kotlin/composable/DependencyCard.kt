package composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import databaseInteraction.DataBaseCommunication
import databaseInteraction.Driver
import databaseInteraction.Provider
import icon.deleteIcon
import kotlinx.coroutines.runBlocking

@Composable
fun dependencyCard(dependency: db.Dependency){
    val questionData = Provider.provideQuestionDataSource(Driver.createDriver())
    val dependencyData = Provider.provideDependencyDataSource((Driver.createDriver()))
    val questionA = runBlocking {DataBaseCommunication.getQuestionAsClass(questionData.getQuestionById(dependency.questionAID)!!) }
    val questionB = runBlocking {DataBaseCommunication.getQuestionAsClass(questionData.getQuestionById(dependency.questionBID)!!) }

    Card {
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            if (questionA != null) {
                expandableItem(questionA,{}, mode = 3, modifier = Modifier.weight(3f))
            }
            if (questionB != null) {
                expandableItem(questionB,{}, mode = 3, modifier = Modifier.weight(3f))
            }
            Box(modifier = Modifier.width(200.dp)) { bodyText(dependency.dependency, modifier = Modifier.align(Alignment.TopCenter)) }
            Image(
                deleteIcon(MaterialTheme.colorScheme.onSurfaceVariant),
                "Remove Item",
                Modifier.padding(10.dp).clickable { runBlocking { dependencyData.deleteDependencyById(dependency.dependencyID)}}.width(56.dp)  )
        }
    }
}
