;;;; Author: Sinuhe Jaime Valencia <sierisimo@gmail.com>
;;;;
;;;; Date: 24 - 11 - 2014
;;;;
;;;; LastUpdate 25 - 11 - 2014
;;;;
;;;; Contents:
;;;;   Help functions as `instructions` and `help`
;;;;

(ns help.core)

(defn instructions
  "Main Text to show at loading the game"
  []
  (println "##Instructions for block-world:")
  (println "
           Hi, welcome to block-world, this set of instructions are writed for letting you get started with block-world in clojure.

           You can start with two of basic commands, probably you already know the first one:
           `(instructions)` which shows this text.

           The second one is `(help 'command)` which will show you usage for a certain command.

           Now, you can start the game with `(start)` and get the blocks world beign amazing.")
)

(defn help
  "You send a command and we show a lot of text about it ;)"
  [command]
  (println "Aja")
)
