package com.siriusxm.example

import cats.effect.IO
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder
import org.http4s.EntityDecoder
import org.http4s.circe.jsonOf

final case class Product(title: String, price: Double)

object Product {
  implicit val productDecoder: Decoder[Product] = deriveDecoder[Product]
  implicit val productEntityDecoder: EntityDecoder[IO, Product] = jsonOf[IO, Product]

  val baseProductsUrl = "https://raw.githubusercontent.com/mattjanks16/shopping-cart-test-data/main/"

  val availableProducts = List(
    "cheerios",
    "cornflakes",
    "frosties",
    "shreddies",
    "weetabix",
  )
}
