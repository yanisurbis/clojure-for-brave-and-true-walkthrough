; Look up and use the update-in function
(def users [{:name "James" :age 26}  {:name "John" :age 43}])
(update-in users [1 :age] inc)

(def p {:name "James" :age 26})
(update-in p [:age] inc)
(update-in p [:age] + 10)
(update-in p [:age] - 10)
