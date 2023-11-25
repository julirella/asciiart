package models.images

import models.pixels.Pixel

abstract class Image[T <: Pixel] (private val pixels: List[List[T]]) {
  def getPixels: List[List[T]] = pixels
//  def updateContent[T <: Image[S]](updater: T => T): T = {
//    updater(this)
//  }
}
