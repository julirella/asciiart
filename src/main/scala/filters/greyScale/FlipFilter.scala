package filters.greyScale

case class FlipFilter(axis: Char) extends GreyscaleFilter{

  override def applyFilter(pixels: List[List[Int]]): List[List[Int]] = {
    if(axis == 'x') pixels.reverse
    else if (axis == 'y') pixels.map(row => row.reverse)
    else ???
  }
}
