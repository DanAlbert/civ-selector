(ns civ-selector.views
  (:use compojure.core)
  (:use [hiccup core page])
  (:use [korma core db])
  (:use civ-selector.db)
  (:use civ-selector.middleware))

(defn view-layout [title & content]
  (html5
    [:head
     [:title title]
     (include-css "/css/default.css")]
     [:body content]))

(defn main-page []
  (view-layout "Civ Selector"
    [:h1 "Civ Selector"]))

(defn not-found-page []
  (view-layout "Civ Selector - Not Found"
    [:h1 "Page not found"]))
