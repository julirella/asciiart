package models.pixels

class RgbPixel(val red: Int, val green: Int, val blue: Int) extends Pixel{
  require(red >= 0 && green >= 0 && blue >= 0 && red <= 255 && blue <= 255 && green <= 255, "values must be between 0 and 255")
}
