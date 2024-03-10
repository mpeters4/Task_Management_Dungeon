package icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun exitIcon(c: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "Exit",
            defaultWidth =128.dp,
            defaultHeight = 128.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color.LightGray),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(170.698f, 448f)
                    horizontalLineTo(72.757f)
                    curveToRelative(-4.814f, -0.012f, -8.714f, -3.911f, -8.725f, -8.725f)
                    verticalLineTo(72.725f)
                    curveToRelative(0.012f, -4.814f, 3.911f, -8.714f, 8.725f, -8.725f)
                    horizontalLineToRelative(97.941f)
                    curveToRelative(17.673f, 0f, 32f, -14.327f, 32f, -32f)
                    reflectiveCurveToRelative(-14.327f, -32f, -32f, -32f)
                    horizontalLineTo(72.757f)
                    curveTo(32.611f, 0.047f, 0.079f, 32.58f, 0.032f, 72.725f)
                    verticalLineToRelative(366.549f)
                    curveTo(0.079f, 479.42f, 32.611f, 511.953f, 72.757f, 512f)
                    horizontalLineToRelative(97.941f)
                    curveToRelative(17.673f, 0f, 32f, -14.327f, 32f, -32f)
                    reflectiveCurveTo(188.371f, 448f, 170.698f, 448f)
                    close()
                }
                path(
                    fill = SolidColor(c),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(483.914f, 188.117f)
                    lineToRelative(-82.816f, -82.752f)
                    curveToRelative(-12.501f, -12.495f, -32.764f, -12.49f, -45.259f, 0.011f)
                    reflectiveCurveToRelative(-12.49f, 32.764f, 0.011f, 45.259f)
                    lineToRelative(72.789f, 72.768f)
                    lineTo(138.698f, 224f)
                    curveToRelative(-17.673f, 0f, -32f, 14.327f, -32f, 32f)
                    reflectiveCurveToRelative(14.327f, 32f, 32f, 32f)
                    lineToRelative(0f, 0f)
                    lineToRelative(291.115f, -0.533f)
                    lineToRelative(-73.963f, 73.963f)
                    curveToRelative(-12.042f, 12.936f, -11.317f, 33.184f, 1.618f, 45.226f)
                    curveToRelative(12.295f, 11.445f, 31.346f, 11.436f, 43.63f, -0.021f)
                    lineToRelative(82.752f, -82.752f)
                    curveToRelative(37.491f, -37.49f, 37.491f, -98.274f, 0.001f, -135.764f)
                    curveToRelative(0f, 0f, -0.001f, -0.001f, -0.001f, -0.001f)
                    lineTo(483.914f, 188.117f)
                    close()
                }
            }
        }.build()
    }
}

