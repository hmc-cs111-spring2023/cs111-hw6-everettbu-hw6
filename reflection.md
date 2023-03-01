# Reflection on implementing regular expressions of a DSL

## Which operators were easiest to implement and why?
Implementing regular expressions using a DSL involves defining a set of operators that can be used to construct regular language expressions in a more natural and intuitive way. In this implementation, the easiest operators to implement were the basic operators such as concatenation, union and the Kleene star, which have well-defined and widely accepted semantics. These operators are also relatively straightforward to implement using pattern matching, recursion and other standard programming techniques.

## Which operators were most difficult to implement and why?
On the other hand, the most difficult operators to implement were the apply method and the <+> operator. The apply method is used to construct a regular language expression that consists of n repetitions of a given language. This requires recursion and careful handling of the base cases, as well as the use of concatenation to construct the final expression. The <+> operator, which constructs a regular language expression that consists of one or more repetitions of a given language, is also difficult to implement, since it involves constructing a regular expression that matches at least one occurrence of the language followed by any number of additional occurrences.

## Comment on the design of this internal DSL
Overall, the design of this internal DSL is relatively simple and easy to use, with a small set of operators that cover the most common operations used in regular expressions. The operators are defined as methods and extension methods, which makes them easy to use and read, and also makes the code more concise. The use of pattern matching and recursion also makes the code easier to understand and reason about.

## Write a few brief paragraphs that discuss:

- What works about this design? (For example, what things seem easy and
  natural to say, using the DSL?)
- What doesn't work about this design? (For example, what things seem
  cumbersome to say?)
- Think of a syntactic change that might make the language better. How would
  you implement it _or_ what features of Scala would prevent you from
  implementing it? (You don't have to write code for this part. You could say
  "I would use extension to..." or "Scala's rules for valid
  identifiers prevent...")

However, one limitation of this design is that it is not particularly expressive or flexible, and may not be suitable for more complex regular expressions. For example, it does not support backreferences, lookahead or lookbehind, which are commonly used in regular expressions to match more complex patterns.

To improve the language, a possible syntactic change could be to introduce a more flexible and expressive way of specifying regular expressions, perhaps using a combination of a DSL and a parser. This could involve allowing users to define their own operators, using regular expressions or other patterns as input, and allowing for more complex constructions such as backreferences, lookbehind and lookahead. The implementation of such a change would require a more advanced understanding of the Scala language and its features, as well as a more in-depth knowledge of regular expressions and their syntax.
