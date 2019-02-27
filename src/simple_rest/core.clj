(ns simple-rest.core
  (:use compojure.core
        ring.middleware.json
        ring.util.response)
  (:require [compojure.route :as route]))

(defn up [name] (str "We're up " name "!"))

(defroutes my_routes
  (GET "/" [] (up "boi"))
  (GET "/user" [] (response {:user "jack"}))
  (route/resources "/"))


(def app (wrap-json-response my_routes))