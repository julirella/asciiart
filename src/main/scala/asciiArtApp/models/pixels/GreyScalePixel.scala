package models.pixels

case class GreyScalePixel(val value : Int) extends Pixel {
  require(value >= 0 && value <= 255)
}
