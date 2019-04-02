import scala.collection.immutable.HashSet
import scala.collection.mutable

object TupleExamples {

  def main(args: Array[String]): Unit = {
    val pair = (200, "Balloons")

    println(pair._1)
    println(pair._2)

    val movieSet = mutable.Set("Hitch", "Resident Evil")
    movieSet += "Aliens"
    println(movieSet)

    val veggieSet = HashSet("Tomatoes", "Green Beans")
    println(veggieSet + "Spinach")
  }

}
