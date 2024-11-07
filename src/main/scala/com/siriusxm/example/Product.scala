package com.siriusxm.example

import io.circe._, io.circe.generic.semiauto._, io.circe.syntax._

final case class Product(name: String, price: Float)

object Product {
  implicit val productDecoder: Decoder[Product] = deriveDecoder[Product]
  implicit val productEncoder: Encoder[Product] = deriveEncoder[Product]

  val baseProductsUrl = "https://raw.githubusercontent.com/mattjanks16/shopping-cart-test-data/main/"

  val availableProducts = List(
    "cheerios",
    "cornflakes",
    "frosties",
    "shreddies",
    "weetabix",
  )
}
