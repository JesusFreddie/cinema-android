import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cimena.R
import com.example.cimena.presentation.screens.auth.AuthViewModel
import com.example.cimena.ui.theme.Black
import com.example.cimena.ui.theme.LightGrey
import com.example.cimena.ui.theme.Pink
import com.example.cimena.utils.LOGIN
import com.example.cimena.utils.PASSWORD
import com.example.memorizeapp.presentation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController) {

    val authViewModel: AuthViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //задний фон
        Image(
            painter = painterResource(R.drawable.reel_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = "cine",
                style = TextStyle(fontSize = 64.sp, fontWeight = FontWeight.ExtraBold, color = Color.White),
                modifier = Modifier.align(CenterHorizontally)
            )
            Text(
                text = "все фильмы и сериалы здесь",
                style = TextStyle(fontSize = 12.sp, color = Color.White),
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(34.dp))

            Box (
                modifier = Modifier
                    .background(color = Color.White.copy(alpha = 0.15f), shape = RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Вход/Регистрация",
                        style = TextStyle(fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold),
                        modifier = Modifier.align(CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    // инпут логин
                    BasicTextField(
                        value = login,
                        onValueChange = { login = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0x99FFFFFF), shape = MaterialTheme.shapes.medium)
                            .padding(12.dp),
                        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                        decorationBox = { innerTextField ->
                            Box(Modifier.padding(horizontal = 4.dp)) {
                                if (login.isEmpty()) {
                                    Text("Логин", style = TextStyle(color = LightGrey, fontSize = 18.sp))
                                }
                                innerTextField()
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // инпут пароль
                    BasicTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0x99FFFFFF), shape = MaterialTheme.shapes.medium)
                            .padding(12.dp),
                        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                        decorationBox = { innerTextField ->
                            Box(Modifier.padding(horizontal = 4.dp)) {
                                if (password.isEmpty()) {
                                    Text("Пароль", style = TextStyle(color = LightGrey, fontSize = 18.sp))
                                }
                                innerTextField()
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // кнопка
                    Button(
                        onClick = {
                            LOGIN = login
                            PASSWORD = password
                            coroutineScope.launch {
                                authViewModel.initDatabase {
                                    navController.navigate(route = Screen.Movies.route)
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Pink, shape = RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Pink)
                    ) {
                        Text("Войти", fontSize = 16.sp, color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}
