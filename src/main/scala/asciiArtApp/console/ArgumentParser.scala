package asciiArtApp.console

import asciiArtApp.console.arguments.filter.{BrightnessFilterArgument, FilterArgument, FlipFilterArgument, InversionFilterArgument}
import asciiArtApp.console.arguments.load.{ImageFromPathArgument, LoadArgument, RandomImageArgument}
import asciiArtApp.console.arguments.output.{ConsoleOutputArgument, FileOutputArgument, OutputArgument}
import asciiArtApp.console.arguments.table.{BuiltInTableArgument, CustomTableArgument, TableArgument}

class ArgumentParser(var args: Array[String]) {
  private var loadArgument: Option[LoadArgument] = None
  private var filterArguments: Array[FilterArgument] = Array[FilterArgument]()
  private var tableArgument: Option[TableArgument] = None
  private var outputArgument: Option[OutputArgument] = None

  private def updateLoadArgument(arg: LoadArgument): Unit = {
    if(loadArgument.isEmpty) loadArgument = Option(arg)
    else throw new IllegalArgumentException("too many load arguments")
  }

  private def addFilterArgument(arg: FilterArgument): Unit = {
    filterArguments = filterArguments.appended(arg)
  }

  private def updateTableArgument(arg: TableArgument): Unit = {
    if (tableArgument.isEmpty) tableArgument = Option(arg)
    else throw new IllegalArgumentException("too many table arguments")
  }

  private def updateOutputArgument(arg: OutputArgument): Unit = {
    if (outputArgument.isEmpty) outputArgument = Option(arg)
    else throw new IllegalArgumentException("too many output arguments")
  }
private def checkArguments(): Unit = {
  if(loadArgument.isEmpty) throw new IllegalArgumentException("missing load argument")
  if(tableArgument.isEmpty) throw new IllegalArgumentException("missing table argument")
  if(outputArgument.isEmpty) throw new IllegalArgumentException("missing output argument")
}

  def parseArguments(): Unit = {
    // TODO: this will break if the last argument is argWithString but no next argument is provided
    args = args.appended("--error") //kind of a hotfix for this
    var argNum = 0
    while (argNum < args.length - 1) {
      args(argNum) match {
        case "--image" =>
          updateLoadArgument(ImageFromPathArgument(args(argNum + 1)))
          argNum += 1

        case "--image-random" =>
          updateLoadArgument(RandomImageArgument())

        case "--invert" =>
          addFilterArgument(InversionFilterArgument())

        case "--flip" =>
          addFilterArgument(FlipFilterArgument(args(argNum + 1)))
          argNum += 1

        case "--brightness" =>
          addFilterArgument(BrightnessFilterArgument(args(argNum + 1)))
          argNum += 1

        case "--table" =>
          updateTableArgument(BuiltInTableArgument(args(argNum + 1)))
          argNum += 1

        case "--custom-table" =>
          updateTableArgument(CustomTableArgument(args(argNum + 1)))
          argNum += 1

        case "--output-console" =>
          updateOutputArgument(ConsoleOutputArgument())

        case "--output-file" =>
          updateOutputArgument(FileOutputArgument(args(argNum + 1)))
          argNum += 1

        case other:String => throw new IllegalArgumentException("unknown argument: " + other)
      }
      argNum += 1
    }

      checkArguments()

      val runner = new ArgumentRunner(loadArgument.get, filterArguments, tableArgument.get, outputArgument.get)
      runner.run()
  }
}
