# assign4
## Efficient Implementation of "Edit Distance" (Algorithm given by Prof. Arther Gittleman- http://www.csulb.edu/~artg/)
Write a Clojure program that returns the minimum number of changes -- insertions, deletions, or substitutions -- needed to change a given string into a second given string. For example, for "sin" to "bit" it's two, while from "abaseballgame" to "footballfame" it's six. 

The recursive algorithm is
If 
  both strings empty then 0
  one string empty then the size of the other
  first characters equal then the minimum number of changes to match the 
    rest of each 
  otherwise one plus the minimum of the number of changes from
    a. rest of first to second            (deletion)
    b. first to rest of second            (insertion)
    c. rest of first to rest of second    (substitution)

For ease of testing write two identical functions with different names and memoize the second one. You must use the same function name when you memoize because the recursive calls need to use the memoized version. Test with the two examples I gave, using the time function to compare times.

Make two more versions which trace the code, printing the two arguments each time the function is called. For the non-memoized version also include a third argument for the level and increment the level at each recursive call. Print twice the level of spaces before the argument output to show the level of nesting, making the output easier to read. Show the traced output for each of the two tests.

