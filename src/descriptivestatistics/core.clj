(ns descriptivestatistics.core)

(defn sum [x]
  (reduce + x))

(defn square [x] (* x x))

(defn mean [x]
  (double (/ (sum x) (count x))))

(defn median [x]
  (let [sorted (sort x)
        l (count x)
        i (nth sorted (/ l 2))]
  (if (even? l)
    (-> l
      (/ 2)
      dec
      (#(nth sorted %))
      (+ i)
      (/ 2.0))
    i)))

(defn mode [x]
  (first (last (sort-by last (frequencies x)))))

(defn ds-range [x]
  (- (reduce max x) (reduce min x)))

(defn variance [x]
  (let [y (mean x)]
  (/ (sum (map #(square (- y %)) x)) (count x))))

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
