package filters.greyScale

import models.pixels.GreyScalePixel

/**
 * Filter that flips a 2D array vertically or horizontally
 *
 * @param axis The axis along which to flip, 0 for x axis, 1 for y axis
 */
case class FlipFilter(axis: Int) extends GreyscaleFilter{
  require(axis == 0 || axis == 1, "invalid axis")
  /**
   * Flip an array of greyscale pixels vertically or horizontally
   *
   * @param item The array to flip
   *  @return A new, flipped array
   */
  override def applyFilter(item: Array[Array[GreyScalePixel]]): Array[Array[GreyScalePixel]] = {
    if(axis == 0) item.reverse
    else item.map(row => row.reverse)
  }
}
