package console

import asciiArtApp.converters.AsciiImageToStringConverter
import console.arguments.filter.FilterArgument
import console.arguments.load.LoadArgument
import console.arguments.output.OutputArgument
import console.arguments.table.TableArgument
import converters.image.RgbToGSConverter
import models.images.{AsciiImage, GreyScaleImage, RgbImage}

class ArgumentRunner(val creatorArg: LoadArgument, val filterArgs: Array[FilterArgument],
                     val tableArg: TableArgument, val outputArg: OutputArgument) {
  def run(): Unit = {
    //load
    val loadedImage: RgbImage = creatorArg.createModule.create()

    //filter
    val gsImage: GreyScaleImage = new RgbToGSConverter().convert(loadedImage)
    val filteredImage: GreyScaleImage = filterArgs.foldLeft(gsImage)((img, filterArg) => img.updatePixels(filterArg.createModule.applyFilter))

    //convert
    val asciiImage: AsciiImage = tableArg.createModule.convert(filteredImage)

    //export
    val textImage: String = new AsciiImageToStringConverter().convert(asciiImage)
    outputArg.createModule.export(textImage)
  }
}
