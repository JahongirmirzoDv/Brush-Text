package com.mobiledv.brushtext

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobiledv.brushtext.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrushTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Backround
                ) {

                    val list1 = listOf(Color2, Color11, Color15, Color4)
                    val list2 = listOf(Color5, Color10, Color16, Color2)
                    val list3 = listOf(Color2, Color11, Color15, Color7)
                    val list4 = listOf(Color4, Color9, Color13, Color8)
                    val list5 = listOf(Color3, Color1, Color6, Color12, Color14)

                    val all = listOf(list1, list2, list3, list4,list5)
                    var color by remember {
                        mutableStateOf(list1)
                    }

                    val tileMode =
                        listOf(TileMode.Clamp, TileMode.Decal, TileMode.Mirror, TileMode.Repeated)
                    val brushType = listOf(
                        ScaledThirdBrush(
                            Brush.horizontalGradient(
                                color,
                                tileMode = tileMode.random()
                            ) as ShaderBrush
                        ),
                        ScaledThirdBrush(
                            Brush.verticalGradient(
                                color,
                                tileMode = tileMode.random()
                            ) as ShaderBrush
                        ),
                        ScaledThirdBrush(
                            Brush.radialGradient(
                                color,
                                tileMode = tileMode.random()
                            ) as ShaderBrush
                        ),
                        ScaledThirdBrush(Brush.sweepGradient(color) as ShaderBrush)
                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .fillMaxHeight(0.4f)
                                .background(shape = RoundedCornerShape(25.dp), color = Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.😎️",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(20.dp)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        val brush = brushType.random()
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                                        }
                                    },
                                fontSize = 35.sp,
                            )
                        }
                        Spacer(modifier = Modifier.padding(25.dp))
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .fillMaxHeight(0.15f),
                            onClick = {
                                color = all.random()
                            },
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(
                                text = "NEXT️",
                                modifier = Modifier
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        val brush = Brush.horizontalGradient(color)
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                                        }
                                    },
                                fontSize = 20.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}

class ScaledThirdBrush(val shaderBrush: ShaderBrush) : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        return shaderBrush.createShader(size / 3f)
    }
}
