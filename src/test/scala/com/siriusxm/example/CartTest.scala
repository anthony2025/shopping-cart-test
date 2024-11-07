import munit.FunSuite

import com.siriusxm.example.{Cart, Product}

class CartTest extends FunSuite {
  val cheerios = Product(title = "Cheerios", price = 8.43)
  val cornflakes = Product(title = "Corn Flakes", price = 2.52)
  val cart = Cart(products = List(cheerios, cornflakes))

  test("calculates subtotal appropiately") {
    val expected = 10.95
    val obtained = cart.subtotal
    assertEquals(expected, obtained)
  }

  test("calculates tax appropiately") {
    val expected = 1.36875
    val obtained = cart.tax
    assertEquals(expected, obtained)
  }

  test("calculates total appropiately") {
    val expected = 12.32
    val obtained = cart.total
    assertEquals(expected, obtained)
  }
}

