package console.arguments.filter
import filters.greyScale.GreyscaleFilter
import filters.greyScale.oneToOne.InversionFilter

case class InversionFilterArgument() extends FilterArgument{
  override def createModule: GreyscaleFilter = new InversionFilter()
}
