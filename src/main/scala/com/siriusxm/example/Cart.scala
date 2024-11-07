package com.siriusxm.example

import com.siriusxm.example.Utils.DoubleOps

final case class Cart(products: List[Product]) {
  def subtotal = products.map(_.price).sum

  def tax = (subtotal * 0.125)

  // AMBIGUETY: requirements unclear if rounding is to occur in anything but the total
  def total = (subtotal + tax).roundUp
}

