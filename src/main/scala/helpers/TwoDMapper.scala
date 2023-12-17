package helpers

import scala.reflect.ClassTag

class TwoDMapper {
  /**
   * Maps a function to each element of a 2D list
   *
   * @param from The list to be modified
   * @param func The function to map to each element
   * @return A new list with the mapped elements
   */
  def map2D[From, To](from: List[List[From]], func: From => To): List[List[To]] = {
    from.map(e => e.map(func))
  }


  /**
   * Maps a function to each element of a 2D array
   *
   * @param from The array to be modified
   * @param func The function to map to each element
   * @return A new array with the mapped elements
   */
  def map2D[From, To:ClassTag](from: Array[Array[From]], func: From => To): Array[Array[To]] = {
    from.map(e => e.map(func))
  }
}
