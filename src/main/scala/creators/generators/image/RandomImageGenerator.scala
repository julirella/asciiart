package creators.generators.image

import creators.generators.RandomGenerator
import models.images.Image
import models.pixels.Pixel

import scala.util.Random

trait RandomImageGenerator[I <: Image[P], P <: Pixel] extends RandomGenerator[I]{
  private def randomWidth = Random.between(20, 200)
  private def randomHeight = Random.between(20, 150)
  def createPixel : P

  override def create(): I = {
    val width = randomWidth
    val height = randomHeight
    val tmpArray = Array.ofDim[P](height, width)
    for(w <- 0 until width)
      for(h <- 0 until height)
        tmpArray(h)(w) = createPixel
    new I(tmpArray.map(e => e.toList).toList)
  }
}
