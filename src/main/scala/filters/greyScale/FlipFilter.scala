package filters.greyScale

import models.images.GreyScaleImage

case class FlipFilter(axis: Char) extends GreyscaleFilter{
  override def applyFilter(item: GreyScaleImage): GreyScaleImage = {
    val pixels = item.getPixels
    if(axis == 'x') GreyScaleImage(pixels.reverse)
    else if (axis == 'y') GreyScaleImage(pixels.map(row => row.reverse))
    else throw new IllegalArgumentException("invalid axis")
  }
}
