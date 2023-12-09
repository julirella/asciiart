package creators.loaders.generators.image

import creators.generators.image.RandomRgbImageGenerator
import models.images.RgbImage
import org.scalatest.FunSuite

class RandomRgbImageGeneratorTests extends FunSuite{
  val generator = new RandomRgbImageGenerator()
  test("generate image"){
    val image: RgbImage = generator.create()
    val pixels = image.getPixels
    assert(pixels.length >= 20 && pixels.length <= 150)
    assert(pixels.head.length >= 20 && pixels.head.length <= 200)
  }
}
