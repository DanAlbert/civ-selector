(defproject civ-selector "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.2.0"]
                 [ring/ring-json "0.2.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [hiccup-bootstrap "0.1.2"]
                 [com.novemberain/monger "1.5.0"]
                 [sqlitejdbc "0.5.6"]]
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler civ-selector.handler/app}
  :uberjar-name "civ-selector.jar"
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]}
             :uberjar {:main civ-selector.handler, :aot :all}})
