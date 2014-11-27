;;;; Author: Sinuhe Jaime Valencia <sierisimo@gmail.com>
;;;;
;;;; Date: 24 - 11 - 2014
;;;;
;;;; LastUpdate 25 - 11 - 2014
;;;;
;;;; Contents:
;;;;   Elements that represent the main board where the blocks are gonna be played
;;;;

(ns block-world.board
  (:require [block-world.blocks :as blocks])
  (:require [block-tools.utils :as block-utils])
  (:import [block_world.blocks Cube])
  )

;;; Private map that represents the board
(def ;^{:private true}
  board-map {:a [0 0 0 0 0 0 0 0 0 0 0 0]
             :b [0 0 0 0 0 0 0 0 0 0 0 0];[[0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]]
             :c [0 0 0 0 0 0 0 0 0 0 0 0];[[0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]]
             :d [0 0 0 0 0 0 0 0 0 0 0 0];[[0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]]
             :e [0 0 0 0 0 0 0 0 0 0 0 0];[[0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]]
             })

(def ;^{:private true}
  board-data {:a [[] [] [] [] [] [] [] [] [] [] [] []]
              :b [[] [] [] [] [] [] [] [] [] [] [] []]
              :c [[] [] [] [] [] [] [] [] [] [] [] []]
              :d [[] [] [] [] [] [] [] [] [] [] [] []]
              :e [[] [] [] [] [] [] [] [] [] [] [] []]
              })

;;; Interface for opertions on a board
(defprotocol Board-ops
  (add [self blok position-x position-y])
  (remv [self position-x position-y])
  (remv-all [self position-x position-y])
  (reset [self])
  (state [self])
  )

;;; General object/class of name Board.
(defrecord Board [bd-map bd-data]
  Board-ops
  (add
   [self blok position-x position-y] ;The function need to recive a block, which line and what position
   (let [n-boad (when (not= (:block-name blok) :iblock)
                  (println "Adding a new " (:block-name blok) "to this board")
                  (println (instance? Cube blok))
                  ;(def blok (move blok position-x position-y))
                  (let [t-board self]
                    (update-in t-board [:bd-map position-x (- position-y 1)] inc)
                    )
                  )]
     n-boad)
   )
  (remv
   [self position-x position-y]
   (println position-x))
  (remv-all
   [self position-x position-y]
   (println position-y))
  (reset
   [self]
   (assoc self :bd-map board-map :bd-data board-data))
  (state
   [self]
   (println "..."))
  )

;;; Returns a new Board object.
(defn create-board
  "Create a board with default status"
  []
  (Board. board-map board-data)
  )

(defn board-state
  "Prints out a nice view of the board"
  [bord]
  (println "Board size is 5 x 12
           You can add elements giving a letter and a position starting at 1.
           ")
  (doseq [keyval board-map] (println (key keyval) (val keyval)))
  )
