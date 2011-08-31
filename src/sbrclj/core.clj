;; REITEN + TENNIS = URLAUB

(ns sbrclj.core
  (:gen-class))

(use 'clojure.contrib.combinatorics)

(def letters [:R :E :I :T :N :S :U :L :A :B])

(defn reiten [lnmap]
  (+
    (* (lnmap :R) 100000)
    (* (lnmap :E) 10000)
    (* (lnmap :I) 1000)
    (* (lnmap :T) 100)
    (* (lnmap :E) 10)
    (* (lnmap :N) 1)))

(defn tennis [lnmap]
  (+
    (* (lnmap :T) 100000)
    (* (lnmap :E) 10000)
    (* (lnmap :N) 1000)
    (* (lnmap :N) 100)
    (* (lnmap :I) 10)
    (* (lnmap :S) 1)))

(defn urlaub [lnmap]
  (+
    (* (lnmap :U) 100000)
    (* (lnmap :R) 10000)
    (* (lnmap :L) 1000)
    (* (lnmap :A) 100)
    (* (lnmap :U) 10)
    (* (lnmap :B) 1)))

(defn assign-numbers-to-letters [numbers]
  (apply hash-map (interleave letters (vec numbers))))

(defn check [the-map]
  (and (= (urlaub the-map) (+ (tennis the-map) (reiten the-map)))
    (not= (get the-map :R) 0)
    (not= (get the-map :T) 0)
    (not= (get the-map :U) 0)))

(defn print-result [printval]
  (println-str "REITEN " (reiten printval))
  (println-str "TENNIS " (tennis printval))
  (println-str "URALUB " (urlaub printval))
  (println-str "---------------"))

(defn get-result [numbers]

  (def lnmaps (pmap assign-numbers-to-letters numbers))

  (pmap check lnmaps)

  )


(defn -main [& args]
  (println "Hello world!")

  (def vnum (range 0 10))

  (println (get-result (permutations vnum)))

  )


;;;;;;;;;;;;;
(-main)

;;;;
