package com.devapps.justspeak.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak.data.model.GoogleClientAuth
import com.devapps.justspeak.ui.routes.Check
import com.devapps.justspeak.ui.routes.Signup
import com.devapps.justspeak.ui.routes.german.GermanHome
import com.google.android.gms.auth.api.identity.Identity



@Composable
fun JustSpeakMainNavigation() {

    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            Identity.getSignInClient(context)
        )
    }

    val justSpeakMainNavController = rememberNavController()

    NavHost(justSpeakMainNavController, startDestination = Check.route) {

        composable(Check.route) {
            LaunchedEffect(key1 = Unit) {
                if (googleClientAuth.getSignedInUser() != null) {
                    if (state.isSignInSuccessful) {

                    }
                    justSpeakMainNavController.navigate(GermanHome.route)
                } else {
                    justSpeakMainNavController.navigate(Signup.route)
                }
            }
        }
    }
}