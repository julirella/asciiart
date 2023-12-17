package creators

trait Creator[T] {
  /**
   * Creates an instance of something from nothing
   *
   * @return The created thing
   */
  def create() : T
}
