package com.siriusxm.example

import cats.effect.{IO, IOApp}
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.client.Client
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory

import com.siriusxm.example.Product._

object Main extends IOApp.Simple {
  private implicit val loggerFactory: LoggerFactory[IO] =
    Slf4jFactory.create[IO]

  def pollProductPrice(product: String)(client: Client[IO]): IO[Double] =
    client
      .expect[Product](productUrl(product))
      .map(_.price)

  def run: IO[Unit] =
    EmberClientBuilder
      .default[IO]
      .build
      .use(client => pollProductPrice("cheerios")(client))
      .map(IO.println)
      .void
}

  //IO.println(availableProducts.map(productUrl(_)))
