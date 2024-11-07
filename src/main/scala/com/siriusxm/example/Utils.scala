package com.siriusxm.example

object Utils {
  implicit class DoubleOps(number: Double) {
    // rounds up keeping two decimal places
    // was a little unsure if this or CEILING was the right mode choice, added tests to find out
    def roundUp: Double =
      BigDecimal(number).setScale(2, BigDecimal.RoundingMode.UP).toDouble
  }
}
