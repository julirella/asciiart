package console

import console.arguments.load.LoadArgument
import models.images.RgbImage

class ArgumentRunner(val creatorArg: LoadArgument) {
//  private var imageCreator: Option[Creator[RgbImage]] = None
  def run() = {
    //load
    val loadedImage: RgbImage = creatorArg.createModule.create()
    //filter

    //convert
    //export
  }
}
