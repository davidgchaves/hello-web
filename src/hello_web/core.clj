(ns hello-web.core
  (:require [ring.adapter.jetty :as jetty]))

(defn greet [req]
  (if (= "/" (:uri req))
    {:status 200
     :body "Hello, web!"
     :headers {}}
    {:status 404
     :body "Page not found."
     :headers {}}))

(defn -main [port]
  (jetty/run-jetty greet
                   {:port (Integer. port)}))

