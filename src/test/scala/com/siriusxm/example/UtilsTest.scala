import munit.FunSuite

import com.siriusxm.example.Utils.DoubleOps

class UtilsTest extends FunSuite {
  test("rounds up and to two decimal places appropiately") {
    val expected = 42.25
    val obtained = (42.243).roundUp
    assertEquals(expected, obtained)
  }
}

