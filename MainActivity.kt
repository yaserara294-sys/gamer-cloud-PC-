package com.gamercloud.pc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DarkBackground = Color(0xFF080D18)
private val CardBackground = Color(0xFF151F30)
private val NeonGreen = Color(0xFF39E879)
private val WhiteText = Color(0xFFF4F7FC)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GamerCloudApp()
        }
    }
}

@Composable
fun GamerCloudApp() {
    var status by remember { mutableStateOf("Servidor desconectado") }
    var selectedPage by remember { mutableStateOf("Inicio") }

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = NeonGreen,
            background = DarkBackground,
            surface = CardBackground
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBackground)
                .padding(20.dp)
        ) {

            Text(
                "GAMER CLOUD PC",
                fontSize = 25.sp,
                fontWeight = FontWeight.Black,
                color = NeonGreen
            )

            Text(
                "TU PC GAMING EN LA NUBE",
                fontSize = 11.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(35.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = CardBackground
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        "ESTADO DE CONEXIÓN",
                        color = Color.LightGray,
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        status,
                        color = NeonGreen,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            status = "Preparado para conectar"
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = NeonGreen,
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            "JUGAR AHORA",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedButton(
                        onClick = {
                            status = "Servidor desconectado"
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("DESCONECTAR")
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                "CENTRO DE CONTROL",
                color = WhiteText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            ControlButton("☁  Servidores") {
                selectedPage = "Servidores"
            }

            ControlButton("⚙  Configuración") {
                selectedPage = "Configuración"
            }

            ControlButton("🎮  Controles") {
                selectedPage = "Controles"
            }

            ControlButton("📡  Conexión") {
                selectedPage = "Conexión"
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Gamer Cloud PC  •  v1.0.0",
                color = Color.Gray,
                fontSize = 11.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun ControlButton(
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = CardBackground,
            contentColor = WhiteText
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(title, modifier = Modifier.padding(5.dp))
    }
}
