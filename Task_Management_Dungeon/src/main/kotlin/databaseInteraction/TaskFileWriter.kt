package databaseInteraction

import classes.*
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import java.io.File


object TaskFileWriter {

    fun writeProjectToFile(projectId: Long, filename: String) {
        val projectData = Provider.provideProjectDataSource(Driver.createDriver())
        val dependencyData = Provider.provideDependencyDataSource(Driver.createDriver())
        val project = runBlocking { projectData.getProjectById(projectId) }
        var dependencies = runBlocking { dependencyData.getAllDependenciesByProjectId(projectId).firstOrNull() }
        // create Questionlist
        val questions = DataBaseCommunication.getQuestionsFromDependencyList(dependencies)

        //ProjektAnleitung zum Schreiben
        try {
            File("Dungeon_Files/$filename.dng").appendText("// $project\n")
        } catch (e: Exception) {
            println("An error occurred: ${e.message}")
        }
        questions.forEach {
            writeQuestion(it, filename)
        }
        /*
        Get projekt
        get dependencies
        get questionsById ->dependencies
        get answers by questionId ->dependencies
         */
    }

    fun writeQuestion(question: Question, filename: String) {
        try {
            when (question) {
                is SingleChoiceQuestion -> {
                    File("Dungeon_Files/$filename.dng").appendText(
                        "\nsingle_choice_task ${question.id} {" +
                                "\n\tdescription: \"${question.description}\"," +
                                "\n\texplanation: \"${question.explanation}\"," +
                                "\n\tpoints: \"${question.points}\"," +
                                "\n\tpoints_to_pass: \"${question.pointsToPass}\"," +
                                "\n\tanswers: ["
                    )
                    question.answers.forEachIndexed { index, answer ->
                        if (index == 0) {
                            File("Dungeon_Files/$filename.dng").appendText("\n\t\"$answer\"")
                        } else {
                            File("Dungeon_Files/$filename.dng").appendText(",\n\t\"$answer\"")
                        }
                    }
                    File("Dungeon_Files/$filename.dng").appendText("],\n\tcorrect_answer_index: ${question.correctAnswerIndex}\n}\n")
                }

                is MultipleChoiceQuestion -> {
                    File("Dungeon_Files/$filename.dng").appendText(
                        "\nmultiple_choice_task ${question.id} {" +
                                "\n\tdescription: \"${question.description}\"," +
                                "\n\texplanation: \"${question.explanation}\"," +
                                "\n\tpoints: \"${question.points}\"," +
                                "\n\tpoints_to_pass: \"${question.pointsToPass}\"," +
                                "\n\tanswers: ["
                    )
                    question.answers.forEachIndexed { index, answer ->
                        if (index == 0) {
                            File("Dungeon_Files/$filename.dng").appendText("\n\t\"$answer\"")
                        } else {
                            File("Dungeon_Files/$filename.dng").appendText("\n\t\"$answer\"")
                        }
                    }
                    File("Dungeon_Files/$filename.dng").appendText("],\n\tcorrect_answer_index: [")
                    question.correctAnswerIndices.forEachIndexed { index, correctAnswer ->
                        if (index == 0) {
                            File("Dungeon_Files/$filename.dng").appendText("$correctAnswer")
                        } else {
                            File("Dungeon_Files/$filename.dng").appendText(", $correctAnswer")
                        }
                    }
                    File("Dungeon_Files/$filename.dng").appendText("] \n}\n")
                }

                is AssignQuestion -> {
                    File("Dungeon_Files/$filename.dng").appendText(
                        "\nassign_task ${question.id} {" +
                                "\n\tdescription: \"${question.description}\"," +
                                "\n\texplanation: \"${question.explanation}\"," +
                                "\n\tpoints: \"${question.points}\"," +
                                "\n\tpoints_to_pass: \"${question.pointsToPass}\"," +
                                "\n\tsolution: <"
                    )
                    question.assignments.forEachIndexed { index, assignment ->
                        if (index == 0){
                            if (assignment.termA == "_"){
                                File("Dungeon_Files/$filename.dng").appendText("\n\t\t[_, \"${assignment.termB}\"]")
                            }else{
                                if (assignment.termB == "_"){
                                    File("Dungeon_Files/$filename.dng").appendText("\n\t\t[\"${assignment.termA}\", _]")
                                }else{
                                    File("Dungeon_Files/$filename.dng").appendText("\n\t\t[\"${assignment.termA}\", \"${assignment.termB}\"]")
                                }
                            }
                        }else{
                            if (assignment.termA == "_"){
                                File("Dungeon_Files/$filename.dng").appendText(",\n\t\t[_, \"${assignment.termB}\"]")
                            }else{
                                if (assignment.termB == "_"){
                                    File("Dungeon_Files/$filename.dng").appendText(",\n\t\t[\"${assignment.termA}\", _]")
                                }else{
                                    File("Dungeon_Files/$filename.dng").appendText(",\n\t\t[\"${assignment.termA}\", \"${assignment.termB}\"]")
                                }
                            }
                        }
                    }
                    File("Dungeon_Files/$filename.dng").appendText("\n\t>\n}\n")
                }
            }
        } catch (e: Exception) {
            println("An error occurred: ${e.message}")
        }

    }


}