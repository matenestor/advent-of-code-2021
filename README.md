## Advent of Code 2021

Solutions of [Advent of Code 2021](https://adventofcode.com/2021) (descriptions are available on the website).

I am using this event to learn programming in Scala.
I want to solve as many days as possible in functional way without using mutability.

### Run

You can provide a number as an argument to specify problem to solve from different day.
Eg `scala Main 1` will solve problem from first day, `scala Main 7` will solve problem from seventh day and so on.
If no argument is provided, the solution for the newest day is executed.

> using sbt
 
```sbt
sbt compile
sbt run [day-number]
```

> using Scala compiler

```bash
scalac src/main/scala/**/*.scala
scala Main [day-number]
```
