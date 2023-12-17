package helpers

class TwoDCompare {


  /**
   * Compares two 2D arrays.
   * Elements of both arrays must have equals implemented.
   *
   * @param left One 2D array
   * @param right Another 2D array
   * @return True if arrays are of the same shape and all elements are the same,
   *         else false
   */
  def cmp2DArray[T](left: Array[Array[T]], right: Array[Array[T]]): Boolean = {
    if(left.length == 0 && right.length == 0) return true
    if(left.length != right.length) return false
    for(i <- left.indices)
      if(! left(i).sameElements(right(i))) return false
    true
  }
}
