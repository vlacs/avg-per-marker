(ns avg-per-marker.core
  (:gen-class))

(defn avg-marker [elapsed-times]
  (let [cnt (count elapsed-times)
        total (reduce + elapsed-times)
        avg (/ (double total) cnt)]
    {:count cnt :total-elapsed-time total :average-elapsed-time avg}))

(defn prn-avg-marker [marker ets]
  (println marker (avg-marker ets)))

(defn tokens-in []
  (try
    (clojure.string/split (read-line) #"\s+")
    (catch java.lang.NullPointerException e
      (System/exit 0))))

(defn collect-marker
  ([]
     (collect-marker (tokens-in)))
  ([[et marker]]
     (loop [markers-done [] marker marker ets [(Float/parseFloat et)]]
       (let [[et new-marker] (tokens-in)]
         (if (and (not= new-marker marker)
                  (not (some #{new-marker} markers-done)))
           (do
             (Thread. (prn-avg-marker marker ets))
             (recur (conj markers-done marker) new-marker [(Float/parseFloat et)]))
           (recur markers-done marker (conj ets (Float/parseFloat et))))))))

(defn -main
  [& args]
  (collect-marker))
