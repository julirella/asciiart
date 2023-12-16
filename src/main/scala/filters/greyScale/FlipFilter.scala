package filters.greyScale

import models.pixels.GreyScalePixel

case class FlipFilter(axis: Int) extends GreyscaleFilter{
  override def applyFilter(item: Array[Array[GreyScalePixel]]): Array[Array[GreyScalePixel]] = {
    if(axis == 0) item.reverse
    else if (axis == 1) item.map(row => row.reverse)
    else throw new IllegalArgumentException("invalid axis")
  }
}
