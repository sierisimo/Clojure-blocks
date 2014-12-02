;;;; Author: Sinuhe Jaime Valencia <sierisimo@gmail.com>
;;;;
;;;; Date: 24 - 11 - 2014
;;;;
;;;; LastUpdate 25 - 11 - 2014
;;;;
;;;; Contents:
;;;;   Help functions as `instructions` and `help`
;;;;

(ns clojure-blocks.help)

(defn instructions
  "Main Text to show at loading the game"
  []
  (println "##Instructions for block-world:")
  (println "
           Hi, welcome to block-world, this set of instructions are writed for letting you get started with block-world in clojure.

           The things that are suppossed to be writen by you at the REPL are noted by ``

           You can start with two of basic commands, probably you already know the first one:
           `(instructions)` which shows this text.

           The second one is `(help \"command\")` which will show you usage for a certain command.

           The next is the result of runnign `(commands)` this command will show you a list of avaliable commands. You can
           write it at any time if you forgot something.

           ")
  )

(defn commands
  "List of commands avaliable at REPL time"
  []
  (println "avaliable commands at REPL (Read Evaluate Print Loop) time:

           instructions --Show a small text on how to use block-world.
           help         --Asks for help on certain command.
           start        --Run the main instructions for letting you play.
           commands     --Shows this list.
           state        --Shows you the state of the board.
           block-types  --Shows the set of avaliable types of blocks you can use.
           create-block --Creates a new block based on a given Keyword.
           add-block    --Adds a new block to the board.
           remv-block   --Removes the top block from a the given position
           remv-all-in  --Removes all the block in given position

           NOTE:
             REMEMBER!! that you always have to use this commands in the form:
               (command ...)

             and you can check what can be '...' with (help \"command\")
           ")
  )

(defn help
  "You send a command and we show a lot of text about it ;)"
  [command]
  (case command
    "instructions" (println "Command:  instructions

                    Usage:
                              (instructions)

                            Arguments:
                              [This function takes no arguments]

                            Synopsis:
                              instructions will show you just a basic text explaining how to get started with block-world.
                            ")
    "help" (println "Command:  help

                    Usage:
                              (help \"command\")

                            Arguments:
                              [
                               command --A string that is suppossed to be the name of an avaliable command [for avaliable commands
                                         write `(commands)` ]
                              ]

                            Synopsis:
                              instructions will show you just a basic text explaining how to get started with block-world.
                            ")
    "start" (println "Command:  start

                     Usage:
                              (start)

                            Arguments:
                              [This function takes no arguments]

                            Synopsis:
                              Let the play begin... also, if the game already started, it restarts the board.
                            ")
    "commands" (println "Command:  commands

                     Usage:
                              (commands)

                            Arguments:
                              [This function takes no arguments]

                            Synopsis:
                              This command will show you a list of avaliable commands with a small explanation on what they do.
                            ")
    "state" (println "Command:  state

                     Usage:
                              (state)

                            Arguments:
                              [This function takes no arguments]

                            Synopsis:
                              This command will show you a list of avaliable commands with a small explanation on what they do.
                            ")
    "block-types" (println "Command:  block-types

                     Usage:
                              (block-types)

                            Arguments:
                              [This function takes no arguments]

                            Synopsis:
                              This command will show you a set of avaliable block types for create.
                            ")
     "create-block" (println "Command:  create-block

                     Usage:
                              (create-block figure)

                            Arguments:
                              [
                               figure --Can be one of the Keywords in `(block-types)` or of the next strings:
                                       \"block\"   - Creates a :cube
                                       \"pyramid\" - Creates a :pyramid
                                       \"sphere\"  - Creates a sphere
                              ]

                            Synopsis:
                              Returns a special object of the type you call.
                            ")
    "add-block" (println "Command:  add-block

                     Usage:
                              (add-block block position-x position-y)

                            Arguments:
                              [
                               block      --A special object of block type. See `(help \"create-block\")` for more info.
                               position-x --A keyword telling the position in board. Can be one of -> :a :b :c :d :e
                               position-y --A number from 1 trougth 12
                              ]

                            Synopsis:
                              Adds a block to the current board
                         ")
    "remv-block" (println "Command:  remv-block

                     Usage:
                              (remv-block position-x position-y)

                            Arguments:
                              [
                               position-x --A keyword telling the position in board. Can be one of -> :a :b :c :d :e
                               position-y --A number from 1 trougth 12
                              ]

                            Synopsis:
                              Removes the top block in the given position.
                         ")
    "remv-all-in" (println "Command:  remv-all-in

                     Usage:
                              (remv-all-in position-x position-y)

                            Arguments:
                              [
                               position-x --A keyword telling the position in board. Can be one of -> :a :b :c :d :e
                               position-y --A number from 1 trougth 12
                              ]

                            Synopsis:
                              Throws all the blocks in the given position to /dev/null ;) ;)
                         ")

    (let []
      (println "Error: " command " not found.
               You can write:
                   (commands) --to see a full list of command avaliable
               ")
      (help "help")
    ))
  )
