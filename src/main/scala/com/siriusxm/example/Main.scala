package com.siriusxm.example

import cats.effect.Resource
import cats.effect.{IO, IOApp}
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.client.Client
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory

import com.siriusxm.example.Product._

object Main extends IOApp.Simple {
  private implicit val loggerFactory: LoggerFactory[IO] =
    Slf4jFactory.create[IO]

  def getProduct(product: String): IO[Product] =
    createHttpClient
      .use { client =>
        client
          .expect[Product](productUrl(product))
      }

  def pollProductPrice(product: String): IO[Double] =
    getProduct(product).map(_.price)

  def createHttpClient: Resource[IO, Client[IO]] =
    EmberClientBuilder
      .default[IO]
      .build

  def run: IO[Unit] = IO.println(availableProducts.map(productUrl(_)))
}

