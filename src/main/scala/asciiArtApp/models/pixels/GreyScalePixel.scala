package asciiArtApp.models.pixels

/**
 * Class representing an 8-bit greyscale pixel
 * @param value the value of the pixel (an integer between 0 and 255)
 */
case class GreyScalePixel(val value : Int) extends Pixel {
  require(value >= 0 && value <= 255, "wrong greyscale pixel value")
}
