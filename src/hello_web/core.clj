(ns hello-web.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn greet [req]
  (cond
    (= "/" (:uri req))
    {:status 200
     :body "Hello, web! (without restarting YAY!)"
     :headers {}}
    (= "/goodbye" (:uri req))
    {:status 200
     :body "Bye, web!"
     :headers {}}
    :else
    {:status 404
     :body "Page not found."
     :headers {}}))

(defn -main [port]
  (jetty/run-jetty greet                 {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'greet) {:port (Integer. port)}))
