package console.arguments.filter

import console.arguments.ArgumentWithString
import filters.greyScale.{FlipFilter, GreyscaleFilter}

case class FlipFilterArgument(axis: String) extends ArgumentWithString(axis) with FilterArgument {
  require(axis == "x" || axis == "y", "invalid flip axis")
  override def createModule: FlipFilter = {
    if (axis == "x") new FlipFilter(0)
    else  new FlipFilter(1)
  }
}
