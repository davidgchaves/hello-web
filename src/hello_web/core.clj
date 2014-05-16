(ns hello-web.core
  (:require [ring.adapter.jetty :as jetty]))

(defn -main [port]
  (jetty/run-jetty (fn [req] {:status 200 :body "Hello, web!" :headers {}})
                   {:port (Integer. port)}))

