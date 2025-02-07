package com.samuel.technical_test_agiletv.utils


import java.text.DecimalFormat
import java.util.Locale

fun weightMask(weight: Int): String {
  val kilogram = weight / 10.0
  val format = DecimalFormat("0.0")
  return format.format(kilogram).replace(".", ",")
}

fun heightMask(height: Int): String {
  val meters = height / 10.0
  val format = DecimalFormat("0.0")
  return format.format(meters).replace(".", ",")
}