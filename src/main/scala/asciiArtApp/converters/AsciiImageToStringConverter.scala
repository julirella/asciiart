package asciiArtApp.converters

import converters.Converter
import asciiArtApp.models.images.AsciiImage
import asciiArtApp.models.pixels.AsciiPixel

class AsciiImageToStringConverter extends Converter [AsciiImage, String]{
  /**
   * Convert array of ascii pixels to string
   *
   * @param line the array to convert
   * @return the resulting string
   */
  private def lineToString(line: Array[AsciiPixel]): String = {
    val ret = line.foldLeft("")((str, pixel) => str.appended(pixel.value))
    ret
  }

  /**
   * Convert an ascii image to a string
   *
   * @param from The image to convert
   *  @return The image in string format
   */
  override def convert(from: AsciiImage): String = {
    val image = from.getPixels
    val ret = image.foldLeft("")((str, line) => str.concat(lineToString(line) + "\n"))
    ret
  }
}
