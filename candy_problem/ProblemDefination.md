# candy_problem

Candy Distribution

Three students sit in a circle while their teacher gives them candy. Each 
student initially has an even number of pieces of candy. When the teacher 
blows a whistle, each student simultaneously gives half of his or her own candy 
to the neighbor on the right.  Any student who ends up with an odd number of 
pieces of candy gets one more piece from the teacher.

Write a Clojure program that includes four functions.
1. Two parameters, the adjacent amounts of candy. Return the adjusted 
amount of candy.

2. One parameter, a vector of the three candy amounts and the number of 
turns. Declare the parameter in destructured form as [r s t u] so you can 
use the elements. Returns a vector of the adjusted candy amounts and the 
incremented number of turns.


3. One parameter, a vector of the three candy amounts and the number of 
turns. Returns the sequence of candy values and turn numbers including the 
last vector in which the candy values are equal. Use the loop-recur form 
of recursion with two parameters, the first, current, initially set to the 
parameter passed to the function, and the second, result, initialized to 
an empty vector to accumulate the result. If the first three elements of 
current (the candy amounts) are equal, then return return the vector 
obtained using 'conj' to add current to result. Otherwise recur with the 
the new value of current obtained from function 2, and the new value of 
result obtained by using conj to add current to result. To get the ith 
element of a vector v one can use (v i). 

4. A test function that used the read function to input from the keyboard and calls function 3. Test using different inputs including some larger numbers.
