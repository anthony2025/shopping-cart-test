package com.siriusxm.example

object Utils {
  implicit class DoubleOps(number: Double) {
    // rounds up keeping two decimal places, a little unsure if UP or CEILING is the right mode choice
    def roundUp: Double =
      BigDecimal(number).setScale(2, BigDecimal.RoundingMode.UP).toDouble
  }
}
