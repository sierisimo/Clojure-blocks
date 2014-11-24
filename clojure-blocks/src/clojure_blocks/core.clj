(ns clojure-blocks.core
  (:gen-class) (:require [block-world.board :as board]))

(defn instructions
  []
  (println "##Instructions for block-world:")
  (println "\tHi, welcome to block-world, this set of instructions are writed for letting you get started with
           block-world in clojure ")
)

(defn help
  []
  (instructions)
)


(defn -main
  "I'm a block-world representation written in Clojure D: !!."
  [& args]
  (println "Welcome to block-world.")
  (println "This block-world is written totally in clojure. Is made for your fun and educational porpouses")
  (println "\n\t")
  (board/init-world)
)
