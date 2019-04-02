object ClosureExample extends App {

  var numbers = List(1,2,3,4,5)

  var sum = 0
  numbers.foreach(sum += _)

  println(sum)


}
