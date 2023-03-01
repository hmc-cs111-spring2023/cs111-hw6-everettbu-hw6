package machines

import regex._
import dfa._

// Part 1:
given Conversion[Char, RegularLanguage] = Character(_)


// Part 2:
given Conversion[String, RegularLanguage] = (s: String) => {
  val chars = s.map(Character(_))
  chars.reduce((a, b) => Concat(a, b))
}

// Part 3:
extension (lang1: RegularLanguage)
  def ||(lang2: RegularLanguage): RegularLanguage = Union(lang1, lang2)

  def ~(lang2: RegularLanguage): RegularLanguage = Concat(lang1, lang2)

  def <*> : RegularLanguage = Star(lang1)

  def <+> : RegularLanguage = Concat(lang1, Star(lang1))

  def apply(n: Int): RegularLanguage = n match {
    case 0 => Empty
    case 1 => lang1
    case _ => Concat(lang1, lang1(n - 1))
  }
  
  def toDFA(using letters: Set[Char]) = regexToDFA(lang1, letters)


// Part 4:
given Conversion[RegularLanguage, DFA] = lang => lang.toDFA(using characters(lang))

def characters(lang: RegularLanguage): Set[Char] =
    lang match
        case Empty => Set()
        case Epsilon => Set()
        case Character(c) => Set(c)
        case Union(lang1, lang2) => characters(lang1) ++ characters(lang2)
        case Concat(lang1, lang2) => characters(lang1) ++ characters(lang2)
        case Star(lang1) => characters(lang1)

