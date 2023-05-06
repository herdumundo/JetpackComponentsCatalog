package com.example.jetpackcomponentscatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties




@Composable
fun MyConfirmationDialog(show:Boolean,
                         onOcultar:()-> Unit,
                         onConfirm:()-> Unit){
    if(show){

        Dialog(
            onDismissRequest = {}) {
             Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Listado de Articulos",Modifier.padding(bottom = 24.dp))

                Divider(Modifier.fillMaxWidth(),Color.LightGray)
                var status by remember {    mutableStateOf("")  }

                 MyRadioButtonList(status){status=it}
                Divider(Modifier.fillMaxWidth(),Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = {  }) {
                        Text(text = "Cancelar")
                        
                    }

                    TextButton(onClick = {  }) {
                        Text(text = "Aceptar")

                    }
                }

            }
        }
    }
}



@Composable
fun MyCustomDialog (show:Boolean,
                    onOcultar:()-> Unit,
                    onConfirm:()-> Unit){

    if(show){
        
        Dialog(onDismissRequest = {}) {

            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {


            MyTitleDialog("Set backup account")
                val myOptions = getOptions(listOf("Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com",
                    "Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com",
                    "Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com","Ejemplo1@gmail.com"))

                myOptions.forEach {
                    //   MyCheckBoxWithTextCompleted(it)
                    AccountItem(email = it.tittle, drawable =R.drawable.avatar )
                }
                AccountItem(email = "Añadir nueva cuenta", drawable =R.drawable.add )}


        }

        
    }
}
@Composable
fun AccountItem(email:String,@DrawableRes drawable:Int) {
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = drawable), contentDescription ="Avatar", contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .clip(CircleShape))
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun MyTitleDialog(text:String,modifier: Modifier=Modifier.padding(bottom = 12.dp)){
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        modifier=modifier)
}


@Composable
fun MyDialog(
    show:Boolean,
    onOcultar:()-> Unit,
    onConfirm:()-> Unit,
    ){
    if(show){
    AlertDialog(

        onDismissRequest = { onOcultar() },//SI PULSAMOS HACIA AFUERA NO SALE
        properties = DialogProperties(dismissOnBackPress = false,dismissOnClickOutside = true),// SI PRESIONAMOS EL BOTON ATRAS CON FAALSE NO SALE.
        title = { Text(text = "Titulo")},
        text = { Text(text = "Hola soy una descripcion")},
        confirmButton = {
            TextButton(onClick = {onConfirm()  }) {
                            Text(text = "Aceptar")

                        }
                        },
        dismissButton = { TextButton(onClick = { onOcultar()  }) {
            Text(text = "Cancelar")
        }
        }

    )
    } }