package com.example.marketplacepuj.ui.features.catalogo.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import java.text.NumberFormat


val items = listOf(
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
    CartItem("Lorem ipsum dolor sit", 1000.0, ""),
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartScreen(navController: NavController, cartItems: List<CartItem>, onDeleteCartItem: (cartItem: CartItem) -> Unit, onCheckout: () -> Unit) {


    val customShape =
        RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp, bottomEnd = 32.dp, bottomStart = 32.dp)

    val total = cartItems.sumOf { it.price }

    val formatter = NumberFormat.getCurrencyInstance().apply {
        maximumFractionDigits = 0
    }
    val formattedPrice = formatter.format(total)
    Scaffold(
        bottomBar = {

            BottomNavigationBar(
                navController = navController, modifier = Modifier
                    .padding(16.dp)
                    .clip(customShape)
            )


        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF243484), Color(0xFF2be4dc))
                    )
                )
                .padding(bottom = 72.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Cart",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(16.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(2f)
            ) {
                items(cartItems) { item ->
                    CartItemRow(item = item, onDeleteCartItem)
                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = "Total:",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray
                    )
                    Text(
                        text = formattedPrice,
                        style = MaterialTheme.typography.h6,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Botón Checkout
                Button(
                    onClick = { onCheckout() },
                    modifier = Modifier
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFFF7F50), // Naranja claro
                        contentColor = Color.White
                    ),
                    enabled = total != 0.0
                ) {
                    Text(text = "Checkout")
                }

            }


        }
    }
}

@Composable
fun CartItemRow(item: CartItem, onDeleteCartItem: (cartItem: CartItem) -> Unit) {

    val formatter = NumberFormat.getCurrencyInstance().apply {
        maximumFractionDigits = 0
    }
    val formattedPrice = formatter.format(item.price)

    Card(
        shape = RoundedCornerShape(16.dp), // Adjust the corner radius as needed
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = item.imageUrl, // Reemplaza con tu imagen
                contentDescription = "Imagen centrada",
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(60.dp),
            )
            Column(
                Modifier
                    .weight(2f)
                    .padding(start = 8.dp)) {
                Text(text = item.name, fontWeight = FontWeight.Bold)
                Text(text = formattedPrice, color = Color.Gray, fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = { onDeleteCartItem(item) }) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Remove",
                    tint = Color.Gray
                )


            }
        }

    }
}

data class CartItem(val name: String, val price: Double, val imageUrl: String)

@Preview(showBackground = true)
@Composable
fun CartPreview() {
    CartScreen(rememberNavController(), items, {}, {})

}

