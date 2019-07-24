(ns ttl2ignf.core
  (:require
   [clojure.java.io :as io]
   [ont-app.igraph.core :as ig]
   [ont-app.igraph.graph :as g]
   [ont-app.vocabulary.core :as voc]
   [ont-app.sparql-client.core :as sparql]
   [taoensso.timbre :as log]
   )
  (:gen-class))

(defn ensure-final 
  "returns `s`, possibly appending `c` 
Where:
<s> is a string
<c> is a character
"
  [s c]
  {:pre [(char? c)
         (string? s)]
   }
  (if (= (last s) c)
    s
    (str s c)))

(defn log-error [msg]
  (binding [*out* *err*]
    (log/error msg)))

(defn -main
  "Pretty-prints the contents of an RDF file in IGraph Normal Form."
  [& args]
  (if-let [endpoint (System/getenv "SPARQL_ENDPOINT")]
    (let [path (first args)
          file (io/file path)
          graph-hash (hash file)
          ]
      (if (.exists file)
        (let [graph-uri (keyword (str "http://dummy.graph/" graph-hash))
              client (sparql/make-graph
                     :graph-uri graph-uri
                     :query-url (str (ensure-final endpoint \/) "query")
                     :update-url (str (ensure-final endpoint \/) "update"))

              ]
          (try
            (sparql/update-endpoint
             client
             (str "DROP GRAPH <http://dummy.graph/" graph-hash ">"))
            (sparql/update-endpoint
             client
             (str "CREATE GRAPH <http://dummy.graph/" graph-hash ">"))
            (sparql/update-endpoint
             client
             (str "LOAD <file://"
                  (.getAbsolutePath file)
                  "> INTO GRAPH <http://dummy.graph/"
                  graph-hash
                  ">"))
            (catch Error e
              (log-error (str "LOAD FAILED for endoint "
                              endpoint
                              " and path "
                              path))))
          (clojure.pprint/pprint (ig/normal-form client)))
        
        (log-error (str path " does not exist."))))
        
    ;; else no endpoint envar
    (log-error  "No env var for SPARQL_ENDPOINT.")))
