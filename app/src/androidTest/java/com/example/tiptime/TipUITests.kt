package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule() //cria uma regra para o teste. É por aqui que vamos acessar o conteúdo do app

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent { //é preciso definir o conteúdo do teste assim como no onCreate
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount") //encontra o nó com o texto "Bill Amount"
            .performTextInput("100") //executa uma ação nele
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(20.0)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found")
    }


}