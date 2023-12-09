package console

import console.arguments.load.LoadArgument

object Main extends App {
  def parseArguments() = {
    var argNum = 0
    while(argNum < args.length){
      args(argNum) match {
        case "--image" =>
      }
    }
  }
  for(arg <- args)
    println(arg)

  /*
  * argument parser parses arguments, checks correctness and creates argument objects
  * after parsing, the must be a certain amount of arguments of certain types
  * then the arguments are run
  * */
}