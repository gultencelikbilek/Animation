package com.example.animationtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.animationtutorial.animaiton.AnimatedVectorDrawable
import com.example.animationtutorial.animaiton.InfinitelyPulsingHeart
import com.example.animationtutorial.animaiton.KeyFrameAnim
import com.example.animationtutorial.ui.theme.AnimationTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationTutorialTheme {
                //LottieExample()
                //AnimatedVectorDrawable()
                //KeyFrameAnim()
                //InfinitelyPulsingHeart()
            }
        }
    }
}
