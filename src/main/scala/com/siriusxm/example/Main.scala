package com.siriusxm.example

import cats.effect.IOApp
import cats.effect.IO

import com.siriusxm.example.Product.{baseProductsUrl, availableProducts}

object Main extends IOApp.Simple {

  def run: IO[Unit] = {
    IO(println(baseProductsUrl)) >> IO(println(availableProducts))
  }
}
