package com.siriusxm.example

case class Product(name: String, price: Float)

object Products {
  val baseProductsUrl = "https://raw.githubusercontent.com/mattjanks16/shopping-cart-test-data/main/"

  val availableProducts = List(
    "cheerios",
    "cornflakes",
    "frosties",
    "shreddies",
    "weetabix",
  )
}
