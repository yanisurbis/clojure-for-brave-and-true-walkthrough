; Write a function that takes a number and adds 100 to it.

(defn add-100 [n]
  (+ n 100))

(add-100 10)
(add-100 0)
(add-100 -10)

(apply #(+ % 100) [1])
(apply (fn [n] (+ n 100)) [1])
