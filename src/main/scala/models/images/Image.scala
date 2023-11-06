package models.images

trait Image[T] {
  def updateContent(updater: T => T): Image[T] = ???
}
