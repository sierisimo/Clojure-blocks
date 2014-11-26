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

(defprotocol Board-ops
  (add [self blok])
  (remv [self position-x position-y])
  (remv-all [self position-x position-y])
  (reset [self])
  )

(defrecord Board [bd-map]
  Board-ops
  (add [self blok]
       (println blok))
  (remv [self position-x position-y]
        (println position-x))
  (remv-all [self position-x position-y]
        (println position-y))
  (reset [self]
         (println "Clear"))
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
