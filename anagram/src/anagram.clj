(ns anagram
  (:require [clojure.string :as str]))

(defn is-anagram? [word potential]
  (and
    (not (= (str/lower-case word) (str/lower-case potential)))
    (= (sort (str/lower-case word)) (sort (str/lower-case potential)))))

(defn anagrams-for [word list]
  (filter (partial is-anagram? word) list))