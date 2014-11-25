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

           The second one is `(help \"command\")` which will show you usage for a certain command.
           ")
  )

(defn commands
  "List of commands avalible at REPL time"
  []
  (println "Avalible commands at REPL (Read Evaluate Print Loop) time:

           instructions --Show a small text on how to use block-world.
           help         --Asks for help on certain command.
           start        --Run the main instructions for letting you play.
           commands     --Shows this list.
           state        --Shows you the state of the board.


           NOTE: REMEMBERE that you always have to use this commands in the form:
             (command params)

           ")
  )

(defn help
  "You send a command and we show a lot of text about it ;)"
  [command]
  (println "Command:")
  (case command
    "instructions" (println "instructions

                            Usage:
                              (instructions)

                            Arguments:
                              [This function takes no arguments]

                            Synopsis:
                              instructions will show you just a basic text explaining how to get started with block-world.
                            ")
    "help" (println "help
                     Usage:
                              (help \"command\")

                            Arguments:
                              [
                               command --A string that is suppossed to be the name of an avalible command [for avalible commands
                                         write `(commands)` ]
                              ]

                            Synopsis:
                              instructions will show you just a basic text explaining how to get started with block-world.
                            ")

    (let []
      (println "Error: " command " not found.
               You can write:
                   (commands) --to see a full list of command avalible
               ")
      (help "help")
    ))
  )


