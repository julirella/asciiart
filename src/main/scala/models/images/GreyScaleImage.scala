package models.images

import models.pixels.GreyScalePixel

case class GreyScaleImage(private val pixels : Array[Array[GreyScalePixel]]) extends Image[GreyScalePixel] (pixels){
  override def updatePixels(updater: Array[Array[GreyScalePixel]] => Array[Array[GreyScalePixel]]): GreyScaleImage = {
    GreyScaleImage(updater(pixels))
  }
}
