(defproject hello-web "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.2.2"]
                 [compojure "1.1.8"]]

  :min-lein-version "2.0.0"

  :uberjar-name "hello-web.jar"

  :main hello-web.core

  :profiles {:dev
             {:main hello-web.core/-dev-main}})
