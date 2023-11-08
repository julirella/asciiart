package converters.image

import converters.Converter
import models.images.Image

trait ImageConverter[A <: Image, B <: Image] extends Converter[A, B]{

}
