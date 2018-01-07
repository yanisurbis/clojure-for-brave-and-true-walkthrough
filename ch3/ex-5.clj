(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "one-eye" :size 1}])

(defn red-f 
  [part replace-with]
  {:name (clojure.string/replace (:name part) #"^left-" replace-with)
   :size (:size part)})

(defn matching-parts
  [part]
  (let
    [replace (fn
               [replace-with]
               {:name (clojure.string/replace (:name part) #"^one-" replace-with)
                :size (:size part)})
     other-parts (reduce
                   #(do
                      (print %1 %2)
                      (conj %1 (replace (str %2 "-"))))
                   #{}
                   (nnext (range 5)))]
    (conj other-parts part)))
    
  
    

(matching-parts (get asym-hobbit-body-parts 1))

(defn symmetrize-body-parts
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (matching-parts part)))
    []
    asym-body-parts))

(symmetrize-body-parts asym-hobbit-body-parts)

                  


