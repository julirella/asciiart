package filters.greyScale

import filters.Filter
import models.pixels.GreyScalePixel

//could accept GreyScaleImage instead and then override apply function to extract the list
trait GreyscaleFilter extends Filter[Array[Array[GreyScalePixel]]]{

}
