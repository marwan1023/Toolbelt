object MatchExample extends App {

  val fighting = new FightingGame
  val game = "Street Fighte"

  if (game == null)
    println("Game shouldn't be fucking empty")

  game match {
    case "Street Fighter"  => println("Yep")
    case _ => println(fighting.stateFact)
  }



}
