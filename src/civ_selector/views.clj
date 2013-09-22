(ns civ-selector.views
  (:use compojure.core)
  (:use [hiccup core page])
  (:use hiccup.bootstrap.page)
  (:use civ-selector.db)
  (:use civ-selector.middleware))

(defn view-layout [title & content]
  (html5 {:lang "en"}
    [:head
     [:title title]
     (include-bootstrap)
     (include-css "/css/default.css")
     (include-js "http://code.jquery.com/jquery-2.0.3.min.js")]
    [:body
     [:div.navbar.navbar-inverse.navbar-fixed-top
      [:div.navbar-inner
       [:div.container
        [:a.brand {:href "/"} "civ-selector"]]]]
     [:div.container content]]))

(def available-civs
  ["USA"
   "Netherlands"
   "Russia"])

(def civ-selector-form
  [:form#available-civs {:action "#"}
   [:fieldset
    [:legend "Civ Selector"]
    [:label "Select from"]
    (for [civ (get-civs)]
      [:label.checkbox
       [:input {:type "checkbox"
                :name (:name civ)
                :checked "checked"} (:name civ)]])
    [:button.btn {:type="submit"} "Submit"]]])

(defn main-page []
  (view-layout "Civ Selector"
               civ-selector-form
               [:p#selection-result]
               (include-js "/js/civ-selector.js")))

(defn select-civ [select-from]
  (str (rand-nth select-from)))

(defn not-found-page []
  (view-layout "Civ Selector - Not Found"
               [:h1 "Page not found"]))

(defn map-tag [tag xs]
  (map (fn [x] [tag x]) xs))
