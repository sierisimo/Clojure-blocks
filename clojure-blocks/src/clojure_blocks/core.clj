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
  (:require [block-world.board :as board]
            [clojure-blocks.help :as core.help]
            [block-world.blocks :as blocks])
  (:import [block_world.board Board])
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

;; Just print the names
(defn block-types [] (println blocks/types))

;; Wrapper function for cration of blocks
(defn create-block [figure] (blocks/create-block figure))

(def board)

;; Wraper function for adding a block
(defn add-block
  "Adds a new block to the current board"
  [blok p-x p-y]
  (board/add-b board blok p-x p-y)
  )

(defn remv-block
  "Removes the block on top of position-x and position-y"
  [p-x p-y]
  (board/remv-b board p-x p-y)
  )

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
  (def board (board/create-board))
  )

(-main)
