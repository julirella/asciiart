package models.pixels

/**
 * Class representing an RGB pixel consisting of 8-bit color elements
 *
 * @param red The red element of the pixel (an integer between 0 and 255)
 * @param green The green element of the pixel (an integer between 0 and 255)
 * @param blue The blue element of the pixel (an integer between 0 and 255)
 */
case class RgbPixel(val red: Int, val green: Int, val blue: Int) extends Pixel{
  require(red >= 0 && green >= 0 && blue >= 0 && red <= 255 && blue <= 255 && green <= 255, "values must be between 0 and 255")
}
