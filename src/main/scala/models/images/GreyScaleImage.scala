package models.images

import models.pixels.GreyScalePixel

case class GreyScaleImage(private val pixels : List[List[GreyScalePixel]]) extends Image[GreyScalePixel] (pixels){
}
