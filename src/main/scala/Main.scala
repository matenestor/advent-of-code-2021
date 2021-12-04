import solutions._

object Main {
  val DAY: Int = 1
  val SAMPLE_NAME: String = s"src/main/scala/sample/sample-${DAY}.txt"
  val INPUT_NAME:  String = s"src/main/scala/input/input-${DAY}.txt"

  def main(args: Array[String]): Unit = Day1.solve(SAMPLE_NAME, INPUT_NAME)
}
