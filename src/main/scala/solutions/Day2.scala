package solutions

import scala.io.Source

object Day2 extends Solve {
  private def getInput(filename: String): List[(String, Int)] = {
    val filestream = Source.fromFile(filename)

    try filestream.getLines().toList.filter(_ != "")
      .map(_.split(" "))
      .map(x => (x(0), x(1).toInt))
    finally filestream.close()
  }

  def part1(data: List[(String, Int)]): Int = 0

  def part2(data: List[(String, Int)]): Int = 0

  override def solve(sample_name: String, input_name: String): Unit = {
    val data_sample: List[(String, Int)] = getInput(sample_name);
    val data_input: List[(String, Int)] = getInput(input_name);

    data_sample foreach println

    println("sample 1: " + part1(data_sample))
//    println("Part 1: "   + part1(data_input))
//    println("sample 2: " + part2(data_sample))
//    println("Part 2: "   + part2(data_input))
  }
}

