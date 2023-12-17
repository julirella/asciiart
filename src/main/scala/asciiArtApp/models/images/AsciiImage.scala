package asciiArtApp.models.images

import asciiArtApp.models.pixels.AsciiPixel

/**
 * Class representing an ascii image - a matrix of ascii pixels
 *
 * @param pixels the matrix of pixels
 */
class AsciiImage(private val pixels: Array[Array[AsciiPixel]]) extends Image[AsciiPixel] (pixels) {
  override def updatePixels(updater: Array[Array[AsciiPixel]] => Array[Array[AsciiPixel]]): AsciiImage = {
    new AsciiImage(updater(getPixels))
  }
}