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
  (:require [clojure-blocks.help :as core.help])
  )


(defn -main
  "I'm a block-world representation written in Clojure D: !!."
  [& args]
  (println "

           Welcome to block-world.")
  (println "
           This block-world is written totally in clojure. Is made for your fun and educational porpouses.

           Now, if this is your first time playing you can start the game with `(start)` and get the blocks world beign amazing.

           ")
  )

;;; Show the instructions for the game
(defn instructions [] (core.help/instructions))

;;; Asks for help in certain command
(defn help [command] (core.help/help command))

;;; Show the state of the board/game
(defn state [] (board/board-state))

;;; Show avalible commands
(defn commands [] (core.help/commands))

;;; Prints the welcome state for the game
(defn start
  []
  (println "Starting....
           ...
           ")
  (core.help/instructions)
  (println "Everything ready, you can start with:")
  (commands)
  (println "This is the actual state of your current board")
  (board/board-reset)
  (state)
  )

(-main)
