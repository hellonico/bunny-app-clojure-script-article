(ns bunny.frontend.app6
  (:require [reagent.core :as reagent] [reagent.dom :as dom]))

(defonce app-state
  (reagent/atom {:seconds-elapsed 0}))

(defn set-timeout! [ratom]
  (js/setTimeout #(swap! ratom update :seconds-elapsed inc) 1000))

(defn timer-render [ratom]
  (let [seconds-elapsed (:seconds-elapsed @ratom)]
    [:div "Seconds Elapsed: " seconds-elapsed]))

(defn timer-component [ratom]
  (reagent/create-class
   {:reagent-render       #(timer-render ratom)
    :component-did-mount  #(set-timeout! ratom)
    :component-did-update #(set-timeout! ratom)}))

(defn render! []
  (dom/render [timer-component app-state]
              (.getElementById js/document "app")))

(defn init []
  (println "init")
;;   (render!)
  )