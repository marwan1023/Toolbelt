

object Adding extends App {

    val checksum = new CheckSum

    checksum.add(0)
    checksum.add(10)
    checksum.add(20)
    println(checksum.getSum())

    val rational = new Rational(checksum.getSum(), 2)
    println(rational.product())


}
