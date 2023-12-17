package exporters

trait Exporter[T] {
  /**
   * Exports something somewhere
   *
   * @param toExport the item to be exported
   */
  def export(toExport: T): Unit
}
