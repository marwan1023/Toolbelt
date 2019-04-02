import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object FutureExample extends App {

  //val ec =  scala.concurrent.ExecutionContext.Implicits.global

//  val inverseFuture: Future[Int] = Future {
//    Thread.sleep(10000)
//    100 + 100
//  } yield result(ec)

  // 2 - create a Future
  val f: Future[Int] = Future {
    //Thread.sleep(10000)
    100 + 100
  }


  val result = f.map(x => x + 50)
  println("before onComplete")
  f.onComplete {
    case Success(value) => println(s"Got the callback")
    case Failure(e) => println("Failure")
  }

//  f foreach {
//    msg => println(msg)
//  }

  println(result)



//  val s = "Hello"
//  val f: Future[String] = Future {
//
//    s + " future!"
//  }
//  f foreach {
//    msg => println(msg)
//  }



}
