package com.example.finalproject

import android.content.Intent
import android.graphics.drawable.Icon
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.ui.theme.FinalProjectTheme

class DogDetailsActivity : ComponentActivity() {
    private val dogViewModel: DogViewModel by viewModels()

    private val dogCounterViewModel = DogCounterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dogViewModel.fetchImages()

        setContent {
            val dog_or_cat = AppPreferences(this@DogDetailsActivity).getOptions()
            val icon_dog_or_cat = if(dog_or_cat == "dog") R.drawable.dog_icon else R.drawable.cat_icon
            FinalProjectTheme {
                val dogImages = dogViewModel.items.observeAsState(initial = emptyList())
                val dogSound = MediaPlayer.create(LocalContext.current, R.raw.dogsound)

                LazyColumn {
                    items(dogImages.value) { image ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = image.url,
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                modifier = Modifier
                                    .padding(20.dp),
                                text = "DOG",
                                fontSize = 30.sp
                            )
                        }
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = "1st you said you like",
                            fontSize = 20.sp,
                        )
                        Row (
                            modifier = Modifier
                                .padding(0.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = icon_dog_or_cat),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(40.dp)
                                    .height(40.dp)
                            )
                            Text(
                                modifier = Modifier
                                    .padding(10.dp),
                                text = "$dog_or_cat",
                                fontSize = 30.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 40.dp)
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.thumb_up),
                                    contentDescription = null,
                                    tint = Color.Green,
                                    modifier = Modifier
                                        .align(Alignment.CenterStart)
                                        .padding(40.dp)
                                        .width(60.dp)
                                        .height(60.dp)
                                        .clickable {
                                            dogCounterViewModel.incrementCounterLike()
                                            val rnds = (0..1).random() < 0.5
                                            val next =
                                                if (rnds) DogDetailsActivity::class.java else CatDetailsActivity::class.java
                                            val intent = Intent(
                                                this@DogDetailsActivity,
                                                next
                                            )
                                            startActivity(intent)
                                            finish()
                                        },
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.thumb_down),
                                    contentDescription = null,
                                    tint = Color.Red,
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .padding(40.dp)
                                        .width(60.dp)
                                        .height(60.dp)
                                        .clickable {
                                            dogCounterViewModel.incrementCounterDis()
                                            val rnds = (0..1).random() < 0.5
                                            val next =
                                                if (rnds) DogDetailsActivity::class.java else CatDetailsActivity::class.java
                                            val intent = Intent(
                                                this@DogDetailsActivity,
                                                next
                                            )
                                            startActivity(intent)
                                            finish()
                                        },
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.volume_up),
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(40.dp)
                                        .width(60.dp)
                                        .height(60.dp)
                                        .clickable {
                                            dogCounterViewModel.incrementCounterSound()
                                            dogSound.start()
                                        },
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
