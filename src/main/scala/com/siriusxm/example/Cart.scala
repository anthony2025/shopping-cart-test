package com.siriusxm.example

import com.siriusxm.example.Utils.DoubleOps

final case class Cart(products: List[Product]) {
  def addProduct(product: Product): Cart = Cart(products :+ product)

  // AMBIGUETY: requirements unclear if rounding is to occur in everything or just the total
  def subtotal: Double = products.map(_.price).sum.roundUp

  def tax: Double = (subtotal * 0.125).roundUp

  def total: Double = (subtotal + tax).roundUp
}

