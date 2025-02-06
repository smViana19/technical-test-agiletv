package com.samuel.technical_test_agiletv.utils

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import java.util.Locale

fun weightMask(weight: Int): String {
  val kilogram = weight / 10.0
  val format = DecimalFormat("#0.0", DecimalFormatSymbols(Locale("pt", "BR")))
  return format.format(kilogram)
}

fun heightMask(height: Int): String {
  val meters = height / 10.0
  val format = DecimalFormat("#0.0", DecimalFormatSymbols(Locale("pt", "BR")))
  return format.format(meters)
}