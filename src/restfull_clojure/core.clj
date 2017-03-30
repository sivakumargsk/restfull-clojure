(ns restfull-clojure.core
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [ring.util.response :refer [response]]
            ))

(defroutes app-routes
  (route/not-found
   (response {:message "Page not found"})))

(defn wrap-log-request [handler]
  (fn [req]
    (println req)
    (handler req)))


(def app
  (-> app-routes
      wrap-log-request
      wrap-json-response
      wrap-json-body))
