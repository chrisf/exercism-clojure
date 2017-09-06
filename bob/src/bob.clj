(ns bob
  (:require [clojure.string :as str]))

(defn silence? [message]
  (empty? (str/trim message)))

(defn question? [message]
  (str/ends-with? message "?"))

(defn has-uppercase? [message]
  (not (nil? (re-find #"[A-Z]+" message))))

(defn shouting? [message]
  (and (has-uppercase? message)
    (= (str/upper-case message) message)))

(defn response-for [message]
  (cond
    (silence? message) "Fine. Be that way!"
    (shouting? message) "Whoa, chill out!"
    (question? message) "Sure."
    :else "Whatever."))