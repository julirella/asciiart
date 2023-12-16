package console.arguments.load

import creators.generators.image.RandomRgbImageGenerator
import org.scalatest.FunSuite

class RandomImageArgumentTests extends FunSuite{
  test("generator instance created") {
    val argument = RandomImageArgument()
    val generator = argument.createModule
    assert(generator.isInstanceOf[RandomRgbImageGenerator])
  }
}
