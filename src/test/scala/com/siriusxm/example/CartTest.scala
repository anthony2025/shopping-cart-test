import munit.FunSuite

import com.siriusxm.example.{Cart, Product}

class CartTest extends FunSuite {
  val cheerios = Product(title = "Cheerios", price = 8.43)
  val flakes = Product(title = "Corn Flakes", price = 2.52)
  val fullCart = Cart(products = List(cheerios, flakes))
  val emptyCart = Cart(products = List())

  test("can add products appropiately") {
    val expected = fullCart
    val obtained = emptyCart.addProduct(cheerios).addProduct(flakes)
    assertEquals(expected, obtained)
  }

  test("calculates subtotal appropiately") {
    val expected = 10.95
    val obtained = fullCart.subtotal
    assertEquals(expected, obtained)
  }

  test("calculates tax appropiately") {
    val expected = 1.37
    val obtained = fullCart.tax
    assertEquals(expected, obtained)
  }

  test("calculates total appropiately") {
    val expected = 12.32
    val obtained = fullCart.total
    assertEquals(expected, obtained)
  }
}

