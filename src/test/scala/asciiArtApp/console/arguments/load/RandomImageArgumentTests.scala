package asciiArtApp.console.arguments.load

import asciiArtApp.creators.generators.image.RandomRgbImageGenerator
import console.arguments.load.RandomImageArgument
import org.scalatest.FunSuite

class RandomImageArgumentTests extends FunSuite{
  test("generator instance created") {
    val argument = RandomImageArgument()
    val generator = argument.createModule
    assert(generator.isInstanceOf[RandomRgbImageGenerator])
  }
}
