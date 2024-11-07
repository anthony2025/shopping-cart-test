package com.siriusxm.example

import com.siriusxm.example.Utils.DoubleOps

case class Cart(products: List[Product]) {
  def subtotal = products.map(_.price).sum.roundUp

  def tax = ???

  def total = ???
}

