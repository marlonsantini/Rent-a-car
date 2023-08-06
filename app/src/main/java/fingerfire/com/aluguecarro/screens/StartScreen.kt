package fingerfire.com.aluguecarro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import fingerfire.com.aluguecarro.R
import fingerfire.com.aluguecarro.navigation.HOME_SCREEN
import fingerfire.com.aluguecarro.ui.theme.BebasFont

@Composable
fun StartScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_map),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Vamos começar a alugar carros de luxo perto de você".uppercase(),
                color = Color.Black,
                fontFamily = BebasFont,
                fontWeight = FontWeight.W600,
                fontSize = 42.sp,
                lineHeight = 43.sp,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 50.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.car_yellow),
                    contentDescription = "",
                    modifier = Modifier.size(360.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Black)
                            .clickable {
                                navHostController.navigate(HOME_SCREEN)
                            }
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Começar a Alugar",
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 20.dp)
                        )
                    }
                }
            }
        }
    }
}
