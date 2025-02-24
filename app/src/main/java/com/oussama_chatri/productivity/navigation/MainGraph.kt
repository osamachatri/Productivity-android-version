package com.oussama_chatri.productivity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun MainGraph(){

    val navHostController = rememberNavController()
    val startDestination = TODO("Check if ther isn't any account on device")
    NavHost(
        navHostController,
        startDestination = MainPaths.Notes
    ){

    }
}