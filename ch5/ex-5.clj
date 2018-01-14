; Look up and use the update-in function
(defn my-update-in
  [m ks f & args]
  (case (count ks)
    1
    (apply
      update
      (concat [m (first ks) f] args))
    (apply
      my-update-in
      (concat
        [(get m (first ks))
         (rest ks)
         f]
        args))))

(def users [{:name "James" :age 26} {:name "John" :age 43}])
(update-in users [1 :age] inc)
(my-update-in users [1 :age] inc)


