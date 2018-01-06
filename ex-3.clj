(defn dec-maker [n]
  (fn [num] (- num n)))

(def dec9 (dec-maker 9))
(dec9 10)
