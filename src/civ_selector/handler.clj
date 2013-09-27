(ns civ-selector.handler
  (:use compojure.core)
  (:use ring.middleware.json)
  (:use ring.middleware.reload)
  (:use ring.middleware.stacktrace)
  (:use hiccup.bootstrap.middleware)
  (:use civ-selector.middleware)
  (:use civ-selector.views)
  (:require [ring.adapter.jetty :as ring]
            [compojure.handler :as handler]
            [compojure.route :as route])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] (main-page))
  (POST "/civs/select" [civs] (select-civ civs))
  (route/resources "/")
  (route/not-found (not-found-page)))

(def app
  (-> (handler/site app-routes)
      (wrap-json-params)
      (wrap-json-response)
      (wrap-json-body)
      (wrap-bootstrap-resources)
      (wrap-request-logging)
      (wrap-reload `[civ-selector.handler civ-selector.views civ-selector.db])
      (wrap-stacktrace)))

(defn start [port]
  (ring/run-jetty (var app) {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))
