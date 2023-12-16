package console.arguments

abstract class ArgumentWithString(val str: String) {
  if(str.startsWith("--")) throw new IllegalArgumentException("no argument for option provided")
}
