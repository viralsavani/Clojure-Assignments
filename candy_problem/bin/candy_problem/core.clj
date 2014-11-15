(ns candy-problem.core)

(defn halfAccept [])
(defn candyHalf [])
(defn candyRead
  "This funciton reads input from user. Creates the HalfVector and ShiftVector"
  []
  (def candyInitial [(read) (read) (read)])
  (println candyInitial)
  (candyHalf candyInitial)
  )
(defn candyHalf
  [x]
  (let [[c1 c2 c3] x]
  (def c11 (/ c1 2))
  (def c22 (/ c2 2))
  (def c33 (/ c3 2))
  
    (def halfVector (vec (concat [c11] [c22] [c33])))
  ;(println "HalfVector" halfVector)
  
  (def shiftVector (vec (concat [c33] [c11] [c22])))
  ;(println "ShiftVector" shiftVector)
  (halfAccept halfVector shiftVector)
    )
  )

(defn halfAccept
  [x y]
  (def addedVector (vec (map + x y)))
  ;(println "AddedVector" addedVector)
  
  (let [[x y z] addedVector]
  (if (odd? x) (def xx (+ 1 x)) (def xx x))
  (if (odd? y) (def yy (+ 1 y)) (def yy y))
  (if (odd? z) (def zz (+ 1 z)) (def zz z))
  
  (if (= xx yy zz)
    (println "Done " xx yy zz)
    (do
      (def adjustedVector(vec (concat [xx] [yy] [zz])))
      (println "AjustedVector" adjustedVector)
      (candyHalf adjustedVector)
      )
    )
  )
  )



