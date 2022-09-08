(ns bunny.frontend.app3
  (:require ["react" :as react] ["react-dom" :as dom]))

(defn init []
  (dom/render 
           (react/createElement "h2" nil (str "Hello, Bunny 🐰"))
           (.getElementById js/document "app")))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))

(defn ^:dev/after-load start []
  (js/console.log "start")
  (init))
