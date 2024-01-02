package com.example.tiptime

import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount : Double = 100.0
        val tipPercent : Double = 20.0
        val expectedTip : String = NumberFormat.getCurrencyInstance().format(20)
        val actualTip : String = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}