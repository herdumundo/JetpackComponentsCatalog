package com.example.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //  var myText by remember { mutableStateOf("")}
          //  MyTextFieldOutLined(myText) {myText=it}
           // MyCheckBoxWithText()


         //   MyCheckBoxWithTextCompleted(checkInfo)
        val myOptions = getOptions(listOf("600901","600902","600903","600905","600967","600998","6005033","600852","600900","600125","602358"))

            Column {
                myOptions.forEach {MyCheckBoxWithTextCompleted(it)}
            }

        }
    }
}

@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable{ mutableStateOf(ToggleableState.Indeterminate) }

   
}
@Composable
fun getOptions(titles:List<String>):List<CheckInfo>{
  return  titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
       CheckInfo(
            tittle = it,
            selected = status,
            onCheckedChange = {status=it}
       )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo){

    Row(Modifier.padding(8.dp)) {

        Checkbox( checked = checkInfo.selected,  onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)},
        )
        Spacer(modifier = Modifier.width(1.dp))
        Text(text = checkInfo.tittle)


    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

 @Composable
fun GreetingPreview() {
    JetpackComponentsCatalogTheme {
        Greeting("Android")
    }
}
@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()){
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .weight(1f)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Red)
                    .weight(1f)
            )

            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1f)
            )
        }


        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .weight(1f)
        )
    }
}

@Composable
fun MyStateExample(){
var counter by rememberSaveable  { mutableStateOf(0) }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = { counter +=1 }) {
            Text(text = "Pulsar")
            
        }
        Text(text = "He sido pulsado ${counter} veces")

    }
}
@Composable
fun Mytext(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo",color= Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo",  fontFamily = FontFamily.Cursive )
        Text(text = "Esto es un ejemplo",  fontSize = 30.sp,fontFamily = FontFamily.Cursive )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MytextField(){
    var myText by remember {
        mutableStateOf("")
    }

    TextField(value = myText, onValueChange = {myText= it })
}
 @ExperimentalMaterial3Api
@Composable
fun MytextFieldAdvance(){
    var myText by remember {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = {
            myText= if (it.contains("a")){
                it.replace("a","")
            }else{
                it
            }
        },
        label = { Text(text = "Introduce tu nombre")})
}
  @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutLined(myText:String,onValueChange:(String)->Unit ){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {

        OutlinedTextField( modifier= Modifier
            .padding(24.dp)
            .fillMaxWidth(),
            value = myText,
            onValueChange = { onValueChange(it)
            },
            label = { Text(text = "Introduce tu nombre")},
            colors=TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Red, unfocusedBorderColor = Color.Blue))
    }
}

 @Composable
fun MyButtonExample(){
var enabled by rememberSaveable {  mutableStateOf(true)}
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        Button(
            onClick = {enabled=false  },
            enabled=enabled,
            colors =  ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black ),
            border = BorderStroke(2.dp, Color.Yellow) ) {
            Text(text = "Hola")

        }
        OutlinedButton(
            onClick = {   },
            enabled=enabled,

            colors =  ButtonDefaults.buttonColors(
                 contentColor = Color.White,
                 containerColor = Color.Black ,
             disabledContainerColor = Color.Red
             ),
            border = BorderStroke(2.dp, Color.Black) ) {
            Text(text = "OutLined")

        }

        TextButton(onClick = { }, border = BorderStroke(2.dp, Color.Black)) {
          Text(text = "Hola mundo")
            
        }
    }
}
@Composable
fun MyImage(){
    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription ="Ejercicio", alpha=0.5f)
}
@Composable
fun MyImageAdvance(){

    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription ="Ejercicio",
        alpha=0.5f,
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape))
}

@Composable
fun MyIcon(){
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "icono",
        tint= Color.Red
    )
}
@Preview
@Composable
fun MyProgress(){
    var showLoading by rememberSaveable {
        mutableStateOf(false)

    }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally) {

        if(showLoading){

        CircularProgressIndicator(color= Color.Red)
        LinearProgressIndicator(modifier = Modifier.padding(top=32.dp), color = Color.Red, contentColorFor(
            backgroundColor = Color.Red
        ))

        }

        Button(onClick = { showLoading=!showLoading}) {
            Text(text = "Cargar Perfil")
            
        }
    }
}

@Composable
fun MyProgressAdvance(){
    var porcentaje by rememberSaveable {
        mutableStateOf(0f)}
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally) {


            CircularProgressIndicator(progress =  porcentaje )


        Button(onClick = { porcentaje+=0.1f }) {
            Text(text = "Incrementar")

        }

        Button(onClick = { porcentaje-=0.1f }) {
            Text(text = "Disminuir")

        }
    }
}
@Preview
@Composable
fun MySwitch(){
    var state by rememberSaveable{ mutableStateOf(true) }
Switch(checked = state, onCheckedChange ={state=!state}, enabled = true, colors = SwitchDefaults.colors(
    uncheckedThumbColor = Color.Red,
    uncheckedTrackColor = Color.Cyan,
    checkedThumbColor = Color.Green,

 ) )
}

@Composable
fun MyCheckBox(){
    var state by rememberSaveable{ mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = {state=!state},
        colors=CheckboxDefaults.colors(
            uncheckedColor = Color.Black,
            checkedColor = Color.Red,
            checkmarkColor = Color.White
    ))

}

@Composable
fun MyCheckBoxWithText(){
    var state by rememberSaveable{ mutableStateOf(true) }

     Row(Modifier.padding(8.dp)) {

        Checkbox( checked = state,  onCheckedChange = {state=!state},
             )
        Spacer(modifier = Modifier.width(1.dp))
        Text(text = "Ejemplo 1")


 }

}


