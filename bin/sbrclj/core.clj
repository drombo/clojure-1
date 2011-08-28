(ns sbrclj.core
  (:gen-class))

(use 'clojure.contrib.combinatorics)
 
(defn check [vector] (= vector [0 2 1]))

(defn -main [& args]
  (println "Hello world!")
  
  (def perms (map check (permutations (take 3 (iterate inc 0)))))
  
  
  )