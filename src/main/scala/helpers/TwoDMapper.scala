package helpers

trait TwoDMapper[From, To] {
  def map2D(from: List[List[From]], func: From => To): List[List[To]] = {
    from.map(e => e.map(func))
  }
}
