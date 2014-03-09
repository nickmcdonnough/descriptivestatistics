(ns descriptivestatistics.core-test
  (:use clojure.test
        descriptivestatistics.core))


(deftest sum-test
  (testing "sum of [1 2 3 4 5] is 15"
    (is (= (sum [1 2 3 4 5]) 15))))

(deftest mean-test
  (testing "mean of [1 2 3 4 5] is 3.0"
    (is (= (mean [1 2 3 4 5]) 3.0))))

(deftest median-test
  (testing "median of [1 1 2 3 10 5] is 2.5"
    (is (= (median [1 1 2 3 10 5]) 2.5))))

(deftest mode-test
  (testing "mode of [1 2 1 5 1 3 2 1] is 1"
    (is (= (mode [1 2 1 5 1 3 2 1]) 1))))

(deftest ds-range-test
  (testing "range of [2 4 18 3 5] is 16"
    (is (= (ds-range [2 4 18 3 5]) 16))))

(deftest variance-test
  (testing "variance of [1 2 3 4 5 6] is 2.9166666666666665"
    (is (= (variance [1 2 3 4 5 6]) 2.9166666666666665))))

(deftest standard-deviation-test
  (testing "standard deviation of [10 20 30 40 50] is 14.142135623730951"
    (is (= (standard-deviation [10 20 30 40 50]) 14.142135623730951))))

(deftest percentile-from-value-test
  (testing "precentile from value [1 1 2 3 10] is 80.0"
    (is (= (percentile-from-value [1 1 2 3 10] 10) 80.0))))

(deftest value-from-percentile-test
  (testing "60th percentile value from [1 1 2 3 10 7 12] is 10"
    (is (= (value-from-percentile [1 1 2 3 10 7 12] 75) 10))))
