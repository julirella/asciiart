package asciiArtApp.models.images

import asciiArtApp.models.pixels.Pixel

import scala.reflect.ClassTag

/**
 * Class representing a matrix of pixels - an image
 *
 * @param pixels the matrix of pixels
 */
abstract class Image[T <: Pixel : ClassTag] (private val pixels: Array[Array[T]]) {
  /**
   * Getter for pixels
   *
   * @return A copy of pixels
   */
  def getPixels: Array[Array[T]] = pixels.map(a => a.clone())

  /**
   * Produces a new image with pixels modified by the updater function
   *
   * @param updater the function to be applied
   * @return a new image with the updated matrix of pixels
   */
  def updatePixels(updater: Array[Array[T]] => Array[Array[T]]) : Image[T]
}
