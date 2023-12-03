package creators.loaders.generators.pixel

import creators.generators.pixel.RandomRgbPixelGenerator
import models.pixels.RgbPixel
import org.scalatest.FunSuite

class RandomRgbPixelGeneratorTests extends FunSuite{
  test("create pixel"){
    //all i can really test is that it generated something that was an RgbPixel
    val generator = new RandomRgbPixelGenerator()
    val pixel: RgbPixel = generator.create()
  }
}
