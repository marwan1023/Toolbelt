import scala.collection.mutable

object MapExamples {

  def main(args: Array[String]): Unit = {
    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to Island")
    treasureMap += (2 -> "Find Tatoo")

    println(treasureMap(2))
  }


}
