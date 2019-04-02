import scala.io.Source

object FileRead {

  def main(args: Array[String]): Unit = {
    if (args.length > 0) {

      val lines = Source.fromFile(args(0)).getLines().toList

      var maxWidth = 0
      for (line <- lines) {
        maxWidth = maxWidth.max(widthOfLength(line))
        println(line.length + " " + line)
      }

    }
    else {
      Console.err.println("Enter filename")
    }
  }

  def widthOfLength(s:String) = s.length.toString.length

}
