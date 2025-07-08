package com.refanzzzz.waterquality.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.selectors.link
import com.varabyte.kobweb.silk.style.selectors.visited
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
val NavBarStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(16.px)
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

val NavLinkStyle = CssStyle {
    base {
        Modifier.fontWeight(400)
            .letterSpacing(0.8.px)
            .fontSize(18.px)
            .opacity(0.75)
    }
    link {
        Modifier.color(Color.white)
    }
    visited {
        Modifier.color(Color.white)
    }
    hover {
        Modifier.opacity(1)
    }
    active {
        Modifier.opacity(1)
    }
}

val NavButtonStyle = CssStyle {
    base {
        Modifier
            .fontWeight(700)
            .color(Color.white)
            .border(1.px, LineStyle.Solid, Color.white)
            .padding(18.px, 34.px)
            .fontSize(18.px)
            .margin(left = 18.px)
            .position(Position.Relative)
            .backgroundColor(Color.transparent)
            .transition(Transition.of("ease-in-out", 0.3.s))
    }
    before {
        Modifier
            .content("")
            .width(0.percent)
            .height(100.percent)
            .position(Position.Absolute)
            .backgroundColor(Color.white)
            .top(0.percent)
            .left(0.percent)
            .transition(Transition.of("ease-in-out", 0.3.s))
    }
    hover {
        Modifier
            .color(Color("#121212"))
    }
}