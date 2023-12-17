package converters

trait Converter[A, B]{
  /**
   * Converts something to something else
   *
   * @param from The thing to convert from
   * @return The converted thing
   */
  def convert(from: A): B
}
