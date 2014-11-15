(ns assign3.core)

(defn nextRow
 [rule firstRow]
  (loop[rotate 0 nextLineFinal 0]
    (if (< rotate 32)
         (if (bit-test rule (bit-and (bit-shift-right (bit-shift-left firstRow 1) rotate) 7))                  
            (do (recur (inc rotate) (bit-set  nextLineFinal (inc rotate))))
            (do (recur (inc rotate) nextLineFinal)))
         (bit-shift-right nextLineFinal 1))))

(defn function2 
  [x]
  (let [x (java.lang.Integer/toBinaryString x)]
    (doseq  [x (apply str(cons (apply str (repeat (- 31 (count x)) 0)) x))]
      (print (clojure.string/replace  x "0" " "))
    )
    (println)))

(defn function3
  [rule firstRow totalRow]
  (dorun (map (fn [next](function2 next)) (take totalRow (iterate (fn [b] (nextRow rule b)) firstRow)))))

