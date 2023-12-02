package creators

trait Creator[T] {
  def create() : T
}
