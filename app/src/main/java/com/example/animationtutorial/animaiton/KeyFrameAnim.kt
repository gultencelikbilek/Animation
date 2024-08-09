package com.example.animationtutorial.animaiton

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun KeyFrameAnim() {
    //InfiniteTransition, sonsuz bir döngüde animasyonlar oluşturmanıza olanak tanır.
    val infiniteTrans = rememberInfiniteTransition()
    val degree by infiniteTrans.animateFloat(
        initialValue = 0f, //Animasyonun başlangıç değeri.
        targetValue = 359f, //Animasyonun bitiş değeri.
        //animationSpec: Animasyonun nasıl çalışacağını belirler.
        animationSpec = infiniteRepeatable( //Animasyonun sonsuz döngüde tekrarlanmasını sağlar
            animation = keyframes { //keyFrames: Belirli zamanlarda belirli değerleri almasını sağlar.
                durationMillis = 3000
                0f at 0
                359f at 2000
            }
        ), label = ""
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Rotate me", modifier = Modifier.rotate(degree))
    }
}

@Composable
fun InfinitelyPulsingHeart() {

    val infiniteTransition = rememberInfiniteTransition()

    val scale by infiniteTransition.animateFloat(
        initialValue = 3f,
        targetValue = 6f,
        animationSpec = infiniteRepeatable(
            // 1000ms süren bir tween animasyonunu varsayılan easing eğrisi kullanarak sonsuz döngüde tekrarlar.
            animation = tween(1000),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    // [InfiniteTransition]'ın bir parçası olarak bir Renk animasyonu oluşturur.
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color(0xff800000), // Dark Red
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            //repeatMode = RepeatMode.Reverse
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    Box(Modifier.fillMaxSize()) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale
                ),
            tint = color
        )
    }
}

@Composable
fun InfiniteTransitionExampleThree(modifier: Modifier = Modifier) {

    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = 100.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 500
                0.dp at 200 // ms
                80.dp at 300 using FastOutLinearInEasing
            }
        ), label = ""
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        Box(
            Modifier.offset(x = offsetX),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Rotate me", style = TextStyle(
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

