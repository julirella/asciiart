package asciiArtApp.console.arguments.load

import asciiArtApp.creators.generators.image.RandomRgbImageGenerator
import asciiArtApp.console.arguments.Argument
import creators.Creator
import asciiArtApp.models.images.RgbImage

case class RandomImageArgument() extends LoadArgument{
  override def createModule: RandomRgbImageGenerator = new RandomRgbImageGenerator()
}
