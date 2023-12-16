package helpers

import scala.reflect.ClassTag

class TwoDMapper {
  def map2D[From, To](from: List[List[From]], func: From => To): List[List[To]] = {
    from.map(e => e.map(func))
  }

  def map2D[From, To:ClassTag](from: Array[Array[From]], func: From => To): Array[Array[To]] = {
    from.map(e => e.map(func))
  }
}
