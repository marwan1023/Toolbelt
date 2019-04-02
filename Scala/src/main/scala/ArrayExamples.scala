object ArrayExamples {

  def main(args: Array[String]): Unit = {
    val testString = new Array[String](3)

    testString(0) = "This "
    testString(1) = "is "
    testString(2) = "a test."


    testString.update(2, "a working test")


    for (i <- 0 to 2)
      print(testString(i))


  }

}
