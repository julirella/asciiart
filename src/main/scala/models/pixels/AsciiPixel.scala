package models.pixels

case class AsciiPixel (val value: Char) extends Pixel {
  require(value >= 32 && value <= 126)
}
