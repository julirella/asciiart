package console

import console.arguments.load.{ImageFromPathArgument, LoadArgument, RandomImageArgument}

class ArgumentParser(args: Array[String]) {
  private var loadArgument: Option[LoadArgument] = None
//  private val filterArguments:

  private def updateLoadArgument(arg: LoadArgument): Unit = {
    if(loadArgument.isEmpty) loadArgument = Option(arg)
    else throw new IllegalArgumentException("too many load arguments")
  }
  def parseArguments() = {
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
      }
      argNum += 1
    }
  }
}
