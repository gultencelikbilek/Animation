package com.example.animationtutorial.animaiton

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animationtutorial.R

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedVectorDrawable() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        //state : animasyonun hangi durumda(görünür görünmez) olduğunu kotnrol eder
        val state = remember { mutableStateOf(false) }

        //rememberAnimatedVectorPainter: Bu, animasyonlu vektör grafiği boyamak için kullanılır.
        val painter = rememberAnimatedVectorPainter(
            animatedImageVector = AnimatedImageVector.animatedVectorResource(id = R.drawable.avd_check_uncheck),
            atEnd = state.value
        )
        Box(){
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        state.value = !state.value
                    }
                ,
                painter = painter,
                contentDescription = ""
            )
        }
    }
}