(ns civ-selector.db
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]))

(mg/connect-via-uri! (System/getenv "MONGOHQ_URL"))
(mg/use-db! (System/getenv "DB_NAME"))

(defn get-civs [& query-opts]
  (mc/find-maps "civilizations" query-opts))

(defn add-civ [civ]
  (mc/insert "civilizations" civ))
