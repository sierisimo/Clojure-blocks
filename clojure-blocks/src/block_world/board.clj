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
  (:require [block-world.blocks :as blocks]
            [block-tools.utils :as block-utils])
  (:import [block_world.blocks Cube]
           [block_world.blocks Pyramid]
           [block_world.blocks Sphere])
  )

;;; Private map that represents the board
(def ;^{:private true}
  board-map {:a (ref [0 0 0 0 0 0 0 0 0 0 0 0])
             :b (ref [0 0 0 0 0 0 0 0 0 0 0 0])
             :c (ref [0 0 0 0 0 0 0 0 0 0 0 0])
             :d (ref [0 0 0 0 0 0 0 0 0 0 0 0])
             :e (ref [0 0 0 0 0 0 0 0 0 0 0 0])
             })

(def ;^{:private true}
  board-data {:a (ref [[] [] [] [] [] [] [] [] [] [] [] []])
              :b (ref [[] [] [] [] [] [] [] [] [] [] [] []])
              :c (ref [[] [] [] [] [] [] [] [] [] [] [] []])
              :d (ref [[] [] [] [] [] [] [] [] [] [] [] []])
              :e (ref [[] [] [] [] [] [] [] [] [] [] [] []])
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
   (let [n-boad
         (when (not= (:block-name blok) :iblock)
           (println "Trying to add a new" (:block-name blok) "to this board")
           (let [last-block (last ((position-x (:bd-data self)) (- position-y 1)))]
             (if (instance? Pyramid last-block)
               (println "You cannot add blocks over pyramids!")
               (if (instance? Sphere last-block)
                 (println "You can't add a" (:block-name last-block) " over a sphere, it doesn't have sense")
                 (dosync
                  (alter (position-x (:bd-map self)) update-in [(- position-y 1)] inc)
                  (alter (position-x (:bd-data self)) update-in [(- position-y 1)] conj blok)
                  (println "Added!")
                  )
                 )
               )
             )
           )]
     )
   )
  (remv
   [self position-x position-y]
   (let [vect (position-x (:bd-data self))]
     (if (= (count (vect (- position-y 1))) 0)
       (println "The position doesn't have any blocks")
       (dosync
        (println "The block" (:block-name (last ((position-x (:bd-data self)) (- position-y 1)))) "was removed and trowed to hell")
        (alter vect assoc (- position-y 1) ;Just replace the vector with the new vector poped
               (pop (vect (- position-y 1))) ; Literal, pop the last block
               )
        (alter (position-x (:bd-map self)) update-in [(- position-y 1)] dec)
        )
       )
     )
   )
  (remv-all
   [self position-x position-y]
   (let [vect (position-x (:bd-data self))]
     (if (= (count (vect (- position-y 1))) 0)
       (println "But... there isn't any blog at that position :/ are you sure you know what are you doing?")
       (dosync
        (alter vect assoc (- position-y 1) [])
        (alter (position-x (:bd-map self)) update-in [(- position-y 1)] (fn [args] 0))
        (println "The position " position-x position-y " is clean now...")
        )
       )
     )
   )
  (reset
   [self]
   (assoc self :bd-map board-map :bd-data board-data))
  (state
   [self]
   (println "..."))

  ;;(str ...)
  )

(defn add-b
  [board blok position-x position-y]
  (if (instance? Board board)
    (add board blok position-x position-y)
    ()
    )
  )

(defn remv-b
  [board px py]
  (if (instance? Board board)
    (remv board px py)
    ()
    )
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
