package databaseInteraction

import classes.Question
import db.Dependency
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import java.io.File


object TaskFileWriter {

    fun writeProjectToFile(projectId: Long, filename: String){
        val answerData = Provider.provideAnswerDataSource(Driver.createDriver())
        val assignmentData = Provider.provideAssignmentDataSource(Driver.createDriver())
        val questionData = Provider.provideQuestionDataSource(Driver.createDriver())
        val projectData = Provider.provideProjectDataSource(Driver.createDriver())
        val dependencyData = Provider.provideDependencyDataSource(Driver.createDriver())
        val correctAnswerData = Provider.provideCorrectAnswerDataSource(Driver.createDriver())
        val project = runBlocking { projectData.getProjectById(projectId) }
        var dependencies = runBlocking { dependencyData.getAllDependenciesByProjectId(projectId).firstOrNull() }

        //ProjektAnleitung zum Schreiben
        try {
            File("Dungeon_Files/Test.dng").appendText("// $project\n")
        } catch (e: Exception) { println("An error occurred: ${e. message}") }

        /*
        Get projekt
        get dependencies
        get questionsById ->dependencies
        get answers by questionId ->dependencies
         */
    }




    fun writeQuestion(question: Question){


    }



}