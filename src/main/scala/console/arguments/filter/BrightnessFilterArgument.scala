package console.arguments.filter

import console.arguments.ArgumentWithString
import filters.greyScale.GreyscaleFilter
import filters.greyScale.oneToOne.BrightnessFilter

case class BrightnessFilterArgument(value: String) extends ArgumentWithString(value) with FilterArgument {
  override def createModule: GreyscaleFilter = {
    try{
      val numValue = value.toInt
      new BrightnessFilter(numValue)
    } catch {
      case _:Throwable => throw new IllegalArgumentException("brightness value must be an integer")
    }
  }
}
