package com.refanzzzz.waterquality.sections.landingpage

import androidx.compose.runtime.Composable
import com.refanzzzz.waterquality.styles.NavBarStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.toModifier
import com.refanzzzz.waterquality.util.Assets
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@OptIn(DelicateApi::class)
@Composable
fun NavBar() {

//    val breakpoint by rememberBreakpoint()

    Box(
        modifier = NavBarStyle.toModifier()
    ) {
        Row(
          modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                src = Assets.WATER_ICON,
                modifier = Modifier
                    .size(24.px)
            )
        }
    }
}

