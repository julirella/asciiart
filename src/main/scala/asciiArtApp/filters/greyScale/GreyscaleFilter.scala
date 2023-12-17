package filters.greyScale

import filters.Filter
import models.pixels.GreyScalePixel

/**
 * Filter that filters a 2D array of greyscale pixels
 */
trait GreyscaleFilter extends Filter[Array[Array[GreyScalePixel]]]{

}
