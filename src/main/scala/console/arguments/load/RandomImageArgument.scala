package console.arguments.load

import console.arguments.Argument
import creators.Creator
import creators.generators.image.RandomRgbImageGenerator
import models.images.RgbImage

case class RandomImageArgument() extends LoadArgument{
  override def createModule: RandomRgbImageGenerator = new RandomRgbImageGenerator()
}
