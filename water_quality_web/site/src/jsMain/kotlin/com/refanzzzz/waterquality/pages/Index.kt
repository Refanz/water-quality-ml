package com.refanzzzz.waterquality.pages

import androidx.compose.runtime.Composable
import com.refanzzzz.waterquality.components.sections.landingpage.Footer
import com.refanzzzz.waterquality.components.sections.landingpage.Hero
import com.refanzzzz.waterquality.components.sections.landingpage.NavBar
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .overflow(
                    Overflow.Hidden
                ),
            verticalArrangement = Arrangement.Top
        ) {
            NavBar()
            Hero()
            Footer()
        }
    }
}
