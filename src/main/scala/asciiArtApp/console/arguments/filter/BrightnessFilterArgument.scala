package console.arguments.filter

import asciiArtApp.filters.greyScale.oneToOne.BrightnessFilter
import console.arguments.ArgumentWithString

case class BrightnessFilterArgument(value: String) extends ArgumentWithString(value) with FilterArgument {
  require(value.toIntOption.isDefined, "brightness value must be an integer")

  override def createModule: BrightnessFilter = {
    val numValue = value.toInt
    new BrightnessFilter(numValue)
  }
}
