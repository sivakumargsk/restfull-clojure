(defproject restfull-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [compojure "1.5.2"]
                 [cheshire "5.7.0"]
                 [ring/ring-json "0.4.0"]
                 [korma "0.4.3"]
                 [org.postgresql/postgresql "9.4-1206-jdbc42"]
                 [ragtime "0.7.0"]]

  :plugins [[lein-ring "0.11.0"]]

  :ring {:handler restfull-clojure.core/app
         :port 3006
         :nrepl {:start? true :port 9998}}

  :aliases {"migrate"  ["run" "-m" "restfull-clojure.config/migrate"]
            "rollback" ["run" "-m" "restfull-clojure.config/rollback"]}

  :profiles {:dev
             {:dependencies
              [[javax.servlet/servlet-api "2.5"]
               [ring/ring-mock "0.3.0"]]}})
