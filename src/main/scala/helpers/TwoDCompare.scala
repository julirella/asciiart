package helpers

class TwoDCompare {
  def cmp2DArray[T](left: Array[Array[T]], right: Array[Array[T]]): Boolean = {
    if(left.length == 0 && right.length == 0) return true
    if(left.length != right.length) return false
    for(i <- left.indices)
      if(! left(i).sameElements(right(i))) return false
    true
  }
}
