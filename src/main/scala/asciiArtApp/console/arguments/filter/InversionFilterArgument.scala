package asciiArtApp.console.arguments.filter
import asciiArtApp.filters.greyScale.GreyscaleFilter
import asciiArtApp.filters.greyScale.oneToOne.InversionFilter

case class InversionFilterArgument() extends FilterArgument{
  override def createModule: InversionFilter = new InversionFilter()
}
