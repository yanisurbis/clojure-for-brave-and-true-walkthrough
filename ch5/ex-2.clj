; implement the comp function

((comp mul-10 inc *) 2 3)

; first solution
(defn my-comp [& funcs]
  (fn [& args]
    (let [first-res (apply (last funcs) args)]
      (reduce
        (fn [res curr-func]
          (curr-func res))
        first-res
        (reverse (butlast funcs))))))

; second solution
(defn my-comp1 [& funcs]
  (fn [& args]
    (-> (reduce
          (fn [args curr-func]
            [(apply curr-func args)])
          args
          (reverse funcs))
        first)))
   
(defn mul-10 [elm]
  (* elm 10))

((my-comp mul-10 inc *) 2 3)
((my-comp1 mul-10 inc *) 2 3)
      
