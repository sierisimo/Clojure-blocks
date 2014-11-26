;;;; Author: Sinuhe Jaime Valencia <sierisimo@gmail.com>
;;;;
;;;; Date: 24 - 11 - 2014
;;;;
;;;; LastUpdate 25 - 11 - 2014
;;;;
;;;; Contents:
;;;;   The functions and structures for creating "blocks", "pyramids" and "spheres"
;;;;
(ns block-world.blocks)

;; Set of names, just names, not very important
;; Update: The original behaivor of this was to have a hash-map but (case ...) doesn't know how to look at
;; (get types :block) when value is `str` or clojure.lang.Symbol so... just let the stuff be a set.
(def types #{:block :pyramid :sphere})

;;;At this point I tried to use `(deftype Block ...)` but it's 2 AM and I want to sleep a litle...
;;; so get I mad at the idea while reading a lot of java code at github
;;; ( https://github.com/clojure/clojure/blob/master/src/jvm/clojure/lang/IPersistentMap.java ) and
;;; ( https://github.com/clojure/clojure/blob/master/src/jvm/clojure/lang/RT.java ) and instead of taking
;;; the correct way (learn, modify and then create...) I Sier, decided to just use the boring hash-maps
;;; and implement a lot of checks in the functions that work with that hash-maps.
;;;
;;; I know I'll hate me when I reach this code in the future, but damn, there's a null documentation about
;;; creating your own datatypes, or which methods you have to use when extending something
;;; from clojure.lang.*
;;;
;;; So that is, that is why the next 3 functions are just a big and sad LIE to the full program.
;;;
;;; But seeing the positive side... The function that adds block will work with a hash-map that holds
;;; only a label and a position, that's good because we don't force the user to use our own "amazing"
;;; object/structs, but it's dangerous because you know... the user is always stupid...
;;;

(defrecord Cube [data])
(defrecord Sphere [data])
(defrecord Pyramid [daa])

(defprotocol Block
  (move [self position])
  (trash [self])
  )

(extend-type Cube
  Block
  (move [position] (println position))
  (trash [_] (println "Sending to trash..."))
  )


;; ^{:private true} is used for not letting the `require` get this function.
(defn ^{:private true}
  c-block
  []
  ;; I FUCKING HATE YOU (deftype ...) I REALLY FUCKING HATE YOU. YOU MAKE ME WASTE LIKE 3 HOURS OF USELESS CODE READING
  (let [tblock {:name :block
                :position nil
                }]
    tblock) ; TODO: Make the block object
  )

(defn ^{:private true}
  p-block
  []
  ;; SERIOUSLY, IT'S VERY STUPID HOW MANY DOCUMENTS DOES NOT EXIST ABOUT HOW TO USE THE DAMN (deftype ...)
  (let [tblock {:name :pyramid
                :position nil
                }]
    tblock) ; TODO: Make the block object
  )

(defn ^{:private true}
  s-block
  []
  ;; EVEN STACKOVERFLOW HAS A VERY SMALL NUMBER OF ANSEWRS ABOUT IT!
  (let [tblock {:name :sphere
                :position nil
                }]
    tblock) ; TODO: Make the block object
  )

;; This function creates all kind of blocks
(defn create-block
  [figure]
  ;; Create-Block
  ;; Call it without params, it returns a block object
  ;;
  (let [f-block
        (case figure
          (:block 'block "block") (c-block)
          (:pyramid 'pyramid "pyramid") (p-block)
          (:sphere 'sphere "sphere") (s-block)
          {:name :iblock
           :position nil})]
    f-block)
  )
