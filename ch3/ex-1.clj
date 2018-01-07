; Use the str, vector, list, hash-map, and hash-set functions.

; str

(str "Hello," " World" "!")
(apply str ["Hi" " Niff" " Naff" " Nuff"])


; vector

[3 2 1]
(vector 3 2 1)
(-> [3 2 1] (get 1))
(-> [3 2 1] (conj 0))


; list

'(1 2 3)
(list 1 2 3)
(-> '(1 2 3) (nth 0))
(-> '(1 2 3) (conj 0))


; hash-map

(def yanis 
  {:name "yanis":surname "urbis" :meals {:breakfast "banana"}})

(hash-map 
  :name "yanis"
  :surname "urbis")

(get yanis :name)
(get yanis :name :surname)
(get-in yanis [:meals :breakfast])

; hash-set

(def sample-set #{1 23})
(hash-set 1 1 1 1 23 23 23 23)
(conj sample-set 23 24 25)
(-> [1 2 3] set)
(contains? sample-set 1)
(get sample-set 1)






  
