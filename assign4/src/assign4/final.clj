(ns assign4.final)


(defn noOfChanges
    [src dest]
  
  (cond
    (zero? (+ (count src) (count dest))) 0
    (zero? (count dest))  (count src)
    (zero? (count src)) (count dest)
    (= (first src) (first dest)) (noOfChanges (rest src) (rest dest))
    :else 
      (min  
        (+ 1 (noOfChanges (rest src) dest ))
        (+ 1 (noOfChanges src (rest dest) ))
        (+ 1 (noOfChanges (rest src) (rest dest))))))



(declare noOfChangesMemoized)
(defn noOfChangesMemo
    [src dest]
  
  (cond
    (zero? (+ (count src) (count dest))) 0
    (zero? (count dest))  (count src)
    (zero? (count src)) (count dest)
    (= (first src) (first dest)) (noOfChangesMemoized (rest src) (rest dest))
    :else 
      (min  
        (+ 1 (noOfChangesMemoized (rest src) dest ))
        (+ 1 (noOfChangesMemoized src (rest dest) ))
        (+ 1 (noOfChangesMemoized (rest src) (rest dest))))))

(def noOfChangesMemoized (memoize noOfChangesMemo))





(defn noOfChangesPrint
    [src dest level]
  
  (cond
    (zero? (+ (count src) (count dest))) (do (println (repeat (* level 2) \space) (apply str src) (apply str dest)) 0)
    (zero? (count dest)) (do (println (repeat (* level 2) \space) (apply str src) (apply str dest)) (count src))
    (zero? (count src)) (do (println (repeat  (* level 2) \space) (apply str src) (apply str dest)) (count dest))
    (= (first src) (first dest)) (do (println (repeat (* level 2) \space) (apply str src) (apply str dest)) (noOfChangesPrint (apply str (rest src)) (apply str (rest dest)) (inc level)))
    :else 
    (do
      (println (repeat (* level 2) \space) (apply str src) (apply str dest))
      (min  
        (+ 1 (noOfChangesPrint (rest src) dest (inc level)))
        (+ 1 (noOfChangesPrint src (rest dest) (inc level)))
        (+ 1 (noOfChangesPrint (rest src) (rest dest) (inc level)))))))


(declare noOfChangesPrintMemo)

(defn noOfChangesPrintTemp
    [src dest]
  
  (cond
    (zero? (+ (count src) (count dest))) (do (println (apply str src) (apply str dest)) 0)
    (zero? (count dest)) (do (println (apply str src) (apply str dest)) (count src))
    (zero? (count src)) (do (println (apply str src) (apply str dest)) (count dest))
    (= (first src) (first dest)) (do (println (apply str src) (apply str dest)) (noOfChangesPrintMemo (rest src) (rest dest)))
    :else 
    (do
      (println (apply str src) (apply str dest))
      (min (inc (noOfChangesPrintMemo (rest src) dest))
           (inc (noOfChangesPrintMemo src (rest dest)))
           (inc (noOfChangesPrintMemo (rest src) (rest dest)))))))

(def noOfChangesPrintMemo (memoize noOfChangesPrintTemp))