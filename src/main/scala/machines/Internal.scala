package machines

import regex._
import dfa._
import machines.given


implicit class RegularLanguage(c: Char) {
  def matches(s: String): Boolean = 
    c.toString == s
}
