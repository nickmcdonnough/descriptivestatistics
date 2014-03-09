(ns descriptivestatistics.core)

(defn sum [x]
  (reduce + (into [] x)))

(defn mean [x]
  (double (/ (sum (into [] x)) (count x))))

(defn median [x]
  (let [sorted (sort x)
        l (count x)]
  (if (= (mod (count x) 2) 0)
    (/ (+ (- (nth sorted (/ l 2)) 1) (nth sorted (/ l 2))) 2.0)
    (nth sorted (/ l 2)))))

(defn mode [x]
  (first (last (sort-by last (frequencies x)))))

(defn ds-range [x]
  (- (last (sort x)) (first (sort x))))

(defn variance [x]
  (let [y (mean x)]
  (/ (sum (map #(Math/pow (- y %) 2) x)) (count x))))

(defn standard-deviation [x]
  (Math/sqrt (variance x)))

(defn percentile-from-value [x v]
  (let [sorted (sort x)]
  (Math/ceil (* (/ (.indexOf sorted v) (count x)) 100))))

(defn value-from-percentile [x p]
  (let [sorted (sort x)
        rank (* (/ p 100 ) (- (count x) 1))
        f (Math/floor rank)
        d (- rank f)
        v (+ (nth sorted f) (* d (- (nth sorted (+ f 1)) (nth sorted f))))]
  (first (filter #(>= % v) x))))
