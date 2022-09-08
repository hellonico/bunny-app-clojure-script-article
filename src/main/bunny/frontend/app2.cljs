(ns bunny.frontend.app2
  (:require [bunny.frontend.utils :as u]))

(defn init []
  (println "Init")
  (let [img (u/create-el "img"
                         {:src "/bunny-512.webp" :height 128 :width 128})]
    (.appendChild (.getElementById js/document "app") img)))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))

(defn ^:dev/after-load start []
  (js/console.log "start")
  (init))
