(ns bunny.frontend.app1)

(defn init []
  (println "Hello Bunny 🐰🐰"))

(defn ^:dev/after-load start []
  (js/console.log "start")
  (init))
