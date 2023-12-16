package models.images

import models.pixels.Pixel

import scala.reflect.ClassTag

abstract class Image[T <: Pixel : ClassTag] (private val pixels: Array[Array[T]]) {
  def getPixels: Array[Array[T]] = pixels.map(a => a.clone())
  def updatePixels(updater: Array[Array[T]] => Array[Array[T]]) : Image[T]
}
