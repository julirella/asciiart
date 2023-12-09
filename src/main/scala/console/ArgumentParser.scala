package console

import console.arguments.filter.{BrightnessFilterArgument, FilterArgument, FlipFilterArgument, InversionFilterArgument}
import console.arguments.load.{ImageFromPathArgument, LoadArgument, RandomImageArgument}

class ArgumentParser(args: Array[String]) {
  private var loadArgument: Option[LoadArgument] = None
  private var filterArguments: Array[FilterArgument] = Array[FilterArgument]

  private def updateLoadArgument(arg: LoadArgument): Unit = {
    if(loadArgument.isEmpty) loadArgument = Option(arg)
    else throw new IllegalArgumentException("too many load arguments")
  }

  private def addFilterArgument(arg: FilterArgument): Unit = {
    filterArguments = filterArguments.appended(arg)
  }
  def parseArguments(): Unit = {
    //TODO: this will break if the last argument is argWithString but no next argument is provided
    var argNum = 0
    while (argNum < args.length) {
      args(argNum) match {
        case "--image" => {
          updateLoadArgument(ImageFromPathArgument(args(argNum + 1)))
          argNum += 1
        }
        case "--image-random" => {
          updateLoadArgument(RandomImageArgument())
        }
        case "--invert" => addFilterArgument(InversionFilterArgument())
        case "--flip" => {
          addFilterArgument(FlipFilterArgument(args(argNum + 1)))
          argNum += 1
        }
        case "--brightness" => {
          addFilterArgument(BrightnessFilterArgument(args(argNum + 1)))
          argNum += 1
        }
        case "--table" => ???
        case "custom-table" => ???
        case "output-console" => ???
        case "output-file" => ???
      }
      argNum += 1
    }
  }
}
