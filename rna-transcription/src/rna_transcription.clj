(ns rna-transcription)

(defn valid-dna? [dna]
  "Validate the given DNA strand"
  (not (nil? (re-matches #"(G|C|T|A)+" dna)))
)

(defn replace-dna [letter]
  "Returns the complement to a given part of a DNA strand"
  (cond
    (= (str letter) "G") "C"
    (= (str letter) "C") "G"
    (= (str letter) "T") "A"
    (= (str letter) "A") "U"
    :else (throw (Exception. "Incorrect input given to replace-dna.")))
  )

(defn to-rna [dna]
  "Given a DNA strand, return its RNA complement"
  (if (not (valid-dna? dna)) (throw (AssertionError. "Given DNA was not valid.")))

  (apply str 
    (map replace-dna (seq dna)))
)
