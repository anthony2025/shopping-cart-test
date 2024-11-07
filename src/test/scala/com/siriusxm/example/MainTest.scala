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
    val expected = 15.16
    val obtained = for {
      cheerios <- Main.getProduct("cheerios")
      flakes <- Main.getProduct("cornflakes")
      cart = Cart(products = List())
      cartWithCheerios = cart.addProduct(cheerios, 1)
      cartWithCheeriosAndFlakes = cartWithCheerios.addProduct(flakes, 2)
      total = cartWithCheeriosAndFlakes.total
    } yield total
    assertIO(obtained, expected)
  }

  test("can add two cornflakes and one weetabix and get the total from the README") {
    val expected = 16.9
    val obtained = for {
      flakes <- Main.getProduct("cornflakes")
      weetabix <- Main.getProduct("weetabix")
      cart = Cart(products = List())
      cartWithFlakes = cart.addProduct(flakes, 2)
      cartWithFlakesAndWeetabix = cartWithFlakes.addProduct(weetabix, 1)
      total = cartWithFlakesAndWeetabix.total
    } yield total
    assertIO(obtained, expected)
  }
}
