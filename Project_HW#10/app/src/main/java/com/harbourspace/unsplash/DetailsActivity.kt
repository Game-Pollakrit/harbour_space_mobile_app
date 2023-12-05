package com.harbourspace.unsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.harbourspace.unsplash.ui.theme.UnsplashTheme
import com.harbourspace.unsplash.utils.EXTRA_IMAGE

class DetailsActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val url = if (intent.hasExtra(EXTRA_IMAGE)) {
      intent.extras?.get(EXTRA_IMAGE)
    } else {
      ""
    }

    setContent {
      UnsplashTheme {
        LazyColumn {
          item {
            Box {
              AsyncImage(
                modifier = Modifier
                  .fillMaxWidth()
                  .height(250.dp),
                model = url,
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.description_image_preview)
              )
              Row(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(
                  modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                  painter = painterResource(id = R.drawable.location_on),
                  contentDescription = null,
                  tint = Color.White
                )
                location(title = "Bangkok")
              }
            }
          }
          item {
            Row(
              modifier = Modifier.padding(16.dp)
            ) {
              Box {
                Row(
                  modifier = Modifier
                    .align(Alignment.CenterStart),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Image(
                    modifier = Modifier
                      .width(40.dp)
                      .height(40.dp)
                      .clip(RoundedCornerShape(15.dp)),
                    painter = painterResource(id = R.drawable.ps_image),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                  )
                  Name(title = "John Mayer")
                }

                Row(
                  modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterEnd),
                  horizontalArrangement = Arrangement.End,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                    modifier = Modifier
                      .wrapContentSize()
                      .padding(10.dp),
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null
                  )
                  Icon(
                    modifier = Modifier
                      .wrapContentSize()
                      .padding(10.dp),
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = null
                  )
                  Icon(
                    modifier = Modifier
                      .wrapContentSize()
                      .padding(10.dp),
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = null
                  )
                }
              }
            }
          }
          item {
            Row(
              modifier = Modifier.padding(16.dp)
            ) {
              Column(
                modifier = Modifier.weight(1.0f)
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_camera_title),
                  subtitle = stringResource(id = R.string.details_camera_default)
                )
              }

              Column(
                modifier = Modifier.weight(1.0f)
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_aperture_title),
                  subtitle = stringResource(id = R.string.details_aperture_default)
                )
              }
            }
          }

          item {
            Row(
              modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
              Column(
                modifier = Modifier.weight(1.0f)
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_focal_title),
                  subtitle = stringResource(id = R.string.details_focal_default)
                )
              }

              Column(
                modifier = Modifier.weight(1.0f)
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_shutter_title),
                  subtitle = stringResource(id = R.string.details_shutter_default)
                )
              }
            }
          }

          item {
            Row(
              modifier = Modifier.padding(16.dp)
            ) {
              Column(
                modifier = Modifier.weight(1.0f)
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_iso_title),
                  subtitle = stringResource(id = R.string.details_iso_default)
                )
              }

              Column(
                modifier = Modifier.weight(1.0f)
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_dimensions_title),
                  subtitle = stringResource(id = R.string.details_dimensions_default)
                )
              }
            }
          }

          item {
            Divider(
              modifier = Modifier.padding(start = 16.dp, end = 16.dp),
              thickness = 1.dp,
              color = Color.LightGray
            )
          }

          item {
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
              horizontalArrangement = Arrangement.SpaceEvenly
            ) {

              Column(
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_views_title),
                  subtitle = stringResource(id = R.string.details_views_default)
                )
              }

              Column(
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_downloads_title),
                  subtitle = stringResource(id = R.string.details_downloads_default)
                )
              }

              Column(
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                AddImageInformation(
                  title = stringResource(id = R.string.details_likes_title),
                  subtitle = stringResource(id = R.string.details_likes_default)
                )
              }
            }
          }
          item {
            Row(
              modifier = Modifier.padding(16.dp)
            ) {
              button("Bangkok")
              button("Thailand")
            }
          }
        }
      }
    }
  }
}

@Composable
fun AddImageInformation(
  title: String,
  subtitle: String
) {

  Text(
    text = title,
    fontSize = 17.sp,
    fontWeight = FontWeight.Bold
  )

  Text(
    text = subtitle,
    fontSize = 15.sp
  )
}

@Composable
fun Name(
  title: String,
) {

  Text(
    text = title,
    fontSize = 17.sp,
    fontWeight = FontWeight.Bold,
    color = Color.Black,
    modifier = Modifier.padding(10.dp),
  )
}

@Composable
fun location(
  title: String,
) {

  Text(
    text = title,
    fontSize = 17.sp,
    fontWeight = FontWeight.Bold,
    color = Color.White
  )
}

@Composable
fun button(
  title: String
) {
  FilledTonalButton(onClick = { },
    modifier = Modifier.padding(5.dp),
    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray, contentColor = Color.Black)
  ) {
    Text(title)
  }
}