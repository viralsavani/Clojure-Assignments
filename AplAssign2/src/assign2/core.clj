(ns assign2.core)

(defn function1  [x]
  (split-with #(= % (first x)) x)
)

(defn function2  [x]
  (let [restSeq x]
  (loop [result [] restSeq restSeq]
    (let [[firstSeq restSeq] (function1 restSeq)]
      (if (= (first restSeq) (last restSeq))
       (conj result firstSeq restSeq)
       (recur (conj result firstSeq) (vec restSeq))
)))))

(defn function3  [x]
  (sort (lazy-seq (zipmap (map #(first %) (function2 x)) (map #(count %) (function2 x)))))
)



(function3 [:a :a])
