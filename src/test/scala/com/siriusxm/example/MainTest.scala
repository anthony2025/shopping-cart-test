import cats.effect.IO
import munit.CatsEffectSuite

import com.siriusxm.example._

class MainTest extends CatsEffectSuite {
  test("can find the price for cheerios") {
    val expected = 8.43
    val obtained = Main.pollProductPrice("cheerios")
    assertIO(obtained, expected)
  }

  test("can add both cheerios and cornflakes to cart and get a total with tax") {
    val expected = 12.32
    val obtained = for {
      cheerios <- Main.getProduct("cheerios")
      flakes <- Main.getProduct("cornflakes")
      cart = Cart(products = List())
      cartWithCheerios = cart.addProduct(cheerios)
      cartWithCheeriosAndFlakes = cartWithCheerios.addProduct(flakes)
      total = cartWithCheeriosAndFlakes.total
    } yield total
    assertIO(obtained, expected)
  }
}
