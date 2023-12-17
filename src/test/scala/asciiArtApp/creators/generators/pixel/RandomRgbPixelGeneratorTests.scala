package asciiArtApp.creators.generators.pixel

import asciiArtApp.models.pixels.RgbPixel
import org.scalatest.FunSuite

class RandomRgbPixelGeneratorTests extends FunSuite{
  test("create pixel"){
    val generator = new RandomRgbPixelGenerator()
    val pixel = generator.create()
    assert(pixel.isInstanceOf[RgbPixel])
  }
}
