package models.images

import models.pixels.AsciiPixel

/**
 * Class representing an ascii image - a matrix of ascii pixels
 *
 * @param pixels the matrix of pixels
 */
case class AsciiImage(private val pixels: Array[Array[AsciiPixel]]) extends Image[AsciiPixel] (pixels) {
  override def updatePixels(updater: Array[Array[AsciiPixel]] => Array[Array[AsciiPixel]]): AsciiImage = {
    AsciiImage(updater(getPixels))
  }
}