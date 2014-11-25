;;;; Author: Sinuhe Jaime Valencia <sierisimo@gmail.com>
;;;;
;;;; Date: 24 - 11 - 2014
;;;;
;;;; LastUpdate 25 - 11 - 2014
;;;;
;;;; Contents:
;;;;   Main file for all the project, it allows the REPL had the vars
;;;;


(ns clojure-blocks.core
  (:gen-class)
  (:require [block-world.board :as board])
  (:require [help.core :as help])
  )


(defn -main
  "I'm a block-world representation written in Clojure D: !!."
  [& args]
  (println "

           Welcome to block-world.")
  (println "
           This block-world is written totally in clojure. Is made for your fun and educational porpouses")
  (println "\n\t")
  ;;(board/init-world)
  )

(defn state
  []
  (board/board-state)
  )

(defn instructions
  []
  (help/instructions)
  )

(-main)
(help/instructions)
