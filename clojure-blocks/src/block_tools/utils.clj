;;;; Author: Sinuhe Jaime Valencia <sierisimo@gmail.com>
;;;;
;;;; Date: 24 - 11 - 2014
;;;;
;;;; LastUpdate 25 - 11 - 2014
;;;;
;;;; Contents:
;;;;   Set of tools for work with blocks
;;;;

(ns block-tools.utils
  (:require [block-world.blocks :only [types] :as blocks])
  )

;;
(defn block-type
  [block]
  (if (contains? (:name block) blocks/types) (:name block) :uknown)
)
