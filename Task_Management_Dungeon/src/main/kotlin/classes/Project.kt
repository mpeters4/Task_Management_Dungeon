package classes

import androidx.compose.runtime.mutableStateListOf

data class Project(
    val name: String,
) {
    val questions: List<Question> = mutableStateListOf()
    var dependencies: List<Dependency> = mutableStateListOf()
}