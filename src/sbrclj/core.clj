;; REITEN + TENNIS = URLAUB

(ns sbrclj.core
  (:gen-class))

(use 'clojure.contrib.combinatorics)

(def letters [:R :E :I :T :N :S :U :L :A :B])

(defn reiten [lnmap]
  (+ (* 100000 (get lnmap :R))
     (* 10000  (get lnmap :E))
     (* 1000   (get lnmap :I))
     (* 100    (get lnmap :T))
     (* 10     (get lnmap :E))
               (get lnmap :N)))

(defn tennis [lnmap]
  (+ (* 100000 (get lnmap :T))
     (* 10000  (get lnmap :E))
     (* 1000   (get lnmap :N))
     (* 100    (get lnmap :N))
     (* 10     (get lnmap :I))
               (get lnmap :S)))

(defn urlaub [lnmap]
  (+ (* 100000 (get lnmap :U))
     (* 10000  (get lnmap :R))
     (* 1000   (get lnmap :L))
     (* 100    (get lnmap :A))
     (* 10     (get lnmap :U))
               (get lnmap :B)))

(defn check [numbers]

  (def lnmap (apply hash-map (interleave letters (vec numbers))))

  (def result (and (= (urlaub lnmap) (+ (tennis lnmap) (reiten lnmap)))
                (not= (get lnmap :R) 0)
                (not= (get lnmap :T) 0)
                (not= (get lnmap :U) 0)))


  (if result (lnmap))

  )

(defn print-result [printval]
  (println-str "REITEN " (reiten printval))
  (println-str "TENNIS " (tennis printval))
  (println-str "URALUB " (urlaub printval))
  (println-str "---------------"))

(defn -main [& args]
  (println "Hello world!")

  (def vnum (range 0 10))

; Klappt erstmal
; (println (map check (permutations vnum)))


;  (println (filter check (permutations vnum)))

;; weitere Tests
;(println (filter true? (pmap check (permutations vnum))))


   (pmap check (permutations vnum))

  )


;;;;;;;;;;;;;
(-main)
