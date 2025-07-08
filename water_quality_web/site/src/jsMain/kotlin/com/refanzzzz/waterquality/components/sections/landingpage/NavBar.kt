package com.refanzzzz.waterquality.components.sections.landingpage

import androidx.compose.runtime.Composable
import com.refanzzzz.waterquality.components.widgets.NavLink
import com.refanzzzz.waterquality.styles.NavBarStyle
import com.refanzzzz.waterquality.styles.NavButtonStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.toModifier
import com.refanzzzz.waterquality.util.Assets
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.verticalAlign
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

@OptIn(DelicateApi::class)
@Composable
fun NavBar() {

//    val breakpoint by rememberBreakpoint()

    Box(
        modifier = NavBarStyle.toModifier()
    ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                src = Assets.WATER_ICON,
                modifier = Modifier
                    .size(64.px)
            )
            NavLinks()
        }
    }
}

@Composable
fun NavLinks(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        NavLink(path = "#home", text = "Home")
        NavLink(path = "#maps", text = "Maps")
        NavLink(path = "#about", text = "About")
        Button(
            onClick = {
                console.log("Login is clicked")
            },
//            modifier = NavButtonStyle.toModifier()
        ) {
            SpanText("Login", Modifier.zIndex(1))
        }
    }
}

