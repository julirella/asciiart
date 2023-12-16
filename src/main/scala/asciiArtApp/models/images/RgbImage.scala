package models.images
import models.pixels.RgbPixel

case class RgbImage(private val pixels: Array[Array[RgbPixel]]) extends Image[RgbPixel] (pixels) {
  override def updatePixels(updater: Array[Array[RgbPixel]] => Array[Array[RgbPixel]]): RgbImage = {
    RgbImage(updater(pixels))
  }
}
