package asciiArtApp.console

import asciiArtApp.converters.AsciiImageToStringConverter
import asciiArtApp.console.arguments.filter.FilterArgument
import asciiArtApp.console.arguments.load.LoadArgument
import asciiArtApp.console.arguments.output.OutputArgument
import asciiArtApp.console.arguments.table.TableArgument
import asciiArtApp.converters.image.RgbToGSConverter
import asciiArtApp.models.images.{AsciiImage, GreyScaleImage, RgbImage}

class ArgumentRunner(val creatorArg: LoadArgument, val filterArgs: Array[FilterArgument],
                     val tableArg: TableArgument, val outputArg: OutputArgument) {
  /**
   * Run the whole ascii conversion
   */
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
