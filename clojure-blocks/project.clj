(defproject clojure-blocks "0.1.0-SNAPSHOT"
  :description "Quiero un mundo de bloques, donde sea funcion..."
  :url "http://github.com:sierisimo/Clojure-blocks"
  :license {:name "General Public License v3"
            :url "https://gnu.org/licenses/gpl.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot clojure-blocks.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
