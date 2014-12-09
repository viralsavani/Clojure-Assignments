(ns assign5.core)

(defprotocol Change
  "A protocol with methods move, left and right."
  (move [this distance] "Uses a parameter to specify the distance to move")
  (left [this] "Move left")
  (right [this] "Move right"))

(defrecord Robot [xCoordinate yCoordinate direction]
  Change
  (move [this distance]
    (cond
      (= (:direction this) :e) (println(update-in  this [:xCoordinate] + distance))
      (= (:direction this) :w) (println(update-in  this [:xCoordinate] - distance))
      (= (:direction this) :n) (println(update-in  this [:yCoordinate] + distance))
      (= (:direction this) :s) (println(update-in  this [:yCoordinate] - distance))
      :else (println "Direction specified is not appropriate")))
  
  (left [this]
    (cond
      (= (:direction this) :e) (println(assoc  this :direction ":n"))
      (= (:direction this) :w) (println(assoc  this :direction ":s"))
      (= (:direction this) :n) (println(assoc  this :direction ":w"))
      (= (:direction this) :s) (println(assoc  this :direction ":e"))
      :else (println "Direction specified is not appropriate")))
  
  (right [this]
    (cond
      (= (:direction this) :e) (println(assoc  this :direction ":s"))
      (= (:direction this) :w) (println(assoc  this :direction ":n"))
      (= (:direction this) :n) (println(assoc  this :direction ":e"))
      (= (:direction this) :s) (println(assoc  this :direction ":w"))
      :else (println "Direction specified is not appropriate"))))

(extend-protocol Change
  String
  (move [this times]
    (last (take (+ times 1) (iterate (fn[newStr] (right newStr)) this)))
    )
  
  (left [this]
    (let [firstElement (str (first this))]
      (apply str (apply str (rest this)) firstElement)))
  
  (right [this]
    (let [lastElement (str (last this))]
      (str lastElement (apply str (butlast this))))))
