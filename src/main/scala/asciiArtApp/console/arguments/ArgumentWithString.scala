package asciiArtApp.console.arguments

/**
 * Some arguments expect to be followed by a specifying string. This class makes sure that that string is not
 * another argument, therefore that a string was provided
 * @param str the specifying string
 */
abstract class ArgumentWithString(val str: String) {
  if(str.startsWith("--")) throw new IllegalArgumentException("no argument for option provided")
}
