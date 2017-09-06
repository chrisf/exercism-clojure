(ns word-count
  (:require [clojure.string :as str]))

(defn inc-word-count [dict word]
  "Increment the count of a word"
  (assoc dict word (inc (dict word 0))))

(defn split-words [sentence]
  "Split the sentence into a vector of words"
  ; remove all characters that aren't letters or digits
  (def sentence-no-punctuation (str/replace sentence #"[^\p{L}\p{Nd}]+" " "))
  (str/split (str/lower-case sentence-no-punctuation) #" "))

(defn word-count [sentence]
  "Count the words in a sentence"
  (reduce inc-word-count {} (split-words sentence)))