(ns nucleotide-count)

(defn valid-dna? [dna]
  "Validate the given DNA strand"
  (not (nil? (re-matches #"(G|C|T|A)+" (str dna)))))

(defn count [nucleotide dna]
  "Count how many times the nucleotide occurs in the DNA string"
  (if (and (not (empty? dna)) (or (not (valid-dna? nucleotide)) (not (valid-dna? dna))))
    (throw (AssertionError. "Given DNA was not valid")))
  (get (frequencies dna) nucleotide 0))

(defn nucleotide-counts [dna]
  "Count the nucleotides that occur in the DNA string"
  (def nucleotides [\G \C \T \A])
  (zipmap nucleotides (map (fn [x] (nucleotide-count/count x dna)) nucleotides)))