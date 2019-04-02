object ListExamples {

  def main(args: Array[String]): Unit = {

    //These are immutable
    val numbers = List(1,2,3)
    val letters = List("a", "b", "c")

    val numLetters = numbers ::: letters

    println(100 :: numLetters)



  }

}
