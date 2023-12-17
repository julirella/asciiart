package filters

trait Filter[T] {
  /**
   * Changes an item to a different item of the same data type.
   *
   * @param item The item to be chagned
   * @return The new item
   */
  def applyFilter(item : T): T
}
