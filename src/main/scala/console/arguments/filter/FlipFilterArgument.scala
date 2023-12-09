package console.arguments.filter

import console.arguments.ArgumentWithString
import filters.greyScale.{FlipFilter, GreyscaleFilter}

case class FlipFilterArgument(axis: String) extends ArgumentWithString(axis) with FilterArgument {
  override def createModule: GreyscaleFilter = {
    if(axis == "x") new FlipFilter(0)
    else if(axis == "y") new FlipFilter(1)
    else throw new IllegalArgumentException("invalid flip axis")
  }
}
