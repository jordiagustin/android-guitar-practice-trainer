package com.github.jordiagustin.androidguitarpracticetrainer.ui.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordDiagram
import com.github.jordiagustin.androidguitarpracticetrainer.model.StringStatus

private const val CHORD_DIAGRAM_LABEL = "Chord diagram"
private const val CHORD_DIAGRAM_MISSING_TEXT = "diagram coming soon"

private const val OPEN_STRING_LABEL = "O"
private const val MUTED_STRING_LABEL = "X"

private val BodyFontSize = 18.sp
private val SmallSpacing = 8.dp
private val ChordDiagramHeight = 160.dp

private const val CHORD_DIAGRAM_STRING_COUNT = 6
private const val CHORD_DIAGRAM_FRET_COUNT = 5
private const val CHORD_DIAGRAM_HORIZONTAL_PADDING = 32f
private const val CHORD_DIAGRAM_VERTICAL_PADDING = 32f
private const val CHORD_DIAGRAM_LINE_STROKE_WIDTH = 2f
private const val CHORD_DIAGRAM_FINGER_RADIUS = 10f
private const val CHORD_DIAGRAM_INDICATOR_TEXT_SIZE = 28f
private const val CHORD_DIAGRAM_INDICATOR_TOP_OFFSET = 6f

@Composable
fun ChordDiagramView(
    chordName: String,
    chordDiagram: ChordDiagram?
) {
    Text(
        text = CHORD_DIAGRAM_LABEL,
        fontSize = BodyFontSize,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(SmallSpacing))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(ChordDiagramHeight)
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val horizontalPadding = CHORD_DIAGRAM_HORIZONTAL_PADDING
            val verticalPadding = CHORD_DIAGRAM_VERTICAL_PADDING

            val diagramLeft = horizontalPadding
            val diagramRight = size.width - horizontalPadding
            val diagramTop = verticalPadding
            val diagramBottom = size.height - verticalPadding

            val stringCount = CHORD_DIAGRAM_STRING_COUNT
            val fretCount = CHORD_DIAGRAM_FRET_COUNT

            for (stringIndex in 0 until stringCount) {
                val x = diagramLeft +
                        (diagramRight - diagramLeft) * stringIndex / (stringCount - 1)

                drawLine(
                    color = Color.Gray,
                    start = Offset(x, diagramTop),
                    end = Offset(x, diagramBottom),
                    strokeWidth = CHORD_DIAGRAM_LINE_STROKE_WIDTH
                )
            }

            for (fretIndex in 0..fretCount) {
                val y = diagramTop +
                        (diagramBottom - diagramTop) * fretIndex / fretCount

                drawLine(
                    color = Color.Gray,
                    start = Offset(diagramLeft, y),
                    end = Offset(diagramRight, y),
                    strokeWidth = CHORD_DIAGRAM_LINE_STROKE_WIDTH
                )
            }

            chordDiagram?.stringPositions
                ?.filter { stringPosition ->
                    stringPosition.status == StringStatus.FRETTED &&
                            stringPosition.fret != null
                }
                ?.forEach { stringPosition ->
                    val stringIndex = 6 - stringPosition.stringNumber

                    val x = diagramLeft +
                            (diagramRight - diagramLeft) * stringIndex / (stringCount - 1)

                    val fret = stringPosition.fret ?: return@forEach

                    val y = diagramTop +
                            (diagramBottom - diagramTop) * (fret - 0.5f) / fretCount

                    drawCircle(
                        color = Color.Black,
                        radius = CHORD_DIAGRAM_FINGER_RADIUS,
                        center = Offset(x, y)
                    )
                }

            chordDiagram?.stringPositions
                ?.filter { stringPosition ->
                    stringPosition.status == StringStatus.OPEN ||
                            stringPosition.status == StringStatus.MUTED
                }
                ?.forEach { stringPosition ->
                    val stringIndex = 6 - stringPosition.stringNumber

                    val x = diagramLeft +
                            (diagramRight - diagramLeft) * stringIndex / (stringCount - 1)

                    val y = diagramTop - CHORD_DIAGRAM_INDICATOR_TOP_OFFSET

                    val label = when (stringPosition.status) {
                        StringStatus.OPEN -> OPEN_STRING_LABEL
                        StringStatus.MUTED -> MUTED_STRING_LABEL
                        StringStatus.FRETTED -> ""
                    }

                    drawContext.canvas.nativeCanvas.drawText(
                        label,
                        x,
                        y,
                        Paint().apply {
                            color = android.graphics.Color.BLACK
                            textAlign = Paint.Align.CENTER
                            textSize = CHORD_DIAGRAM_INDICATOR_TEXT_SIZE
                            typeface = Typeface.DEFAULT_BOLD
                        }
                    )
                }
        }

        if (chordDiagram == null) {
            Text(
                text = "$chordName $CHORD_DIAGRAM_MISSING_TEXT",
                fontSize = BodyFontSize,
                textAlign = TextAlign.Center
            )
        }
    }
}