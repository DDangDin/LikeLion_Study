package com.example.likelion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.likelion.api_call_practice.Constants
import com.example.likelion.api_call_practice.DogViewModel
import com.example.likelion.ui.theme.LikeLionTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel = viewModel<DogViewModel>()

            LikeLionTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
fun CustomCardView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image"
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = "Status"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomCardViewPreview() {
    CustomCardView(Modifier.size(200.dp))
}


@Composable
fun CountScreen(
    modifier: Modifier = Modifier,
    testClick: (Int) -> Unit,
) {

    var num by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = num.toString(),
            fontSize = 30.sp
        )
        Button(
            modifier = Modifier
                .width(80.dp)
                .height(50.dp),
            onClick = {
                num += 1
                testClick(num)
            }
        ) {
            Text(text = "1 증가")
        }
    }
}