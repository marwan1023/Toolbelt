import java.io.{FileNotFoundException, FileReader}

object ExceptionExample extends App {

  try {

    val f = new FileReader("hello.txt")
    f.close()

  } catch {
    case ex: FileNotFoundException => println("File not here...")
  }

}
