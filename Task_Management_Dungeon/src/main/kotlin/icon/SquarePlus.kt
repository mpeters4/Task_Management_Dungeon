package icon

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun squarePlusIcon(c: Color): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "SquarePlus",
            defaultWidth = 128.dp,
            defaultHeight = 128.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
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
                moveTo(17f, 12f)
                curveToRelative(0f, 0.553f, -0.448f, 1f, -1f, 1f)
                horizontalLineToRelative(-3f)
                verticalLineToRelative(3f)
                curveToRelative(0f, 0.553f, -0.448f, 1f, -1f, 1f)
                reflectiveCurveToRelative(-1f, -0.447f, -1f, -1f)
                verticalLineToRelative(-3f)
                horizontalLineToRelative(-3f)
                curveToRelative(-0.552f, 0f, -1f, -0.447f, -1f, -1f)
                reflectiveCurveToRelative(0.448f, -1f, 1f, -1f)
                horizontalLineToRelative(3f)
                verticalLineToRelative(-3f)
                curveToRelative(0f, -0.553f, 0.448f, -1f, 1f, -1f)
                reflectiveCurveToRelative(1f, 0.447f, 1f, 1f)
                verticalLineToRelative(3f)
                horizontalLineToRelative(3f)
                curveToRelative(0.552f, 0f, 1f, 0.447f, 1f, 1f)
                close()
                moveToRelative(7f, -7f)
                verticalLineToRelative(14f)
                curveToRelative(0f, 2.757f, -2.243f, 5f, -5f, 5f)
                horizontalLineTo(5f)
                curveToRelative(-2.757f, 0f, -5f, -2.243f, -5f, -5f)
                verticalLineTo(5f)
                curveTo(0f, 2.243f, 2.243f, 0f, 5f, 0f)
                horizontalLineToRelative(14f)
                curveToRelative(2.757f, 0f, 5f, 2.243f, 5f, 5f)
                close()
                moveToRelative(-2f, 0f)
                curveToRelative(0f, -1.654f, -1.346f, -3f, -3f, -3f)
                horizontalLineTo(5f)
                curveToRelative(-1.654f, 0f, -3f, 1.346f, -3f, 3f)
                verticalLineToRelative(14f)
                curveToRelative(0f, 1.654f, 1.346f, 3f, 3f, 3f)
                horizontalLineToRelative(14f)
                curveToRelative(1.654f, 0f, 3f, -1.346f, 3f, -3f)
                verticalLineTo(5f)
                close()
            }
        }.build()
    }
}
