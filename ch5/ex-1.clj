(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(def sample-var :name)
(sample-var character)

(defn attr [keyword]
  (fn [m]
    (get (get m :attributes) keyword)))

(defn attr1 [keyword]
  (fn [m]
    (-> (:attributes m)
        (keyword))))

(def c-int (comp :intelligence :attributes))
(def my-c-int (attr :strength))
(def my-c-int1 (attr1 :dexterity))


(c-int character)
(my-c-int character)
(my-c-int1 character)
