(ns anagram
  (:require [clojure.string :as str]))

(defn same-word [word1 word2]
  (let [word1-lc (str/lower-case word1)
        word2-lc (str/lower-case word2)]
     (= word1-lc word2-lc)))

(defn same-letters-case-insensitive [word1 word2]
  (let [word1-lc (str/lower-case word1)
        word2-lc (str/lower-case word2)]
     (= (sort (frequencies word1-lc)) (sort (frequencies word2-lc)))))

(defn contains-same-letters-diff-word [word1 word2]
  (if (same-word word1 word2)
    false
    (same-letters-case-insensitive word1 word2)))

(defn anagrams-for [word coll]
  (filter #(contains-same-letters-diff-word word %) coll))
