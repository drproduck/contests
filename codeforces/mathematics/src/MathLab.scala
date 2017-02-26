/**
  * Created by drproduck on 2/21/17.
  */
object MathLab {
  println("Welcom to the Scala worksheet")
  def solve (a : Double, b : Double, c : Double): Option[(Double, Double)] ={
    val delta : Double = b*b - 4*a*c
    if (delta < 0) {
      None
    } else if (delta == 0) {
      Some(-b / (2 * a), -b / (2 * a))
    } else Some((-b + math.sqrt(delta)) / (2 * a), (-b - math.sqrt(delta)) / (2 * a))
  }

  def main(args: Array[String]): Unit = {
    println(solve(1, 0, 1))
    println(solve(1, 2, 1))
    println(solve(1, -5, 6))
    println(solve(1, 4, 2))
  }
}
