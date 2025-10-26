package com.example.singupmarvel.ui.components.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
@Composable
fun  PasswordIcon() : ImageVector {

    return   ImageVector.Builder(
        name = "Password",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 960f,
        viewportHeight = 960f
    ).apply {
        path(
            fill = SolidColor(Color(0xFF000000))
        ) {
            moveTo(80f, 760f)
            verticalLineToRelative(-80f)
            horizontalLineToRelative(800f)
            verticalLineToRelative(80f)
            close()
            moveToRelative(46f, -242f)
            lineToRelative(-52f, -30f)
            lineToRelative(34f, -60f)
            horizontalLineTo(40f)
            verticalLineToRelative(-60f)
            horizontalLineToRelative(68f)
            lineToRelative(-34f, -58f)
            lineToRelative(52f, -30f)
            lineToRelative(34f, 58f)
            lineToRelative(34f, -58f)
            lineToRelative(52f, 30f)
            lineToRelative(-34f, 58f)
            horizontalLineToRelative(68f)
            verticalLineToRelative(60f)
            horizontalLineToRelative(-68f)
            lineToRelative(34f, 60f)
            lineToRelative(-52f, 30f)
            lineToRelative(-34f, -60f)
            close()
            moveToRelative(320f, 0f)
            lineToRelative(-52f, -30f)
            lineToRelative(34f, -60f)
            horizontalLineToRelative(-68f)
            verticalLineToRelative(-60f)
            horizontalLineToRelative(68f)
            lineToRelative(-34f, -58f)
            lineToRelative(52f, -30f)
            lineToRelative(34f, 58f)
            lineToRelative(34f, -58f)
            lineToRelative(52f, 30f)
            lineToRelative(-34f, 58f)
            horizontalLineToRelative(68f)
            verticalLineToRelative(60f)
            horizontalLineToRelative(-68f)
            lineToRelative(34f, 60f)
            lineToRelative(-52f, 30f)
            lineToRelative(-34f, -60f)
            close()
            moveToRelative(320f, 0f)
            lineToRelative(-52f, -30f)
            lineToRelative(34f, -60f)
            horizontalLineToRelative(-68f)
            verticalLineToRelative(-60f)
            horizontalLineToRelative(68f)
            lineToRelative(-34f, -58f)
            lineToRelative(52f, -30f)
            lineToRelative(34f, 58f)
            lineToRelative(34f, -58f)
            lineToRelative(52f, 30f)
            lineToRelative(-34f, 58f)
            horizontalLineToRelative(68f)
            verticalLineToRelative(60f)
            horizontalLineToRelative(-68f)
            lineToRelative(34f, 60f)
            lineToRelative(-52f, 30f)
            lineToRelative(-34f, -60f)
            close()
        }
    }.build()

    return _Password!!
}

private var _Password: ImageVector? = null


