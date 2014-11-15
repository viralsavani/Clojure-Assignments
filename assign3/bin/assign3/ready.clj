(ns assign3.ready)

(defn int->bdigits
  "Gets the binary digits that comprise an integer as a seq of ints."
  [number]
  (for [c (Integer/toBinaryString number)] (Integer/valueOf (str c))))

(defn zero-pad
  "Forward pads a seq with 0s to match a given length. Used for making sure int->bdigits hits byte boundaries"
  [x len]
  (let [shortage (- len (count x))]
    (if (< shortage 1)
      x
      (concat (repeat shortage 0) x))))

(def input-patterns
  "The list of possible input sequences for elementary cellular automata, which are easily generated
   by counting down from 8 in binary, and making sure we have at least three digits.
   This should produce a list like: ((111 110 ...))"
  (map #(zero-pad (int->bdigits %1) 3) (range 8)))

(defn rule-mappings
  "Returns a mapping of patterns to new states. Returns a structure like:
   {(0 1 1) 1
    ...}"
  [number]
  ;; Zipmap combines two sequences into a map, much like a real-life zipper!
  ;; The key here is that the magic rule numbers are not numbers at all
  ;; but a sequence rather (their individual binary digits) that get mapped
  ;; onto the list of possible inputs described in input-patterns.
  ;; The heart of the generic solution here is really just checking
  ;; equality of a sequence, which we can do via a lookup in the hashmap
  ;; this generates
  (zipmap input-patterns
          (reverse (zero-pad (int->bdigits number) 8))))

(defn rule
  "Returns a function that will process a triad of input values according to a given rule #.
   Since rules are simple lookup tables, this maps to nothing more than a get really.
   We use a function here only to be able to close over the rule-mappings and only evaluate those once."
  [number]
  ;; Applying a rule is really simple, since we've reduced the problem to pattern matching, and
  ;; clojrue can match lists well (e.g. (= [1 2 3] [1 2 3]) => true even though they're separate
  ;; objects), can simply see which pattern the 3 given values match with a map lookup via get.
  (let [mappings (rule-mappings number)]
    (fn [triad] (get mappings triad))))

(defn bookend
  "Pads a seq with a given value on both sides."
  [x v]
  (concat [v] x [v]))

(defn simulate
  "Runs a single iteration of a given rule-fn on a given-state"
  [rule-fn state]
  (let [rule (rule-mappings 110)]
    ;; We bookend the value below to add a 0 on both sides of the previous state
    ;; as it makes calculations simpler
    (for [triad (partition 3 1 (bookend state 0))]
      (rule-fn triad))))