; http://clojure-doc.org/articles/language/namespaces.html
; https://www.braveclojure.com/organization/
; https://gist.github.com/ghoseb/287710/

; print current namespace
(ns-name *ns*)
(ns-interns 'clj.user)

(def name1 "yanis")
(def surname1 "urbis")

; Returns a map of the intern mappings for the namespace
(ns-interns *ns*)

inc
'inc

(map inc [1 2 3])
'(map inc [1 2 3])

; access to map of mappings
(get (ns-interns *ns*) 'great-books)
(get (ns-interns *ns*) 'name1)
(get (ns-interns *ns*) 'surname1)

(deref #'clj.user/name1)

(create-ns 'cheese)
(ns-name *ns*)

(in-ns 'cheess)
(ns-name *ns*)
(ns-interns 'cheess)
(def name1 "yanis")

(ns-interns *ns*)
(ns-interns 'cheess)
(ns-interns (ns-name *ns*))
name1
(get [1 2 3] 1)

(in-ns 'cheess1)
; name1 -> error
cheess/name1
(clojure.core/refer 'cheess)
; no error
name1







