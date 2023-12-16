package asciiArtApp.creators.generators.image

import creators.generators.RandomGenerator
import models.images.Image
import models.pixels.Pixel

import scala.reflect.ClassTag
import scala.util.Random

abstract class RandomImageGenerator[I <: Image[P], P <: Pixel : ClassTag] extends RandomGenerator[I]{
  private def randomWidth = Random.between(20, 200)
  private def randomHeight = Random.between(20, 150)
  protected def createPixel : P
  protected def createImage(pixels: Array[Array[P]]): I
  override def create(): I = {
    val width = randomWidth
    val height = randomHeight
    val pixels = Array.ofDim[P](height, width)
    for(w <- 0 until width)
      for(h <- 0 until height)
        pixels(h)(w) = createPixel
    createImage(pixels)
  }
}
