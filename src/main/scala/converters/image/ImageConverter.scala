package converters.image

import converters.Converter
import models.images.Image

trait ImageConverter[A <: Image[S], B <: Image[T], S, T] extends Converter[A, B]{

}
