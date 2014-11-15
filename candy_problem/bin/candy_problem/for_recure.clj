(ns candy-problem.for_recure)

(defn halfAccept [])
(defn candyHalf [])
(defn candyRead
  "This funciton reads input from user. And calls candyHalf"
  []
  (def candyInitial [(read) (read) (read)])
  (candyHalf candyInitial)
)

(defn candyHalf
  [candyInitial]
  (def xi candyInitial)
  (loop [result candyInitial i 1] 
   (let [[c1 c2 c3] xi]
		  (def c11 (/ c1 2))
		  (def c22 (/ c2 2))
		  (def c33 (/ c3 2))
		  (def halfVector (vec (concat [c11] [c22] [c33])))		  
		  (def shiftVector (vec (concat [c33] [c11] [c22]))) 
		  (def addedVector (vec (map + halfVector shiftVector)))
		  (let [[x y z] addedVector]
			  (if (odd? x) (def xx (+ 1 x)) (def xx x))
			  (if (odd? y) (def yy (+ 1 y)) (def yy y))
			  (if (odd? z) (def zz (+ 1 z)) (def zz z))
        (def xi (vec (concat [xx] [yy] [zz])))
			  (if (= xx yy zz)
	        (do
		        (conj result [xx yy zz i])
	        )
	 				(do
	              (recur (conj result [xx yy zz i]) (inc i))
		      ) 
         ) 
			 )
		) 
	) 
 )
