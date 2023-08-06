package fingerfire.com.aluguecarro.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import fingerfire.com.aluguecarro.R
import fingerfire.com.aluguecarro.common.AppIcon
import fingerfire.com.aluguecarro.model.Car
import fingerfire.com.aluguecarro.navigation.DETAIL_SCREEN
import fingerfire.com.aluguecarro.ui.theme.AluguecarroTheme
import fingerfire.com.aluguecarro.ui.theme.Background
import fingerfire.com.aluguecarro.ui.theme.BebasFont
import fingerfire.com.aluguecarro.ui.theme.DarkGray
import fingerfire.com.aluguecarro.ui.theme.Gray


@Composable
fun HomeScreen(navHostController: NavHostController) {
    AluguecarroTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            var search by remember { mutableStateOf("") }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Background)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        AppIcon(icon = R.drawable.ic_menu)
                        Icon(
                            painter = painterResource(id = R.drawable.car_top),
                            contentDescription = "",
                            modifier = Modifier.size(58.dp),
                            tint = Color.Unspecified
                        )
                        AppIcon(icon = R.drawable.ic_profile_bl)
                    }

                    Text(
                        text = "Encontre o melhor\nServiço de aluguel para você",
                        style = TextStyle(
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontFamily = BebasFont,
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier.padding(vertical = 30.dp)
                    )

                    Box {
                        CustomSearchBar(value = search, onValueChange = { search = it })
                        AppIcon(
                            icon = R.drawable.ic_filter,
                            background = Color.Black,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(55.dp)
                        )
                    }

                    val menuList = listOf("BMW", "Tesla", "Audi", "Nissan", "Toyota")
                    val menuListWithImages = mapOf(
                        "BMW" to painterResource(R.drawable.icon_bmw),
                        "Tesla" to painterResource(R.drawable.icon_tesla),
                        "Audi" to painterResource(R.drawable.icon_audi),
                        "Nissan" to painterResource(R.drawable.icon_nissan),
                        "Toyota" to painterResource(R.drawable.icon_toyota)
                    )

                    var selectedIndex by remember { mutableStateOf(-1) }

                    val carList = listOf(
                        Car(
                            "Lamborghini",
                            "Lamborghini Aventador",
                            4.5,
                            "R$250",
                            R.drawable.pic_lambor
                        ),
                        Car(
                            "Tesla",
                            "Lamborghini Aventador",
                            4.8,
                            "R$300",
                            R.drawable.pic_porche
                        ),
                        Car(
                            "Audi",
                            "A4",
                            4.3,
                            "R$220",
                            R.drawable.pic_audiavant
                        ),
                        Car("Nissan",
                            "Altima",
                            4.0,
                            "R$180",
                            R.drawable.pic_porche
                        ),
                        Car("Toyota",
                            "Camry",
                            4.2,
                            "R$200",
                            R.drawable.pic_rr
                        )
                    )

                    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
                        itemsIndexed(menuList) { index, menuItem ->
                            val isSelected = index == selectedIndex
                            Card(
                                shape = RoundedCornerShape(22.dp),
                                modifier = Modifier
                                    .padding(end = 15.dp)
                                    .clickable { selectedIndex = index }
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.padding(
                                        vertical = 10.dp,
                                        horizontal = 20.dp
                                    )
                                ) {
                                    if (isSelected) {
                                        Box(
                                            modifier = Modifier
                                                .background(MaterialTheme.colors.primary.copy(alpha = 0.7f))
                                        )
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = menuListWithImages[menuItem]
                                                ?: painterResource(R.drawable.ic_profile_bl),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(50.dp)
                                                .padding(bottom = 8.dp)
                                        )
                                        Text(
                                            text = menuItem,
                                            style = TextStyle(
                                                color = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface,
                                                fontWeight = FontWeight.W400,
                                                fontSize = 18.sp,
                                                fontFamily = FontFamily.Default
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                    LazyColumn {
                        itemsIndexed(carList) { _, car ->
                            CarItem(car = car, navHostController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CarItem(car: Car, navHostController: NavHostController) {
    Card(
        shape = RoundedCornerShape(22.dp),
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
            .clickable {
                navHostController.navigate(DETAIL_SCREEN)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
        ) {
            CarImage(imageResId = car.imageResId)
            Spacer(modifier = Modifier.width(16.dp))
            CarInfo(car = car)
        }
    }
}

@Composable
fun CarImage(imageResId: Int) {
    Image(
        painter = painterResource(imageResId),
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
        modifier = Modifier
            .height(120.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun CarInfo(car: Car) {
    Column {
        Text(
            text = car.brand,
            color = Color.Black,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        Text(
            text = car.model,
            color = Color.Gray,
            style = TextStyle(
                fontSize = 16.sp
            )
        )
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Image(
                painterResource(
                    id = R.drawable.ic_star
                ), contentDescription = null
            )
            Text(
                text = "${car.rating}",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp
                )
            )
        }
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        Row{
            Text(
                text = car.rentalPrice,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "/Dia",
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 18.sp
                )
            )
        }
    }
}


@Composable
fun CustomSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.5.dp))
            .background(Gray)
    ) {
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            placeholder = {
                Text(
                    text = "Encontre seu carro",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = BebasFont,
                        fontWeight = FontWeight.W400,
                        color = DarkGray
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {}
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    AluguecarroTheme {
//        HomeScreen(navHostController = rememberNavController())
//    }
//}