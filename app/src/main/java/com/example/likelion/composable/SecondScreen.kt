package com.example.likelion.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.likelion.utils.CustomSharedPreference

@Composable
fun SecondScreen(
    modifier: Modifier = Modifier,
    onPopBackStack: () -> Unit,
) {

    val context = LocalContext.current
    val dogImageUrl = CustomSharedPreference(context).getUserPrefs("dog_image")

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .align(Alignment.Center),
            text = dogImageUrl,
            fontSize = 30.sp,
            color = Color.Black,
        )
        IconButton(
            modifier = Modifier
                .size(100.dp)
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            onClick = { onPopBackStack() },
        ) {
            Icon(
                modifier = Modifier.size(100.dp),
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.DarkGray
            )
        }
    }
}