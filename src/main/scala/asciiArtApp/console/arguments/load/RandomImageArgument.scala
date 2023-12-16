package console.arguments.load

import asciiArtApp.creators.generators.image.RandomRgbImageGenerator
import console.arguments.Argument
import creators.Creator
import models.images.RgbImage

case class RandomImageArgument() extends LoadArgument{
  override def createModule: RandomRgbImageGenerator = new RandomRgbImageGenerator()
}
