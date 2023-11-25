package filters.greyScale

import filters.Filter
import models.images.GreyScaleImage

//could accept GreyScaleImage instead and then override apply function to extract the list
trait GreyscaleFilter extends Filter[List[List[Int]]]{

}
