package models.images

abstract class Image[S] (private val pixels: List[List[S]]) {
  def getPixels: List[List[S]] = pixels
//  def updateContent[T <: Image[S]](updater: T => T): T = {
//    updater(this)
//  }
}
