package com.example.indabahc.ui.home

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.indabahc.R
import com.example.indabahc.ui.theme.GGreen
import com.example.indabahc.ui.theme.GWhite
import com.example.indabahc.ui.theme.firstBox
import com.example.indabahc.ui.theme.secondBox
import com.example.indabahc.ui.theme.thirdBox

@Composable
fun HomeScreen(modifier: Modifier,
               onDietCardClicked : () -> Unit,
               onMedicationCardClicked : () -> Unit,
               onPainCardClicked: () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val articles = listOf(
        ArticleData("Healthy Diet", "Tips for balanced nutrition every day.", R.drawable.ab3_stretching),
        ArticleData("Mental Health", "Understanding stress and how to manage it.", R.drawable.ab3_stretching),
        ArticleData("Exercise", "Why daily movement matters.", R.drawable.ab2_quick_yoga),
        ArticleData("Sleep Well", "Benefits of good sleep hygiene.", R.drawable.ab2_quick_yoga),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight)
            .background(GWhite),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight/2)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GGreen, GWhite)
                )
            )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())

    ) {
        Spacer(Modifier.height(50.dp))

        GreetingHeader(R.drawable.avatars) { }
        CurvedRectangle(
            modifier = Modifier,
            onDietCardClicked = onDietCardClicked,
            onMedicationCardClicked = onMedicationCardClicked,
            onPainCardClicked = onPainCardClicked
        )
        Spacer(Modifier.height(16.dp))
        MealCard1()
        Spacer(Modifier.height(16.dp))
        MealCard2()

        Spacer(Modifier.height(16.dp))
        LinkBox(
            title = "Start Chat",
            subtitle = "Go to our chat screen",
            link = "https://ulcermate-app.streamlit.app/"
        )



    }
}

@Composable
fun GreetingHeader(
    @DrawableRes userImageRes: Int,
    onBellClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box {
                Image(
                    painter = painterResource(id = userImageRes),
                    contentDescription = "User profile",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Hello,",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    text = "Good evening",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Gray
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .size(43.dp) // Circular background size
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = onBellClick,
                modifier = Modifier.size(24.dp) // Size of the bell icon itself
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.Black
                )
            }

            // Orange notification dot
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = 4.dp, y = (-4).dp)
                    .background(Color(0xFFFF5722), CircleShape)
            )
        }
    }
}

@Composable
fun CurvedRectangle(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White, // light greenish background
    cornerRadius: Dp = 16.dp,
    onDietCardClicked : () -> Unit,
    onMedicationCardClicked : () -> Unit,
    onPainCardClicked: () -> Unit
    //content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(cornerRadius))
            .background(backgroundColor)
            .padding(16.dp),
    )  {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)


        ) {
        //box 1
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(firstBox)
                    .clickable { onDietCardClicked() },
                contentAlignment = Alignment.Center
            ) {
                Column(Modifier.padding(8.dp)) {

                    // Icon circle
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFB3E5FC)), // Icon circle color
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.book),
                            contentDescription = "",
                            tint = Color(0xFF0277BD), // Optional tint for icon
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Title text
                    Text(
                        text = "Diet meal & Tracking",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )
                }
            }
        //box 2
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(secondBox)
                    .clickable { onMedicationCardClicked() },
                contentAlignment = Alignment.Center
            ) {
                Column(Modifier.padding(8.dp)) {

                    // Icon circle
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFED8C)), // Icon circle color
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.mediatation),
                            contentDescription = "",
                            tint = Color(0xFF0277BD), // Optional tint for icon
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Title text
                    Text(
                        text = "Medication Tracking",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )
                }
            }

            //box 3
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(thirdBox)
                    .clickable { onPainCardClicked() },
                contentAlignment = Alignment.Center
            ) {
                Column(Modifier.padding(8.dp)
                    .clickable {  }) {

                    // Icon circle
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFDBB9F1)), // Icon circle color
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.diet),
                            contentDescription = "",
                            tint = Color(0xFF0277BD), // Optional tint for icon
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Title text
                    Text(
                        text = "Pain & Symptoms",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )
                }
            }
        }
    }
}



@Composable
fun MealCard1() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Breakfast meal 🍱",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Bread & egg with juice",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                    color = Color.Black
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                // Status pill
                Box(
                    modifier = Modifier
                        .background(Color(0xFFF3E8FF), shape = RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Good",
                        color = Color(0xFFAA00FF),
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "8:00AM–9:00AM",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
            }
        }
    }
}


@Composable
fun MealCard2() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = " meal 🍱",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Yam & Stew with juice",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                    color = Color.Black
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                // Status pill
                Box(
                    modifier = Modifier
                        .background(Color(0xFFF3E8FF), shape = RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Good",
                        color = Color(0xFFAA00FF),
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "1:00PM–2:00PM",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun ArticleBox(
    title: String,
    subtitle: String,
    imageRes: Int?,
    onReadMore: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            imageRes?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onReadMore,
                modifier = Modifier.align(Alignment.End),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text("Read More", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}


@Composable
fun ArticleGrid(articles: List<ArticleData>, onReadMoreClick: (ArticleData) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(articles) { article ->
            ArticleBox(
                title = article.title,
                subtitle = article.subtitle,
                imageRes = article.imageRes,
                onReadMore = { onReadMoreClick(article) }
            )
        }
    }
}


data class ArticleData(
    val title: String,
    val subtitle: String,
    val imageRes: Int? = null
)

@Composable
fun LinkBox(
    title: String,
    url: String
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}

@Composable
fun LinkBox(
    title: String,
    subtitle: String = "Tap to continue",
    link: String, // Can be a route or URL
    icon: ImageVector = Icons.Default.Build
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFF4CAF50), Color(0xFF81C784)) // Green gradient
                )
            )
            .clickable {
                // Handle the link: open in browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                context.startActivity(intent)
            }
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.85f),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}



@Composable
@Preview
fun previewFunction() {
    HomeScreen(
        modifier = Modifier,
        onDietCardClicked = TODO(),
        onMedicationCardClicked = TODO(),
        onPainCardClicked = TODO()
    )
}

