package asciiArtApp.creators.generators.image

import asciiArtApp.creators.generators.pixel.RandomPixelGenerator
import creators.generators.RandomGenerator
import asciiArtApp.models.images.Image
import asciiArtApp.models.pixels.Pixel

import scala.reflect.ClassTag
import scala.util.Random

abstract class RandomImageGenerator[I <: Image[P], P <: Pixel : ClassTag] extends RandomGenerator[I]{
  protected val pixelGenerator : RandomPixelGenerator[P]
  private def randomWidth = Random.between(20, 200)
  private def randomHeight = Random.between(20, 150)
  private def generatePixel : P = pixelGenerator.create()
  protected def createImage(pixels: Array[Array[P]]): I

  /**
   * Generate random image
   *  @return The generated image
   */
  override def create(): I = {
    val width = randomWidth
    val height = randomHeight
    val pixels = Array.ofDim[P](height, width)
    for(w <- 0 until width)
      for(h <- 0 until height)
        pixels(h)(w) = generatePixel
    createImage(pixels)
  }
}
