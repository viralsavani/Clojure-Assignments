(ns assign4.core)

(defn levenshtein [str1 str2]
  (let [len1 (count str1)
        len2 (count str2)]
    (cond (zero? len1) len2
          (zero? len2) len1
          :else
          (let [cost (if (= (first str1) (first str2)) 0 1)]
            ;(println str1 str2)
            (min (inc (levenshtein (rest str1) str2))
                 (inc (levenshtein str1 (rest str2)))
                 (+ cost
                    (levenshtein (rest str1) (rest str2))))))))

(def lev-memo (memoize levenshtein))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def levMemo-memo (memoize levenshteinMemo))

(defn levenshteinMemo [str1 str2]
  (let [len1 (count str1)
        len2 (count str2)]
    (cond (zero? len1) len2
          (zero? len2) len1
          :else
          (let [cost (if (= (first str1) (first str2)) 0 1)]
            ;(println str1 str2)
            (min (inc (levMemo-memo (rest str1) str2))
                 (inc (levMemo-memo str1 (rest str2)))
                 (+ cost
                    (levMemo-memo (rest str1) (rest str2))))))))

(def levMemo-memo (memoize levenshteinMemo))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


















(defn edit-distance
  "Return the Levenshtein edit distance between two strings"
  [first second]
  (cond
   (empty? first) (count second)
   (empty? second) (count first)
   :else (min (+ 1 (edit-distance (drop 1 first) second))
              (+ 1 (edit-distance first (drop 1 second)))
              (+ (cond
                  (= (take 1 first) (take 1 second)) 0
                  :else 1)
                 (edit-distance (drop 1 first) (drop 1 second))))))










(declare levenshtein-distance-fast levenshtein-distance-int)
(defn cost [a b]
  (if (= a b) 0 1))

(defn levenshtein-distance 
  "Calculates the edit-distance between two sequences"
  [seq1 seq2]
  (cond
    (empty? seq1) (count seq2)
    (empty? seq2) (count seq1)
    :else (min
           (+ (cost (first seq1) (first seq2)) (levenshtein-distance (rest seq1) (rest seq2))) ;; substitution
           (inc (levenshtein-distance (rest seq1) seq2))    ;; insertion
           (inc (levenshtein-distance seq1 (rest seq2)))))) ;; deletion

(defn levenshtein-distance-int
  "Calculates the edit-distance between two sequences"
  [seq1 seq2]
  (cond
    (empty? seq1) (count seq2)
    (empty? seq2) (count seq1)
    :else (min
            (println seq1    seq2)
           (+ (cost (first seq1) (first seq2)) (levenshtein-distance-fast (rest seq1) (rest seq2))) ;; substitution
           (inc (levenshtein-distance-fast (rest seq1) seq2))    ;; insertion
           (inc (levenshtein-distance-fast seq1 (rest seq2)))))) ;; deletion

(def levenshtein-distance-fast (memoize levenshtein-distance))