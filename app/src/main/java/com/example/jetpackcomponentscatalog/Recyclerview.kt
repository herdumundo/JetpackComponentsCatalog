package com.example.jetpackcomponentscatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.model.Superhero
import kotlinx.coroutines.launch


@Composable
fun SuperHeroStickyView() {
    val rvState = rememberLazyListState()
    var context = LocalContext.current
    //val superhero:Map

    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(state = rvState, modifier = Modifier
            .weight(1f)
            .padding(10.dp), content = {
            items(getSuperheroes()) {
                ItemHero(superhero = it) {
                    Toast.makeText(
                        context,
                        it.superheroName,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
        val showButton by remember {
            derivedStateOf { rvState.firstVisibleItemIndex > 0 }
        }
        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch { rvState.animateScrollToItem(0)  }

                          },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Ir para arriba")
            }
        }
    }
}


@Composable
fun SuperHeroWithSpecialControlView() {
    val rvState = rememberLazyListState()
    var context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(state = rvState, modifier = Modifier
            .weight(1f)
            .padding(10.dp), content = {
            items(getSuperheroes()) {
                ItemHero(superhero = it) {
                    Toast.makeText(
                        context,
                        it.superheroName,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
        val showButton by remember {
            derivedStateOf { rvState.firstVisibleItemIndex > 0 }
        }
        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch { rvState.animateScrollToItem(0)  }

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Ir para arriba")
            }
        }
    }
}


@Composable
fun SimpleRecyclerView() {

    LazyColumn(Modifier.fillMaxWidth()) {
        item { Text(text = "Primer item") }
        items(1000) {
            Text(text = "Primer item $it")
        }
    }
}

@Composable
fun SuperHeroView() {
    var context = LocalContext.current
    LazyColumn() {
        items(getSuperheroes()) {
            ItemHero(superhero = it) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun SuperHeroGridView() {
    var context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(10.dp), content = {
        items(getSuperheroes()) {
            ItemHero(superhero = it) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
            }
        }

    })

}

@Composable
fun ItemHero(superhero: Superhero, OnItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Blue),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { OnItemSelected(superhero) }) {
        Column() {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Super Hero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(4.dp),
                fontSize = 10.sp
            )
        }

    }
}

fun getSuperheroes(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "Marvel", R.drawable.wonder_woman)
    )
}