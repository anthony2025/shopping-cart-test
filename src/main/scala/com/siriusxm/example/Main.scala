package com.siriusxm.example

import cats.effect.IOApp
import cats.effect.IO

import com.siriusxm.example.Products.{baseProductsUrl, availableProducts}

object Main extends IOApp.Simple {

  def run: IO[Unit] = {
    IO(println(Products.baseProductsUrl)) >> IO(println(Products.availableProducts))
  }
}
