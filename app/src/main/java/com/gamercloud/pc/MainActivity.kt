
package com.gamercloud.pc

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : Activity() {

    private lateinit var serverInput: EditText
    private lateinit var statusText: TextView
    private lateinit var gpuText: TextView

    private val bg = Color.rgb(12, 16, 27)
    private val panel = Color.rgb(25, 32, 48)
    private val green = Color.rgb(80, 230, 145)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scroll = ScrollView(this)
        scroll.setBackgroundColor(bg)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(dp(22), dp(35), dp(22), dp(30))

        scroll.addView(layout)

        val logo = text("GAMER CLOUD PC", 29f, green, true)
        logo.gravity = Gravity.CENTER
        layout.addView(logo)

        val subtitle = text(
            "TU PC GAMING EN LA NUBE",
            13f, Color.LTGRAY, true
        )
        subtitle.gravity = Gravity.CENTER
        layout.addView(subtitle, margin(0, 5, 0, 28))

        val welcome = text("Juega tus juegos de PC desde Android", 19f, Color.WHITE, true)
        welcome.gravity = Gravity.CENTER
        layout.addView(welcome, margin(0, 0, 0, 22))

        val serverCard = card()
        layout.addView(serverCard)

        serverCard.addView(text("CONEXIÓN AL SERVIDOR", 17f, green, true))

        serverInput = EditText(this)
        serverInput.hint = "Dirección del servidor"
        serverInput.setSingleLine(true)
        serverInput.setTextColor(Color.WHITE)
        serverInput.setHintTextColor(Color.GRAY)
        serverInput.textSize = 15f
        serverInput.setPadding(dp(12), dp(10), dp(12), dp(10))
        serverInput.background = rounded(panel, 10)
        serverCard.addView(serverInput, margin(0, 15, 0, 12))

        val connect = button("CONECTAR AL SERVIDOR")
        serverCard.addView(connect, margin(0, 8, 0, 0))

        statusText = text("● Servidor: Desconectado", 15f, Color.YELLOW, true)
        serverCard.addView(statusText, margin(0, 20, 0, 8))

        gpuText = text("GPU: Esperando conexión", 15f, Color.LTGRAY)
        serverCard.addView(gpuText)

        val gamesCard = card()
        layout.addView(gamesCard, margin(0, 20, 0, 0))

        gamesCard.addView(text("MI BIBLIOTECA", 18f, green, true))
        gamesCard.addView(
            text("Juegos disponibles para tu PC remoto", 13f, Color.LTGRAY),
            margin(0, 6, 0, 15)
        )

        gamesCard.addView(game("AMERICAN TRUCK SIMULATOR"))
        gamesCard.addView(game("EURO TRUCK SIMULATOR 2"))
        gamesCard.addView(game("NEED FOR SPEED HEAT"))

        val controls = card()
        layout.addView(controls, margin(0, 20, 0, 0))

        controls.addView(text("CONTROLES", 18f, green, true))
        controls.addView(
            text("Preparado para mando Bluetooth, teclado y controles táctiles.", 14f, Color.LTGRAY),
            margin(0, 10, 0, 0)
        )

        val footer = text(
            "GAMER CLOUD PC  •  CLOUD GAMING",
            11f, Color.GRAY, true
        )
        footer.gravity = Gravity.CENTER
        layout.addView(footer, margin(0, 28, 0, 0))

        connect.setOnClickListener {
            val address = serverInput.text.toString().trim()

            if (address.isEmpty()) {
                Toast.makeText(
                    this,
                    "Introduce la dirección del servidor",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                statusText.text = "● Servidor: Pendiente de integración"
                statusText.setTextColor(Color.YELLOW)
                gpuText.text = "GPU: Sin verificar"
                Toast.makeText(
                    this,
                    "Interfaz preparada. Falta configurar el servidor de streaming.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        setContentView(scroll)
    }

    private fun text(
        value: String,
        size: Float,
        color: Int,
        bold: Boolean = false
    ): TextView {
        return TextView(this).apply {
            text = value
            textSize = size
            setTextColor(color)
            if (bold) setTypeface(null, Typeface.BOLD)
        }
    }

    private fun card(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(18), dp(18), dp(18), dp(18))
            background = rounded(panel, 16)
        }
    }

    private fun button(value: String): Button {
        return Button(this).apply {
            text = value
            setTextColor(Color.BLACK)
            textSize = 14f
            setTypeface(null, Typeface.BOLD)
            background = rounded(green, 12)
        }
    }

    private fun game(name: String): TextView {
        return text("🎮  $name", 14f, Color.WHITE, true).apply {
            setPadding(dp(12), dp(15), dp(12), dp(15))
            background = rounded(bg, 10)
            layoutParams = margin(0, 5, 0, 5)
        }
    }

    private fun rounded(color: Int, radius: Int): GradientDrawable {
        return GradientDrawable().apply {
            setColor(color)
            cornerRadius = dp(radius).toFloat()
        }
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()

    private fun margin(
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(dp(left), dp(top), dp(right), dp(bottom))
        }
    }
}
