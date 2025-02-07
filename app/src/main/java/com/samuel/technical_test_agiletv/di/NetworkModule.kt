package com.samuel.technical_test_agiletv.di

import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonDetailsService
import com.samuel.technical_test_agiletv.data.remote.api.ApiPokemonService
import com.samuel.technical_test_agiletv.utils.API_POKEMON
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * # NetworkModule
 *
 * This Dagger Hilt module provides dependencies related to networking,
 * specifically for making API calls using Retrofit and OkHttp.
 *
 * It is installed in the [SingletonComponent], meaning the provided
 * dependencies will have a singleton scope and will be available
 * throughout the application's lifecycle.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  /**
   * # provideHttpClient
   *
   * Provides an instance of [OkHttpClient].
   *
   * [OkHttpClient] is a powerful HTTP client that can be used to
   * configure network requests, such as adding interceptors,
   * setting timeouts, and more.
   *
   * In this case, a basic [OkHttpClient] is provided with default
   * configurations.
   *
   * @return An instance of [OkHttpClient].
   */
  @Provides
  fun provideHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
  }

  /**
   *
   * Provides an instance of [Retrofit].
   *
   * [Retrofit] is a type-safe HTTP client for Android and Java.
   * It simplifies the process of making network requests and
   * handling responses.
   *
   * This function configures [Retrofit] with:
   * - A base URL ([API_POKEMON]).
   * - The provided [OkHttpClient] for handling network requests.
   * - [GsonConverterFactory] for converting JSON responses to Kotlin objects.
   *
   * @param okHttpClient The [OkHttpClient] instance to use for network requests.
   * @return An instance of [Retrofit].
   */

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(API_POKEMON)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  /**
   * # provideApiPokemonsService
   *
   * Provides an instance of [ApiPokemonService].
   *
   * [ApiPokemonService] is an interface that defines the API endpoints
   * for interacting with the Pokemon API.
   *
   * This function uses the provided [Retrofit] instance to create
   * an implementation of the [ApiPokemonService] interface.
   *
   * @param retrofit The [Retrofit] instance to use for creating the API service.
   * @return An instance of [ApiPokemonService].
   */

  @Provides
  @Singleton
  fun provideApiPokemonsService(retrofit: Retrofit): ApiPokemonService {
    return retrofit.create(ApiPokemonService::class.java)
  }

  /**
   * # provideApiPokemonsService
   *
   * Provides an instance of [ApiPokemonDetailsService].
   *
   * [ApiPokemonDetailsService] is an interface that defines the API endpoints
   * for interacting with about the Pokemon selected.
   *
   * This function uses the provided [Retrofit] instance to create
   * an implementation of the [ApiPokemonDetailsService] interface.
   *
   * @param retrofit The [Retrofit] instance to use for creating the API service.
   * @return An instance of [ApiPokemonDetailsService].
   */

  @Provides
  @Singleton
  fun provideApiPokemonDetailsService(retrofit: Retrofit): ApiPokemonDetailsService {
    return retrofit.create(ApiPokemonDetailsService::class.java)
  }
}