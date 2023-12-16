package converters

import models.images.AsciiImage
import models.pixels.AsciiPixel

class AsciiImageToStringConverter extends Converter [AsciiImage, String]{
  private def lineToString(line: Array[AsciiPixel]): String = {
    val ret = line.foldLeft("")((str, pixel) => str.appended(pixel.value))
    ret
  }
  override def convert(from: AsciiImage): String = {
    val image = from.getPixels
    val ret = image.foldLeft("")((str, line) => str.concat(lineToString(line) + "\n"))
    ret
  }
}
