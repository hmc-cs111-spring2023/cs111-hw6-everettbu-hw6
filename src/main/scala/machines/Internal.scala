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

extension (lang1: RegularLanguage) {
  def ||(lang2: RegularLanguage): RegularLanguage = Union(lang1, lang2)

  def ~(lang2: RegularLanguage): RegularLanguage = Concat(lang1, lang2)

  def <*> : RegularLanguage = Star(lang1)

  def <+> : RegularLanguage = Concat(lang1, Star(lang1))

  def apply(n: Int): RegularLanguage = n match {
    case 0 => Empty
    case 1 => lang1
    case _ => Concat(lang1, lang1(n - 1))
  }
  
}

