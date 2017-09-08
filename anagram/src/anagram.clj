(ns anagram
  (:require [clojure.string :as str]))

(defn is-anagram? [word potential]
  (let [word (str/lower-case word) potential (str/lower-case potential)]
    (and
      (not (= word potential))
      (= (sort word) (sort potential)))))

(defn anagrams-for [word list]
  (filter (partial is-anagram? word) list))