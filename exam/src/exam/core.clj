(ns exam.core)

;Simple example for finals preparation

(defmacro unless [expr form]
  (list 'if expr nil form))

;For chain execution
(defmacro chain
  ([x form] (list '. x form))
  ([x form & more] (concat (list 'chain (list '. x form)) more)))

;Simple AND macro: stops at first nil or false
(and (+ 1 2) (inc 12) (first [12 2 3]) (- 1 1) false (+ 10 11))

;Simple OR macro: stops at first true
(or nil false (inc 12))              ; Exececutes unitll it finds first true or some function returning value.