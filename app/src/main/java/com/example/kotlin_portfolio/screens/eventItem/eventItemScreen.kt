package com.example.kotlin_portfolio.screens.eventItem

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.components.buttons.IconAndLabelButton
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import com.example.kotlin_portfolio.utils.deserializeEvent

@Composable
fun EventItemScreen(modifier: Modifier = Modifier, navController: NavHostController, dataJson: String) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (scrollContent, button) = createRefs()
        val eventInfo = deserializeEvent(dataJson)

        Log.d("EVENTITEM", "EVENT INFO LOADED =  $eventInfo" )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .constrainAs(scrollContent) {
                    top.linkTo(parent.top)
                    bottom.linkTo(button.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            Image(
                painter = painterResource(eventInfo.imageRes),
                contentDescription = "description",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = modifier
                    .padding(top = 20.dp, start = 22.dp)
                    .align(Alignment.Start)
            ) {
                Text(
                    text = eventInfo.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightColorScheme.outline,
                    ),
                    modifier = Modifier
                )
                Spacer(
                    modifier = Modifier
                        .width(340.dp)
                        .height(3.dp)
                        .background(color = Color.Gray)
                )
                Text(
                    text = "Local: ${eventInfo.local}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    ),
                    modifier = Modifier.padding(vertical = 24.dp)
                    .fillMaxWidth(),
                    maxLines = Int.MAX_VALUE,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Date: ${eventInfo.eventDate}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFC96908),
                    ),
                    modifier = Modifier
                )
                Column(
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(350.dp)
                            .wrapContentHeight()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Ministério da Cultura, Governo de Minas Gerais, Vivo e Instituto Inhotim apresentam: Jardim Sonoro - Festival de Música Inhotim.",
                                fontWeight = FontWeight.Bold,
                                style = TextStyle(fontSize = 22.sp),
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(bottom = 20.dp)
                            )
                            Text(
                                text = "Nos dias 12, 13 e 14 de julho será realizado o Jardim Sonoro - Festival de Música do Inhotim. Nestes dias, o ingresso ao parque garante acesso gratuito às ações do festival.",
                                style = TextStyle(fontSize = 20.sp),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = "O Jardim Sonoro tem a Vale como Mantenedora Master, o Patrocínio Prata da Vivo, o Patrocínio Bronze do Banco Sofisa, a Localiza como Locadora Oficial e a Azul como Companha Aérea Oficial. O festival é realizado por meio da Lei Estadual de Incentivo à Cultura de Minas Gerais e da Lei Federal de Incentivo à Cultura.",
                                style = TextStyle(fontSize = 20.sp),
                                textAlign = TextAlign.Justify
                            )
                            Text(
                                text = "O Instituto Inhotim fica em Brumadinho, cidade localizada a 60 quilômetros de Belo Horizonte, capital de Minas Gerais. Ao integrar museu de arte contemporânea, jardim botânico, cultura, educação e sustentabilidade, o Inhotim já recebeu cerca de 3 milhões de pessoas, tornando-se um dos principais destinos turísticos e culturais do Brasil.",
                                style = TextStyle(fontSize = 20.sp),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = "São 140 hectares de área de visitação que harmonizam uma coleção artística de relevância internacional – obras expostas a céu aberto e em galerias, com um acervo botânico de espécies de todos os continentes. Outros 250 hectares formam uma Reserva Particular de Patrimônio Natural (RPPN) que colabora de forma vitalícia para a conservação da biodiversidade local.",
                                style = TextStyle(fontSize = 20.sp),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = "Prepare-se para se encantar com os espaços de fruição, conhecimento, lazer e natureza que tornam o Inhotim um lugar único no mundo!",
                                style = TextStyle(fontSize = 20.sp),
                                textAlign = TextAlign.Justify
                            )
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
        ) {
            IconAndLabelButton(
                iconName = Icons.Default.AddCircle,
                buttonLabel = "BUY TICKETS",
                buttonColor = LightColorScheme.secondary,
                onClick = {
                    Log.d("buy", "COMPROU, IR PARA TELA DE WALLET")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventItemScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        EventItemScreen(navController = navController, dataJson = "")
    }

}
