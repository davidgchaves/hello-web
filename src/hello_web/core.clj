(ns hello-web.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn greet [req]
  {:status 200
   :body "Hello, web!"
   :headers {}})

(defn request [req]
  {:status 200
   :body (pr-str req)
   :headers {}})

(defn personal-greeting [req]
  (let [name (get-in req [:route-params :name])]
    {:status 200
     :body (str "Yo! " name "!")
     :headers {}}))

(defn about [req]
  {:status 200
   :body "Hi. I'm David and I'm having tons of fun learning Web Dev in Clojure... Yay!!!!"
   :headers {}})

(defn bye [req]
  {:status 200
   :body "Bye, web!"
   :headers {}})

(defroutes app
  (GET "/" [] greet)
  (GET "/about" [] about)
  (GET "/request" [] request)
  (GET "/pretty-request" [] handle-dump)
  (GET "/yo/:name" [] personal-greeting)
  (GET "/goodbye" [] bye)
  (not-found "Page not found."))

(defn -main [port]
  (jetty/run-jetty app                 {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'app) {:port (Integer. port)}))
