package filters.greyScale

import models.images.GreyScaleImage

case class FlipFilter(axis: Int) extends GreyscaleFilter{
  override def applyFilter(item: GreyScaleImage): GreyScaleImage = {
    val pixels = item.getPixels
    if(axis == 0) GreyScaleImage(pixels.reverse)
    else if (axis == 1) GreyScaleImage(pixels.map(row => row.reverse))
    else throw new IllegalArgumentException("invalid axis")
  }
}
