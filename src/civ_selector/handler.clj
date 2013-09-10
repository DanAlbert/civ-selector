(ns civ-selector.handler
  (:use compojure.core)
  (:use ring.middleware.reload)
  (:use ring.middleware.stacktrace)
  (:use civ-selector.middleware)
  (:use civ-selector.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (main-page))
  (route/resources "/")
  (route/not-found (not-found-page)))

(def app
  (-> (handler/site app-routes)
      (wrap-request-logging)
      (wrap-reload `[civ-selector.handler civ-selector.views civ-selector.db])
      (wrap-stacktrace)))
