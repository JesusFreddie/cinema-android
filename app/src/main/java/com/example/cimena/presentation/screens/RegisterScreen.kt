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
import com.example.cimena.R
import com.example.cimena.ui.theme.LightGrey
import com.example.cimena.ui.theme.Pink

@Composable
fun RegisterScreen() {
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

            var login by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var repeatPassword by remember { mutableStateOf("") }
            val passwordVisible by remember { mutableStateOf(false) }
            var isChecked by remember { mutableStateOf(false) }

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
                        text = "Регистрация",
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

                    Spacer(modifier = Modifier.height(12.dp))

                    // инпут повтор пароль
                    BasicTextField(
                        value = repeatPassword,
                        onValueChange = { repeatPassword = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0x99FFFFFF), shape = MaterialTheme.shapes.medium)
                            .padding(12.dp),
                        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                        decorationBox = { innerTextField ->
                            Box(Modifier.padding(horizontal = 4.dp)) {
                                if (repeatPassword.isEmpty()) {
                                    Text("Пароль ещё раз", style = TextStyle(color = LightGrey, fontSize = 18.sp))
                                }
                                innerTextField()
                            }
                        }
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Pink,
                                uncheckedColor = Color.Gray
                            )
                        )


                        Text(
                            text = "Я согласен с ",
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            fontSize = 10.sp
                        )

                        Text(
                            text = "политикой конфиденциальности",
                            color = Pink,
                            textAlign = TextAlign.Start,
                            fontSize = 10.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    // кнопка
                    Button(
                        onClick = { /* нав контрол */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Pink, shape = RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Pink)
                    ) {
                        Text("Зарегистрироваться", fontSize = 16.sp, color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // ссылка на регистрацию
                    Box() {
                        Text(
                            text = "Уже есть профиль?",
                            style = TextStyle(color = Color.White, textAlign = TextAlign.Center),
                            modifier = Modifier.align(TopCenter)
                        )
                        TextButton(
                            onClick = { /* нав контрол */ },
                            modifier = Modifier.align(BottomCenter)
                        ) {
                            Text("Войти в аккаунт", color = Pink)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}
