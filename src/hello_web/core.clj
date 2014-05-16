(ns hello-web.core
  (:require [ring.adapter.jetty :as jetty]))

(defn greet [req]
  {:status 200
   :body "Hello, web!"
   :headers {}})

(defn -main [port]
  (jetty/run-jetty greet
                   {:port (Integer. port)}))

