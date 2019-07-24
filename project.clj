(defproject ttl2ignf "0.1.0-SNAPSHOT"
  :description "Translates a ttl file into IGraph normal form"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [ont-app/igraph "0.1.4-SNAPSHOT"]
                 [ont-app/sparql-client "0.1.0-SNAPSHOT"]
                 [ont-app/sparql-endpoint "0.1.1-SNAPSHOT"]
                 [ont-app/vocabulary "0.1.0-SNAPSHOT"]
                 ]
  :main ^:skip-aot ttl2ignf.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
