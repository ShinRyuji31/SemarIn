package com.example.application.ui.component.global

import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedText(
    text: String,
    modifier: Modifier = Modifier
) {

    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier
    ) {

        val textLayoutResult = textMeasurer.measure(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )

        val x = (size.width - textLayoutResult.size.width) / 2
        val y = (size.height - textLayoutResult.size.height) / 2

        drawText(
            textLayoutResult = textLayoutResult,
            color = Color.White,
            topLeft = Offset(x, y),
            drawStyle = Stroke(width = 4f)
        )

        drawText(
            textLayoutResult = textLayoutResult,
            color = Color(0xFF2D9CDB),
            topLeft = Offset(x, y)
        )
    }
}