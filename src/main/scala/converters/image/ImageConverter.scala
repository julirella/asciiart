package converters.image

import converters.Converter
import models.images.Image
import models.pixels.Pixel

trait ImageConverter[A <: Image[T], B <: Image[S], T <: Pixel, S <: Pixel] extends Converter[A, B]{
  protected def convertPixel(from: T): S

}
