package com.devapps.justspeak.di
import com.devapps.justspeak.data.model.GoogleClientAuth
import com.devapps.justspeak.ui.AuthViewModel
import com.google.android.gms.auth.api.identity.SignInClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val appModule = module {

    single<SignInClient> {
        com.google.android.gms.auth.api.identity.Identity.getSignInClient(androidContext())
    }

    single {
        GoogleClientAuth(
            context = androidContext(),
            oneTapClient = get()
        )
    }

    viewModel {
        AuthViewModel(
            googleClientAuth = get()
        )
    }

}