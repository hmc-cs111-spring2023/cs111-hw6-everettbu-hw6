package machines

import regex._
import dfa._
import machines.given

// Part 1:
given Conversion[Char, RegularLanguage] = Character(_)


// Part 2:
given Conversion[String, RegularLanguage] = (s: String) => {
  val chars = s.map(Character(_))
  chars.reduce((a, b) => Concat(a, b))
}


