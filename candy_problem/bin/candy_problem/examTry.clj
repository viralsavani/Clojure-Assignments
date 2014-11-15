(ns candy-problem.examTry)

(defn stackFibo
  [x]
  
  (cond 
    (= 0 x) 0
    (= 1 x) 1
    :else(+ (stackFibo (- x 1)) (stackFibo (- x 2)))
    )
)

(defn tailRecureFibo
  [n]
  (letfn[(fib
           [current next n]
           (if (zero? n)
             current
             (recur next (+ current next) (dec n))))]
    (fib 0 1 n))  
)

(declare m f)
(defn m [n]
(if (zero? n)
0
(- n (f (m (dec n))))))
(defn f [n]
(if (zero? n)
1
(- n (m (f (dec n))))))