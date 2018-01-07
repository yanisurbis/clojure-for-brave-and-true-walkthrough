(defn mapset [f v]
  (-> (map f v) set))

(mapset inc [1 1 2 2])
