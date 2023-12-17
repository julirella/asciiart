package models.images
import models.pixels.RgbPixel

/**
 * Class representing an RGB image - a matrix of RGB pixels
 *
 * @param pixels the matrix of pixels
 */
case class RgbImage(private val pixels: Array[Array[RgbPixel]]) extends Image[RgbPixel] (pixels) {
  override def updatePixels(updater: Array[Array[RgbPixel]] => Array[Array[RgbPixel]]): RgbImage = {
    RgbImage(updater(getPixels))
  }
}
