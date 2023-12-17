package asciiArtApp.converters.image

import converters.Converter
import asciiArtApp.models.images.Image
import asciiArtApp.models.pixels.Pixel

/**
 * Convert one type of image to another
 *
 * @tparam A type of image to convert from
 * @tparam B type of image to convert to
 * @tparam T type of pixel of image to convert from
 * @tparam S type of pixel of image to convert to
 */
trait ImageConverter[A <: Image[T], B <: Image[S], T <: Pixel, S <: Pixel] extends Converter[A, B]{
  /**
   * convert a pixel from one type of pixel to another
   *
   * @param from the pixel to convert from
   * @return the new, converted pixel
   */
  protected def convertPixel(from: T): S
}
