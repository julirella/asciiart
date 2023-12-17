package models.images

import models.pixels.GreyScalePixel

/**
 * Class representing a greyscale image - a matrix of greyscale pixels
 *
 * @param pixels the matrix of pixels
 */
class GreyScaleImage(private val pixels : Array[Array[GreyScalePixel]]) extends Image[GreyScalePixel] (pixels){
  override def updatePixels(updater: Array[Array[GreyScalePixel]] => Array[Array[GreyScalePixel]]): GreyScaleImage = {
    new GreyScaleImage(updater(getPixels))
  }
}
