package com.devapps.justspeak.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak.R
import com.devapps.justspeak.data.model.GoogleClientAuth
import com.devapps.justspeak.ui.routes.Check
import com.devapps.justspeak.ui.routes.Signout
import com.devapps.justspeak.ui.routes.Signup
import com.devapps.justspeak.ui.routes.german.GermanHome
import com.devapps.justspeak.ui.screens.german.GermanHomeScreen
import com.devapps.justspeak.ui.theme.justBlue
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun JustSpeakMainNavigation() {

    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val authViewModel: AuthViewModel = koinViewModel()
    val state by authViewModel.state.collectAsStateWithLifecycle()

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
        composable(Signup.route) {
            SignupScreen(authViewModel, justSpeakMainNavController)
        }

        composable(GermanHome.route) {
            GermanHomeScreen(justSpeakMainNavController)
        }

        composable(Signout.route) {
            LaunchedEffect(Unit) {
                googleClientAuth.signOut()
                justSpeakMainNavController.navigate(Signup.route)

            }
        }
    }
}

@Composable
fun SignupScreen(
    authViewModel: AuthViewModel,
    justSpeakMainNavController: NavHostController) {

    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            Identity.getSignInClient(context)
        )
    }
    val state by authViewModel.state.collectAsStateWithLifecycle()
    val privacyPolicyUrl = "https://www.termsfeed.com/live/2399f9f1-bdaf-45dd-9a08-d31bfad531f3"

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == RESULT_OK) {
                coroutineScope.launch {
                    val signInResult = googleClientAuth.signInWithIntent(
                        intent = result.data ?: return@launch
                    )
                    authViewModel.onSignInResult(signInResult)
                }
            }
        }
    )

    Box(modifier = Modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .height(160.dp)
            )
            Image(
                painterResource(
                    R.drawable.hoi
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Spacer(modifier = Modifier
                .height(5.dp)
            )
            Text(text = "JustSpeak!",
                    fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = justBlue
            )
            Spacer(modifier = Modifier
                .height(4.dp)
            )
            Text(text = "Say Hello to Fluency!",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        ) {
            Spacer(modifier = Modifier
                .weight(0.75f)
            )
            Button(
                onClick = {
                    coroutineScope.launch {
                        val signInIntentSender = googleClientAuth.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                signInIntentSender ?: return@launch
                            ).build()
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = justBlue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(text = "Get Started",
                    fontSize = 20.sp)
            }
            Text(
                text = "By signing in you are agreeing to our ",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            TextButton(
                onClick = {
                    // Open the privacy policy URL in a web view
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(privacyPolicyUrl))
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "Privacy Policy",
                    fontSize = 14.sp,
                    color = justBlue,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
    LaunchedEffect(state.isSignInSuccessful) {
        if (state.isSignInSuccessful) {
            justSpeakMainNavController.navigate(GermanHome.route)
        } else if(state.signInError != null) {
            Toast.makeText(context,
                "There was an error signing in " + state.signInError,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview() {

}