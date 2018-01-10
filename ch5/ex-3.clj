; implement assoc-in function

; use assoc-in function
(def numbers [1 2 {:a {:b 4}} 4 5])
(def users [{:name "James" :age 26}  {:name "John" :age 43}])
(assoc-in users [1 :age] 44)
(assoc-in numbers [2] 4)

; use assoc function
(assoc {} :key1 "value" :key2 "another value")

(defn my-assoc-in 
  [m [k & ks] v]
  (case (count ks)
    0
    (assoc m k v)
    (assoc m k (my-assoc-in (get k m) ks v))))


(my-assoc-in numbers [1] 0)
(my-assoc-in numbers [2 :b] 4)

(assoc {:surname "urbis"} :name "yanis")
(assoc nil :a 4)

