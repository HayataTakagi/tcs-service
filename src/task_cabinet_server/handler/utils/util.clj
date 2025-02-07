(ns task-cabinet-server.handler.utils.util
  (:require [taoensso.timbre :as timbre])
  ;;(:require [ring.middleware.cors :refer [wrap-cors]])
  )
  

;; https://enpitut2019.github.io/
;; http://localhost
;; https://localhost

;; (def default-origin
;;   [#"http://localhost:4200" #"https://localhost:4200" #"http://localhost" #"https://localhost:3001" #"https://enpitut2019.github.io" #".*"]
;;   )

(defn my-wrap-cors
  "Wrap the server response in a Control-Allow-Origin Header to
  allow connections from the web app."
  [handler]
  (fn [request]
    (timbre/warn "Access Origin: " (-> request :headers (get "origin")))
    (let [response (handler request)]
      (-> response
          (assoc-in [:headers "Access-Control-Allow-Origin"] "*")
          (assoc-in [:headers "Access-Control-Allow-Headers"] "Content-Type")
          (assoc-in [:headers "Access-Control-Allow-Methods"] "*")))))

;; (defn my-wrap-cors [handler]
;;  (wrap-cors handler :access-control-allow-origin default-origin))
