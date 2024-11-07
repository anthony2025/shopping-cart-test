package com.siriusxm.example

import com.siriusxm.example.Utils.DoubleOps

final case class Cart(products: List[Product]) {
  def subtotal = products.map(_.price).sum.roundUp

  def tax = (subtotal * 112.5).roundUp

  // ambiguety in requirements, perhaps we should only round on the total
  def total = (subtotal + tax).roundUp
}

