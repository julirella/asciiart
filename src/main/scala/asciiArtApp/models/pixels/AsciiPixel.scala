package asciiArtApp.models.pixels

/**
 * Class representing an ascii pixel - a character with a printable value
 *
 * @param value the character
 */
case class AsciiPixel (val value: Char) extends Pixel {
  require(value >= 32 && value <= 126)
}
