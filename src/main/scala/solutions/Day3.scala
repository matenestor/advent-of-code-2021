package solutions

import scala.io.Source

object Day3 extends Solve {
  private def getInput(filename: String): List[List[Int]] = {
    val filestream = Source.fromFile(filename)

    try filestream.getLines().toList.filter(_ != "")
      // transform parsed lines to lists with ints
      .map(
        _
          .split("")
          .map(_.toInt)
          .toList
      )
    finally filestream.close()
  }

  def part1(data: List[List[Int]]): Int = {
    val half: Int = data.length / 2

    val computed: List[String] = data
      // sum values on y axis
      .transpose
      .map(_.sum)
      // more common bit has over half occurrences in data
      // also possible like this:
      // .map(x => if (x < amount) ("0", "1") else ("1", "0"))
      // but default case to be sure
      .map {
        case x if x < half  => List("0", "1")
        case x if x > half  => List("1", "0")
        case x if x == half => List("unreachable", "unreachable")
      }
      // create strings from values on y axis
      .transpose
      .map(_.mkString)

    val gamma_rate: Int = Integer.parseInt(computed.head, 2)
    val epsilon_rate: Int = Integer.parseInt(computed.last, 2)

    gamma_rate * epsilon_rate
  }

  def part2(data: List[List[Int]]): Int = 0

  override def solve(sample_name: String, input_name: String): Unit = {
    val data_sample: List[List[Int]] = getInput(sample_name);
    val data_input: List[List[Int]] = getInput(input_name);

    println("Sample 1: " + part1(data_sample))
    println("Part 1:   " + part1(data_input))
//    println("Sample 2: " + part2(data_sample))
//    println("Part 2:   " + part2(data_input))
  }
}

