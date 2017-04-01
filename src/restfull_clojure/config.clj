(ns restfull-clojure.config
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def db-uri "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=Design_20")

(defn migration-config []
  {:datastore (jdbc/sql-database {:connection-uri db-uri})
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (migration-config)))

(defn rollback []
  (repl/rollback (migration-config)))
