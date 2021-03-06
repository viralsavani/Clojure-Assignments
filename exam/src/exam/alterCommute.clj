(ns exam.alterCommute)

(def counter (ref 0))
(def t1 (Thread. (fn[] (dosync (println "t1" @counter) (Thread/sleep 500)(alter counter inc)
                         (println "t1 done: " @counter)))))
(.start t1)
(dosync 
  (println "main start" @counter)
  (alter counter dec)
  (Thread/sleep 1000) 
  (alter counter dec)
  (println "main end" @counter)
  ) 
(println "out-of-trans" @counter)

(def counter1 (ref 0))
(def t2 (Thread. (fn[] (dosync (println "t2" @counter1) (Thread/sleep 500)(alter counter1 inc) 
                         (println "t2 done: " @counter1)))))
(.start t2)
(dosync 
  (println "main start" @counter1)
  (commute counter1 dec)
  (println "main before sleep" @counter1) ; 
  (Thread/sleep 1000) 
  (println "main mid" @counter1)
  (commute counter1 dec)
  (println "main end" @counter1)
  )                       
(println "counter: " @counter " counter1: " @counter1)

(def v1 (ref []))
(def t3 (Thread. (fn[] 
                   (dosync (println "t3" @v1)(Thread/sleep 500)(alter v1 conj 5)(println "t3 done" @v1)))))
(.start t3)
(dosync 
  (println "main start" @v1)
  (alter v1 conj 6)
  (println "main mid" @v1)
  (Thread/sleep 1000) 
  (alter v1 conj 7)
  (println "main end" @v1)
  ) 
(def v2 (ref []))
(def t4 (Thread. (fn[] 
                   (dosync (println "t4" @v2)(Thread/sleep 500)(alter v2 conj 5) (println "t4 done" @v2)))))
(.start t4)
(dosync 
  (println "main start" @v2)
  (commute v2 conj 6)
  (println "main mid" @v2) 
  (Thread/sleep 1000) 
  (commute v2 conj 7)
  (println "main end" @v2)
  ) 
(.join t3)
(.join t4)
(println "v1: " @v1 " v2: " @v2)