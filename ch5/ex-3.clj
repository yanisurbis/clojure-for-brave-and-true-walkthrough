; implement assoc-in function

(defn my-assoc-in 
  [m [k & ks] v]
  (case (count ks)
    0
    (assoc m k v)
    (assoc m k (my-assoc-in (get m k) ks v))))

(def numbers [1 2 {:a {:b 4}} 4 5])
(my-assoc-in numbers [2 :b :c :d] 4)
(assoc-in numbers [2 :b :c :d] 4)

(def users [{:name "James" :age 26}  {:name "John" :age 43}])
(assoc-in users [1 :age] 44)
(my-assoc-in users [1 :age] 44)


