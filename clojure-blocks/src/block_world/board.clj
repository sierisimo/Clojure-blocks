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
  )

;;; Make the size of the board avalible but read-only
;;(def ^{:const true}
;;  board-width 5)
;;(def ^{:const true}
;;  board-height 12)

(defprotocol Board
  (add [self block]
       [self block-vector]
  )
  (move [self]
        [self block]
  )
  (reset [self])
  )

(def board-map {:a [[] [] [] [] [] [] [] [] [] [] [] []]
                :b [[] [] [] [] [] [] [] [] [] [] [] []]
                :c [[] [] [] [] [] [] [] [] [] [] [] []]
                :d [[] [] [] [] [] [] [] [] [] [] [] []]
                :e [[] [] [] [] [] [] [] [] [] [] [] []]
                })

(defn board-state
  "Prints out a nice view of the board"
  []
  (println "Board size is 5 x 12
           You can add elements giving a letter and a position starting at 1.
           ")
  (doseq [keyval board-map] (println (key keyval) (val keyval)))
  )

;;TODO: function reset-board launched by start should reset the board...
(defn board-reset
  "Reset the elements in the board."
  []
  )
