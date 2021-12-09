#!/usr/bin/env bash

if [ -z "$1" ]; then
	echo -e "Day number required!\nUsage: ./new_day.sh <day-number> [type-of-input-elements]"
	exit 1
fi

if [ -z "$2" ]; then
	input_type="Any"
else
	input_type="$2"
fi

touch "sample/sample-$1.txt"
echo "sample/sample-$1.txt"

touch "input/input-$1.txt"
echo "input/input-$1.txt"

echo -e "package solutions\n\n"\
\
"import scala.io.Source\n\n"\
\
"object Day$1 extends Solve {\n"\
"  private def getInput(filename: String): List[$input_type] = {\n"\
"    val filestream = Source.fromFile(filename)\n\n"\
\
"    try filestream.getLines().toList.filter(_ != \"\")\n"\
"    finally filestream.close()\n"\
"  }\n\n"\
\
"  def part1(data: List[$input_type]): Int = 0\n\n"\
\
"  def part2(data: List[$input_type]): Int = 0\n\n"\
\
"  override def solve(sample_name: String, input_name: String): Unit = {\n"\
"    val data_sample: List[$input_type] = getInput(sample_name);\n"\
"    val data_input: List[$input_type] = getInput(input_name);\n\n"\
\
"    println(\"Sample 1: \" + part1(data_sample))\n"\
"    println(\"Part 1:   \" + part1(data_input))\n"\
"    println(\"Sample 2: \" + part2(data_sample))\n"\
"    println(\"Part 2:   \" + part2(data_input))\n"\
"  }\n"\
"}"\
> "solutions/Day$1.scala"
echo "solutions/Day$1.scala"

