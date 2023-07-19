package com.example.likelion.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.likelion.api_call_practice.DogState
import com.example.likelion.utils.CustomSharedPreference

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    dogState: DogState,
    getDogImage: () -> Unit,
    onNavigate: () -> Unit
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = dogState) {
        CustomSharedPreference(context).setUserPrefs("dog_image", dogState.dog.message)
    }

    /** onNavigate() **/
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically)
        ) {
            if (dogState.loading) {
                CircularProgressIndicator(
                    strokeWidth = 2.dp,
                    color = Color.Black,
                    modifier = Modifier.size(100.dp)
                )
            } else {
                AsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    model = dogState.dog.message,
                    contentDescription = "dog image",
                    contentScale = ContentScale.Crop,
                )
            }
            OutlinedButton(
                modifier = Modifier
                    .padding(bottom = 100.dp),
                onClick = { getDogImage() },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(text = "이미지 가져오기", color = Color.Black)
            }
        }

        IconButton(
            modifier = Modifier
                .size(100.dp)
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            onClick = { onNavigate() },
        ) {
            Icon(
                modifier = Modifier.size(100.dp),
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
                tint = Color.DarkGray
            )
        }
    }
}