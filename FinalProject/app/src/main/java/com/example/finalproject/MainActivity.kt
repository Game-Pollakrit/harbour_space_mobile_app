package com.example.finalproject

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.theme.FinalProjectTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val initializeApp = FirebaseApp.initializeApp(this)

        setContent {
            FinalProjectTheme {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    item {
                        var text by remember { mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .clip(RoundedCornerShape(30.dp)),
                            value = text,
                            onValueChange = { newText -> text = newText },
                            label = { Text("What's you like Dog or Cat?") }
                        )
                        var button_image = R.drawable.angry_icon
                        var button_color = Color.Red
                        var sound = ""
                        val dogSound = MediaPlayer.create(LocalContext.current, R.raw.dogsound)
                        val catSound = MediaPlayer.create(LocalContext.current, R.raw.catsound)

                        if(text.lowercase() == "dog")
                        {
                            button_image = R.drawable.dog_icon
                            sound = "dog"
                            button_color = Color.Black
                        }
                        if(text.lowercase() == "cat")
                        {
                            button_image = R.drawable.cat_icon
                            sound = "cat"
                            button_color = Color.Black
                        }

                        Icon(
                            painter = painterResource(id = button_image),
                            contentDescription = null,
                            tint = button_color,
                            modifier = Modifier
                                .padding(20.dp)
                                .width(60.dp)
                                .height(60.dp)
                                .clickable {
                                    if (sound == "dog") {
                                        dogSound.start()
                                        AppPreferences(this@MainActivity).setOption("Dog")
                                        val intent = Intent(
                                            this@MainActivity,
                                            DogDetailsActivity::class.java
                                        )
                                        startActivity(intent)
                                    }
                                    if (sound == "cat") {
                                        catSound.start()
                                        AppPreferences(this@MainActivity).setOption("Cat")
                                        val intent = Intent(
                                            this@MainActivity,
                                            CatDetailsActivity::class.java
                                        )
                                        startActivity(intent)
                                    }
                                },
                        )
                    }
                }
            }
        }
    }
}