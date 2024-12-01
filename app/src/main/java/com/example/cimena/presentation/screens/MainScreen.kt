import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.cimena.R
import com.example.cimena.ui.theme.Grey
import com.example.cimena.ui.theme.Pink
import com.example.cimena.ui.theme.BlackBack
import kotlinx.coroutines.launch

@Composable
fun DrawerMenuContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Text(text = "Главная", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Профиль", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Настройки", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "О приложении", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MovieListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBack)
            .padding(16.dp)
    ) {
        MovieCard(
            movieTitle = "Хеллбой: Проклятие Горбуна",
            rating = "5.2",
            genre = "Боевик/Ужасы",
            showDate = "23 сентября",
            ticketsLeft = 50,
            imageResource = R.drawable.hellboy_image
        )
        Spacer(modifier = Modifier.height(16.dp))
        MovieCard(
            movieTitle = "Граф Монте-Кристо",
            rating = "8",
            genre = "Драма/Триллер",
            showDate = "25 сентября",
            ticketsLeft = 20,
            imageResource = R.drawable.monte_cristo_image
        )
        Spacer(modifier = Modifier.height(16.dp))
        MovieCard(
            movieTitle = "Маме снова 17",
            rating = "6.9",
            genre = "Комедия/Фантастика",
            showDate = "1 октября",
            ticketsLeft = 100,
            imageResource = R.drawable.mom_17_image
        )
        Spacer(modifier = Modifier.height(16.dp))
        MovieCard(
            movieTitle = "Любовь зла",
            rating = "6.2",
            genre = "Комедия",
            showDate = "7 октября",
            ticketsLeft = 30,
            imageResource = R.drawable.love_is_evil_image
        )
    }
}

@Composable
fun MovieCard(
    movieTitle: String,
    rating: String,
    genre: String,
    showDate: String,
    ticketsLeft: Int,
    imageResource: Int
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(BlackBack),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(135.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = movieTitle,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = genre,
                    style = TextStyle(color = Grey, fontSize = 12.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ближайший сеанс: $showDate",
                    style = TextStyle(color = Color.White, fontSize = 12.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Билетов осталось: $ticketsLeft",
                    style = TextStyle(color = Color.White, fontSize = 12.sp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* TODO: Add action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Pink),
                    modifier = Modifier
                        .background(Pink, shape = RoundedCornerShape(16.dp))
                ) {
                    Text(text = "Купить билеты", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieListScreen()
}
