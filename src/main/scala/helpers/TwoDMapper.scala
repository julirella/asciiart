package helpers

class TwoDMapper {
  def map2D[From, To](from: List[List[From]], func: From => To): List[List[To]] = {
    from.map(e => e.map(func))
  }
}
