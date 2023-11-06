package filters.greyScale.oneToOne

case class BrightnessFilter(value: Int) extends OneToOneFilter {
  override def applyToOnePixel(pixel: Int): Int = {
    val newPixel = pixel + value
    if(newPixel > 255) 255
    else if(newPixel < 0) 0
    else newPixel
  }
}
