(ns myapp.core
  (:require [compojure.core :refer :all]
            [hiccup.core :as hiccup]
            [org.httpkit.server :refer [run-server]])) ; httpkit is a server

(defn d3-page []
  (hiccup/html
    [:head
     [:title "Equation fitter"]]
    [:body
     [:div {:id "goalGraph"}]]))

(defroutes myapp
  (GET "/" [] (fn [req] (d3-page)))
  (GET "/hello" [] "Hello World"))


(defn -main [& args]
  (run-server myapp {:port 5000}))