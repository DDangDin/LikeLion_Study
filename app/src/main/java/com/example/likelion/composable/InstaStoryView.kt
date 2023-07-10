package com.example.likelion.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.likelion.R

@Composable
fun InstaStoryView(modifier: Modifier = Modifier) {
    /* TODO 과제1: 실제 인스타 스토리처럼 첫 부분에 다른 이미지 표시 */

    val images = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
    )

    Box(modifier = modifier.fillMaxSize()) {
        LazyRow(
            modifier = Modifier.align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.CenterHorizontally),
            contentPadding = PaddingValues(15.dp)
        ) {

            items(images) { image ->
                var isChecked by remember { mutableStateOf(false) }
                val borderColor = if (isChecked) Color.LightGray else Color.Red

                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .border(2.dp, borderColor, CircleShape)
                        .padding(7.dp)
                        .clip(CircleShape)
                        .clickable { isChecked = !isChecked },
                    painter = painterResource(id = image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstaStoryViewPreview() {
    InstaStoryView()
}