package icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun RectangleList(c: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "RectangleList",
            defaultWidth = 128.dp,
            defaultHeight = 128.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
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
                moveTo(21f, 1f)
                horizontalLineTo(3f)
                curveTo(1.346f, 1f, 0f, 2.346f, 0f, 4f)
                verticalLineToRelative(19f)
                horizontalLineToRelative(24f)
                verticalLineTo(4f)
                curveToRelative(0f, -1.654f, -1.346f, -3f, -3f, -3f)
                close()
                moveToRelative(1f, 20f)
                horizontalLineTo(2f)
                verticalLineTo(4f)
                curveToRelative(0f, -0.551f, 0.449f, -1f, 1f, -1f)
                horizontalLineToRelative(18f)
                curveToRelative(0.551f, 0f, 1f, 0.449f, 1f, 1f)
                verticalLineToRelative(17f)
                close()
                moveTo(10f, 6f)
                horizontalLineToRelative(9f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-9f)
                verticalLineToRelative(-2f)
                close()
                moveToRelative(-2f, 1f)
                curveToRelative(0f, 0.828f, -0.672f, 1.5f, -1.5f, 1.5f)
                reflectiveCurveToRelative(-1.5f, -0.672f, -1.5f, -1.5f)
                reflectiveCurveToRelative(0.672f, -1.5f, 1.5f, -1.5f)
                reflectiveCurveToRelative(1.5f, 0.672f, 1.5f, 1.5f)
                close()
                moveToRelative(2f, 4f)
                horizontalLineToRelative(9f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-9f)
                verticalLineToRelative(-2f)
                close()
                moveToRelative(-2f, 1f)
                curveToRelative(0f, 0.828f, -0.672f, 1.5f, -1.5f, 1.5f)
                reflectiveCurveToRelative(-1.5f, -0.672f, -1.5f, -1.5f)
                reflectiveCurveToRelative(0.672f, -1.5f, 1.5f, -1.5f)
                reflectiveCurveToRelative(1.5f, 0.672f, 1.5f, 1.5f)
                close()
                moveToRelative(2f, 4f)
                horizontalLineToRelative(9f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-9f)
                verticalLineToRelative(-2f)
                close()
                moveToRelative(-2f, 1f)
                curveToRelative(0f, 0.828f, -0.672f, 1.5f, -1.5f, 1.5f)
                reflectiveCurveToRelative(-1.5f, -0.672f, -1.5f, -1.5f)
                reflectiveCurveToRelative(0.672f, -1.5f, 1.5f, -1.5f)
                reflectiveCurveToRelative(1.5f, 0.672f, 1.5f, 1.5f)
                close()
            }
        }.build()
    }
}