package converters.image

import models.images.{AsciiImage, GreyscaleImage}

class GSToAsciiConverter extends ImageConverter[GreyscaleImage, AsciiImage] {
  override def convert(from: GreyscaleImage): AsciiImage = ???

}
