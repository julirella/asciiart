package asciiArtApp.console

object Main extends App {
  private val argumentParser = new ArgumentParser(args)
  try{
    argumentParser.parseArguments()
  } catch {
    case e: IllegalArgumentException => println(e.toString)
  }
}