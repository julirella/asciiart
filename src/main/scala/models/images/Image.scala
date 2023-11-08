package models.images

trait Image {
  def updateContent[T <: Image](updater: T => T): T = {
    updater(this)
  }
}
