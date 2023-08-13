package com.example.dynamic_appointment_application

import com.example.dynamic_appointment_application.Network.ApiServiceProvider
import com.example.dynamic_appointment_application.Network.NetworkExceptionHandler
import com.example.dynamic_appointment_application.Network.NetworkNotAvailableInterceptor
import com.example.dynamic_appointment_application.Network.RemoteServicesHandler
import com.example.dynamic_appointment_application.ui.dashboard.DashboardViewModel
import com.example.dynamic_appointment_application.ui.login.LoginViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val repositoryModule = module {
    single { UserRepository(get(), get()) }
    single { AppointmentServiceRepository(get(), get()) }
}

val utilsModule = module {
    single { provideOkHttpBuilder() }
    single { ApiServiceProvider(provideOkHttpBuilder().build()).createApiService() }
    single { RemoteServicesHandler(get()) }
    single { NetworkExceptionHandler(get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { DashboardViewModel(get()) }
}

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { GetServicesUseCase(get()) }
}

fun provideOkHttpBuilder(): OkHttpClient.Builder {
    val okHttpClientBuilder = OkHttpClient.Builder()

    okHttpClientBuilder
        .addInterceptor(NetworkNotAvailableInterceptor())
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)

    return okHttpClientBuilder
}