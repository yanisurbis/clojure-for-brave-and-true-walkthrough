(ns fwpd.core)
(def filename "/media/yanis/Work/clojure-for-brave-and-true-walkthrough/ch4/fwpd/suspects.csv")

(slurp filename)

(def vamp-keys [:name :glitter-index])
(defn str->int
  [str]
  (Integer. str))
(def conversions {:name identity
                  :glitter-index str->int})
(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))
(convert :glitter-index "3")

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))
(parse (slurp filename))
(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))
(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))
(glitter-filter 3 (mapify (parse (slurp filename))))


; ex1
(->> (slurp filename)
     (parse)
     (mapify)
     (glitter-filter 3)
     (map :name))

; ex2 - 1
(defn append [suspect]
  (let [suspect-str (str (:name suspect) "," (:glitter-index suspect))
        other-suspects-str (slurp filename)]
    (->> (str other-suspects-str "\n" suspect-str)
         (spit filename))))

(comment (append {:name "Yanis Urbis"
                  :glitter-index "101"}))

(comment (append {:name "Ksusha Zhukova"
                  :glitter-index "102"}))

; ex2 - 2
(def records (->> (slurp filename)
                  (parse)
                  (mapify)))

(defn append2 [suspect]
  (concat records [suspect]))

(def new-records 
  (append2 {:name "Denis"}))

; ex3

(def validations {:name identity
                  :glitter-index identity})

(defn validate
  [validations records]
  (= 0 (count (drop-while
                (fn [elm]
                  (do 
                    (= (count validations) (->> (keys validations)
                                                (map elm)
                                                (filter identity)
                                                count))))                                
                records))))

(validate validations new-records)
(validate validations records)

; ex4
(defn suspects->csv
  [suspects]
  (->> (map #(str (:name %) "," (:glitter-index %)) suspects)
       (clojure.string/join "\n")))

(suspects->csv new-records)


     



