package com.refanzzzz.waterquality

import androidx.compose.runtime.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.KobwebApp
import com.varabyte.kobweb.silk.SilkApp

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        KobwebApp {
            content()
        }
    }
}
