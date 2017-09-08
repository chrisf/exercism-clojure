(ns beer-song)

(defn verse [verse-num]
  (cond
    (> verse-num 2) (str verse-num " bottles of beer on the wall, " verse-num " bottles of beer.\nTake one down and pass it around, " (- verse-num 1) " bottles of beer on the wall.\n")
    (= verse-num 2) "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    (= verse-num 1) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    (= verse-num 0) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"))

(defn sing
  ([verse-start]
    (sing verse-start 0))

  ([verse-start verse-end]
    (clojure.string/join "\n" (map verse (reverse (range verse-end (+ verse-start 1)))))))