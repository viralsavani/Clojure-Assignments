# assign2

Counting and combining

Write a Clojure program to count and combine sequences. For example 
let v = [:a :a :a :b :b :c :c :c]. 

Write a function that finds the first sequence, so given v it outputs [(:a :a :a) (:b :b :c :c :c :c)]. 

Write a second function that uses the first function to break up the sequence into contiguous parts. On input of v it outputs [(:a :a :a) (:b :b) (:c :c :c :c)]. 

Write a third function to count each sequence. It uses the map function on the result of the second function so that on input of v, for example, it outputs ([:a 3] [:b 2] [:c 4]).
