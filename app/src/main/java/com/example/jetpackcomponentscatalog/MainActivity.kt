package com.example.jetpackcomponentscatalog


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                SuperHeroStickyView()

            /*  Surface() {

                    var show by rememberSaveable { mutableStateOf(false)

                    }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Button(onClick = { show=true }) {
                            Text(text = "Mostrar Dialogo")  }

                        // MyDialog(show=show, onOcultar ={show=false }, onConfirm = {Log.i("Hernan","Click")} )
                        MyConfirmationDialog(
                            show = show,
                            onOcultar = { show=false }) {

                        }

                    }
                }*/
            }



          //  var myText by remember { mutableStateOf("")}
          //  MyTextFieldOutLined(myText) {myText=it}
           // MyCheckBoxWithText()


         //   MyCheckBoxWithTextCompleted(checkInfo)
   //     val myOptions = getOptions(listOf("600901","600902","600903","600905","600967","600998","6005033","600852","600900","600125","602358"))
    //    var selected by rememberSaveable { mutableStateOf("Ejemplo 1") }

            /*  Column {
                /* myOptions.forEach {
                  //   MyCheckBoxWithTextCompleted(it)
                     RadioButton (it.tittle)
                 }*/
                  MyRadioButtonList(selected){selected=it}
              }*/

        }
    }
}

@Preview
@Composable
fun MyDropDownMenu(){
    var selectedText by rememberSaveable {mutableStateOf("")}
    var expanded by rememberSaveable {mutableStateOf(false)}
    val desserts= listOf("Helado","Chocolate","Vainilla","Frutas","Comida","cafe")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value =selectedText ,
            onValueChange = {selectedText=it},
            enabled = false,
            readOnly = true,
            modifier= Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded=false },
            modifier= Modifier.fillMaxWidth()
        ) {
            desserts.forEach{ desserts ->
                DropdownMenuItem(  onClick = {
                    expanded=false
                    selectedText=desserts
                }  ) {
                    Text(text = desserts)

                }
                    
                }
        
    }
    }}
@Composable
fun MyDivider(){
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), color = Color.Red)
}

 @Composable
     fun MyBadgeBox() {
        Box(modifier = Modifier.padding(16.dp)
        ) {
            BadgedBox(

                modifier =  Modifier.padding(16.dp),

                badge = { Badge { Text(text = "1") } }
            )
            {
                Icon( imageVector = Icons.Default.Star, contentDescription = "" )

            }
        }
    }

@Composable
fun MyCard(){   Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
    elevation = 12.dp,
    shape = MaterialTheme.shapes.medium,
    //backgroundColor = Color.Red,
   // contentColor = Color.Green,
    border = BorderStroke(5.dp, Color.Black)
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2")
        Text(text = "Ejemplo 3")
    }
}
}
@Composable
fun MyRadioButtonList(name:String,AlSeleccionar:(String) ->Unit){
   Column(Modifier.fillMaxWidth())
   {
        Row(Modifier
            .fillMaxWidth()
            .clickable(onClick = { AlSeleccionar("EJEMPLO1") })) {
            RadioButton(selected = name=="EJEMPLO1",  onClick = { AlSeleccionar("EJEMPLO1")} )
            Text(text ="EJEMPLO1" )
            }
        Row(Modifier
            .fillMaxWidth()
            .clickable(onClick = { AlSeleccionar("EJEMPLO2") })) {
            RadioButton(selected = name=="EJEMPLO2", onClick = {AlSeleccionar("EJEMPLO2" )} )
            Text(text ="EJEMPLO2" )
        }
        Row(Modifier
            .fillMaxWidth()
            .clickable(onClick = { AlSeleccionar("EJEMPLO3") })) {
            RadioButton(selected = name=="EJEMPLO3", onClick = { AlSeleccionar("EJEMPLO3")} )
            Text(text ="EJEMPLO3" )
        }
        Row(Modifier
            .fillMaxWidth()
            .clickable(onClick = { AlSeleccionar("EJEMPLO4") }) ) {

            RadioButton(selected = name=="EJEMPLO4", onClick = { AlSeleccionar("EJEMPLO4")} )
            Text(text ="EJEMPLO4")
        }
    }

}

@Composable
fun RadioButton(nombre:String){
    Row(Modifier.fillMaxWidth()) {

        RadioButton(selected = true, onClick = { }, enabled = true, colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red
            , unselectedColor = Color.Yellow
            , disabledColor = Color.Green
        ) )
        Text(text =nombre )
    
    //RadioButton(selected=false,onClick={ })


}  }


@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable{ mutableStateOf(ToggleableState.Indeterminate) }

    TriStateCheckbox(state = status, onClick = {
        status=when(status){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.On
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })

   
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


 @Composable
fun MytextField(){
    var myText by remember {
        mutableStateOf("")
    }

    TextField(value = myText, onValueChange = {myText= it })
}
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
                backgroundColor = Color.Black ),
            border = BorderStroke(2.dp, Color.Yellow) ) {
            Text(text = "Hola")

        }
        OutlinedButton(
            onClick = {   },
            enabled=enabled,

            colors =  ButtonDefaults.buttonColors(
                 contentColor = Color.White,
                backgroundColor = Color.Black ,
             disabledBackgroundColor = Color.Red
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


