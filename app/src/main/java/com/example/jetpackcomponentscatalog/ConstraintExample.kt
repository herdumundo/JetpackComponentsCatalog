package com.example.jetpackcomponentscatalog


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

 @Composable
fun ConstraintExample1() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxCyan, boxYellow, boxMagenta, boxBlack, boxGreen, boxBlue, boxWhite, boxGray) = createRefs()
        val (boxiBlack,  boxiGreen, boxiGray, boxiWhite) = createRefs()



        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            }
        )


        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            }
        )

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)

            }
        )
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.start)
            }
        )


        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.White)
            .constrainAs(boxWhite) {
                top.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            }
        )


        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
            .constrainAs(boxGray) {
                bottom.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)

            }
        )



        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.start)
            }



        ){
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {


            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Gray)
                .constrainAs(boxiGray) {
                    start.linkTo(boxiWhite.end)
                }
            )

            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Black)
                .constrainAs(boxiBlack) {
                    top.linkTo(boxiWhite.bottom)
                    start.linkTo(boxiWhite.end)
                }
            )

            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(boxiGreen) {
                    top.linkTo(boxiWhite.bottom)

                }
            )

            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.White)
                .constrainAs(boxiWhite) {

                }
            )
        } }

  
    }
}

 @Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(Modifier.fillMaxSize()) {
//        val startGuide = createGuidelineFromTop(16.dp)

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

    }
}

@Composable
fun ConstraintBarrier() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(235.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box(
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier)
                })
    }
}
@Preview
@Composable
fun ConstraintChainExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {


        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(boxGreen.end)
                end.linkTo(boxYellow.start)
            })

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxRed.end)
                    end.linkTo(parent.end)
                })

        createVerticalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.Spread)

    }
}















