package com.example.likelion.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.likelion.api_call_practice.DogViewModel
import com.example.likelion.composable.FirstScreen
import com.example.likelion.composable.SecondScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    val dogViewModel = viewModel<DogViewModel>()

    NavHost(
        navController = navController,
        startDestination = Routes.FIRST_SCREEN
    ) {
        composable(route = Routes.FIRST_SCREEN) {
            FirstScreen(
                dogState = dogViewModel.state.value,
                getDogImage = { dogViewModel.getDogImage() },
                onNavigate = { navController.navigate(Routes.SECOND_SCREEN) }
            )
        }

        composable(route = Routes.SECOND_SCREEN) {
            SecondScreen(onPopBackStack = { navController.popBackStack() })
        }
    }
}