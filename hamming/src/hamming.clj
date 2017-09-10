(ns hamming)

(defn distance [dna-1 dna-2]
  "Calculates the Hamming distance between two DNA strands"
  (if (not (= (count dna-1) (count dna-2)))
    nil
    (count (filter (fn [x] (false? x)) (map = dna-1 dna-2)))))