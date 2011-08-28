;; REITEN + TENNIS = URLAUB

(ns sbrclj.core
  (:gen-class))

(use 'clojure.contrib.combinatorics)

(def letters [:R :E :I :T :N :S :U :L :A :B])

(defn reiten [lnmap]
  (+ (* 100000 (get lnmap :R))
    (* 10000 (get lnmap :E))
    (* 1000 (get lnmap :I))
    (* 100 (get lnmap :T))
    (* 10 (get lnmap :E))
    (get lnmap :N)))

(defn tennis [lnmap]
  (+ (* 100000 (get lnmap :T))
    (* 10000 (get lnmap :E))
    (* 1000 (get lnmap :N))
    (* 100 (get lnmap :N))
    (* 10 (get lnmap :I))
    (get lnmap :S)))

(defn urlaub [lnmap]
  (+ (* 100000 (get lnmap :U))
    (* 10000 (get lnmap :R))
    (* 1000 (get lnmap :L))
    (* 100 (get lnmap :A))
    (* 10 (get lnmap :U))
    (get lnmap :B)))

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
;(-main)
