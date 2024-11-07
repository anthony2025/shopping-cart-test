import munit.FunSuite
import io.circe.parser._

import com.siriusxm.example.Product.productDecoder
import com.siriusxm.example.Product

class ProductTest extends FunSuite {
  val cheerios = Product(title = "Cheerios", price = 8.43)
  val nullProduct = Product(_, _)

  test("the Decoder can decode json to Product appropiately") {
    val expected = cheerios
    val rawProductJson: String = """
      {
        "title": "Cheerios",
        "price": 8.43
      }
      """
    val obtained = decode[Product](rawProductJson).getOrElse(nullProduct)
    assertEquals(expected, obtained)
  }
}
