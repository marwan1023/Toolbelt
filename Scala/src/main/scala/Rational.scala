class Rational(n: Int, d: Int) {

  require(d != 0)
  val numer: Int = n
  val denom: Int = d
  var result = 0

  override def toString = numer + "/" + denom
  def add(that: Rational): Rational =

    new Rational(
      numer * that.denom + that.numer * denom, denom * that.denom
    )

  def product(): Int = {
    result = numer * denom
    return result
  }
  def getResult(): Int = {
      return result
  }
}
