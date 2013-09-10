(ns civ-selector.db
  (:use [korma core db]))

(defdb dev
       (sqlite3 {:db "civ-selevtor.db"}))

(defentity civ
  (entity-fields :id :name))
