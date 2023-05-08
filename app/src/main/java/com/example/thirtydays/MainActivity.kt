package com.example.thirtydays

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydays.ui.theme.RobotoSlab
import com.example.thirtydays.ui.theme.ThirtyDaysTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.window.Popup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirtyDaysAppPreview() {
    ThirtyDaysTheme {
        ThirtyDaysApp()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysApp(modifier: Modifier = Modifier) {
    val dataContent = Boxes().typesOfBoxes
    var expanded = remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = modifier,
        topBar = {AppTopBar(dataContent.size, expanded)}
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
//            if(expanded) {
            if(expanded.value) {
                Popup() {
                    Card(
                        shape = RectangleShape,
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        elevation = CardDefaults.cardElevation(2.dp),
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_description),
                            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
                            fontFamily = RobotoSlab,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
            AppBody(expanded, dataContent)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(dataLength: Int, expanded: MutableState<Boolean>, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = "$dataLength "+stringResource(id = R.string.app_name),
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontFamily = RobotoSlab,
//                letterSpacing = 4.sp,
//                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.headlineMedium,
            )
        },
        navigationIcon = {
            ExpandButton(
                expanded = expanded.value,
                onClick = {expanded.value = !expanded.value}
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier
    )
}

@Composable
private fun ExpandButton(
    expanded: Boolean,
    onClick: ()->Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        val iconImage = if(expanded) ImageVector.vectorResource(id = R.drawable.baseline_expand_less_24) else ImageVector.vectorResource(id = R.drawable.baseline_expand_more_24)
        val iconDescription = if(expanded) "Expand less button" else "Expand more button"
        Icon(
            imageVector = iconImage,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = iconDescription,
        )
    }
}

@Composable
fun AppBody(expanded: MutableState<Boolean>, dataContent: List<Box>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(dataContent) {
            CardItem(expanded, item = it)
        }
    }
}

@Composable
fun CardItem(expanded: MutableState<Boolean>, item: Box, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )

        ) {
            Text(
                text = item.nameRes,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontFamily = RobotoSlab,
                letterSpacing = 2.sp,
                style = MaterialTheme.typography.titleLarge
            )
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.nameRes,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 8.dp)
                    .height(160.dp)
                    .fillMaxWidth(0.6f)
                    .align(alignment = Alignment.CenterHorizontally)
                    .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline)),
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = item.descriptionRes,
                modifier = Modifier.padding(8.dp),
                fontFamily = RobotoSlab,
                textAlign = TextAlign.Justify
            )
        }
    }
}