; 1 - simple macro
(defmacro backwards
  [form]
  (reverse form))

(backwards (" backwards" " am" "I" str))

; 2 -evaluate clojure code
(def addition-list (list + 1 2))
(eval addition-list)
(eval (concat addition-list [10]))

; 3 - more complex evaluation
(eval (list 'def 'lucky-number (concat addition-list [10])))
lucky-number

; 4 - you can read and evaluate with clojure
(def sample-list (read-string "(+ 1 2)"))
(eval sample-list)

; 5 - reader macro
; Reader macros are sets of rules for transforming text into data structures.
; macro characters ' or # or @

; 6 - evaluation phase
; whenever Clojure evaluates data structures that aren’t a list or symbol, the result is the data structure itself

; 6.1 - symbols
(read-string "+")
(type (read-string "+"))
(list (read-string "+") 1 2)

(read-string "map")
(type (read-string "map"))
(list (read-string "map") inc [1 2 3])
(eval (list (read-string "map") inc [1 2 3]))

; ------------------------

; ex-1
; Use the list function, quoting, and read-string to create a list that, when evaluated, prints your first name and your favorite sci-fi movie.

(def ex1 (list 'print "Blade Runner"))
(eval ex1)

; ex-2, supported only + - *
(let [infix (read-string "(1 + 3 * 4 - 5)")]
  (list (second infix) (first infix) (last infix)))






