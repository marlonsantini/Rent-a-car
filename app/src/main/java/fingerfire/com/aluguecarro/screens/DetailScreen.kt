package fingerfire.com.aluguecarro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fingerfire.com.aluguecarro.R
import fingerfire.com.aluguecarro.ui.theme.AluguecarroTheme
import fingerfire.com.aluguecarro.ui.theme.BebasFont

@Composable
fun DetailScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_map),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
            Card(
                modifier = Modifier
                    .padding(top = 250.dp)
                    .fillMaxSize()
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.car_orange_perfil),
                            contentDescription = "",
                            Modifier.scale(0.8f)
                        )
                    }
                    item {
                        DriverInfo()
                    }
                    item {
                        AdressInfo()
                    }
                    item {
                        EstimatedTimeInfo()
                    }
                }
            }
        }
    }
}

@Composable
fun DriverInfo() {
    Text(
        text = "Localização do Motorista",
        style = TextStyle(
            fontSize = 25.sp,
            color = Color.Black,
            fontFamily = BebasFont,
            fontWeight = FontWeight.W600
        ),
        modifier = Modifier.padding(horizontal = 20.dp)
    )
    Row(
        modifier = Modifier
            .padding(all = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ){
            Text(
                text = "Kahoni Silva",
                color = Color.DarkGray,
                style = MaterialTheme.typography.labelLarge,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Motorista",
                color = Color.LightGray,
                style = MaterialTheme.typography.labelLarge
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_phone),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        thickness = 1.dp,
        color = Color.LightGray
    )
}

@Composable
fun AdressInfo() {
    Row(
        modifier = Modifier
            .padding(all = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ){
            Text(
                text = "Endereço atual",
                color = Color.LightGray,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Boa Viagem Beach - Boa Viagem, Recife - PE",
                color = Color.DarkGray,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun EstimatedTimeInfo() {
    Row(
        modifier = Modifier
            .padding(all = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_time),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ){
            Text(
                text = "Tempo estimado de chegada",
                color = Color.LightGray,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "15:23",
                color = Color.DarkGray,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AluguecarroTheme {
        DetailScreen()
    }
}