import cats.effect.IO
import munit.CatsEffectSuite

import com.siriusxm.example._
import com.siriusxm.example.Product._

class MainTest extends CatsEffectSuite {
  test("can create a http client") {

  }

  test("tests can return IO[Unit] with assertions expressed via a map") {
    IO(42).map(it => assertEquals(it, 42))
  }

  test("alternatively, assertions can be written via assertIO") {
    assertIO(IO(42), 42)
  }

  test("or via assertEquals syntax") {
    IO(42).assertEquals(42)
  }

  test("or via plain assert syntax on IO[Boolean]") {
    IO(true).assert
  }
}
