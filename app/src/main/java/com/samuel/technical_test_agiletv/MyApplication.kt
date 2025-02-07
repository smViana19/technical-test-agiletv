package com.samuel.technical_test_agiletv

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * The main application class for the app.
 *
 * This class is annotated with [HiltAndroidApp], which triggers Hilt's code generation
 * and sets up the application-level dependency injection container. This container
 * provides dependencies to the entire application.
 *
 * All apps that use Hilt must contain an [Application] class annotated with [HiltAndroidApp].
 */

@HiltAndroidApp
class MyApplication : Application() {
}