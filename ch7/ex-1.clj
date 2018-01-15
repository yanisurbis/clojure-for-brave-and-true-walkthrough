; 1 - simple macro
(defmacro backwards
  [form]
  (reverse form))

(backwards (" backwards" " am" "I" str))

; 2 -evaluate clojure code
(def addition-list (list + 1 2))
(eval addition-list)


