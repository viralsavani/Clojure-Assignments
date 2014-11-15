# assign3

One-dimensional Cellular Automata

http://mathworld.wolfram.com/ElementaryCellularAutomaton.html
shows the 256 one-dimensional cellular automata. Each generation follows 
from the preceding by applying one of the 256 rule sets. The diagrams here use 
black and white squares which is an option using a Java GUI. A simpler 
approach would use character output with 1 for black and blank for white. 
The displays use a 31 x 16  rectangle. The first generation starts with a 
single black square in the middle, at the top. Test with rules 30, 90, and 220.

Use bit operations, such as bit-shift-left, bit-shift-right, bit-test, 
bit-and, and bit-set to do this assignment. Remember that a cell value in the 
next generation is determined by the value of the cells to the left, above, 
and to the right in the current generation so a 31 bit row will produce 29 bits in the next generation. Shifting one bit to the left will augment to produce a 31-bit next generation.

Each generation can be represented by an integer. For example the original 
generation with one colored square in the middle is 32768. The rules are 
obtained from the binary representaion of their numbers. For example, rule 30 
is based on the binary representation 30=00011110. Each group of thee cells 
represents a binary number from 0 to 7. For example "11 " represents 6. If bit 
6 in the binary representation for 30 is 1 then the next generation square 
under those three will be black, otherwise (as in the case of rule 30) it will 
be white.

Use three functions. The first inputs a rule and a current row and outputs the next row. The second inputs a row and displays it. The third uses the first two to output the display.

Use a loop for the first function. The local variables are the current row, the next row and the bit position. Initialize the next row to 2r0, which is binary 0, in order to be able to set its bits. Using bit-and with 7 will get the lowest three bits of the current row which will be between 0 and 7. Test this bit number in the rule. If it is set, then recur with the row shifted right by one bit to get to the next bit position to test. Set the bit position in the next row. Increment the bit position. If the rule bit being tested is not set, then recur with the row shifted right one bit, the next row unchanged and the bit position incremented.

In the second function use doseq to allow the printing of the output for each of the 31 bits. Test each bit to see if the output should be 1 or blank. Use a println after the 31 bits have been displayed.

Using the iterate function with the first function will produce a sequence of successive rows. The take function will take the first n of them. Using the map function to apply the second function to each element of this finite sequence  will produce the output but also return a sequence of nil function values. Using the dorun function will apply the map without producing the nil values.
