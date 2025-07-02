package com.refanzzzz.waterquality.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@OptIn(ExperimentalComposeWebApi::class)
val NavBarStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(20.px)
            .position(Position.Fixed)
            .top(0.percent)
            .transition(Transition.of("ease-in-out", 0.32.s))
            .backgroundColor(Color.black)
            .opacity(0.6)
            .zIndex(10)
    }
    hover {
        Modifier.opacity(1)
    }
}