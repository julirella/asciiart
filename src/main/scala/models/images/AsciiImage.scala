package models.images

import models.pixels.AsciiPixel

case class AsciiImage(private val pixels: Array[Array[AsciiPixel]]) extends Image[AsciiPixel] (pixels) {
  override def updatePixels(updater: Array[Array[AsciiPixel]] => Array[Array[AsciiPixel]]): AsciiImage = {
    AsciiImage(updater(pixels))
  }
}
