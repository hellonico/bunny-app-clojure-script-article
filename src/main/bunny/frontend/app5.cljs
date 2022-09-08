(ns bunny.frontend.app5
  (:require [clojure.string :as str])
  (:require [reagent.core :as r][reagent.dom :as d]))

(defonce state (r/atom {:model 0}))

(defn increment []
  (swap! state update :model inc))

(defn decrement []
  (swap! state update :model dec))

(defn n-to-image[idx n] 
  [:img {:key idx :src (str "/img/nums/" n ".png")}])

(defn counter[]
  (let [m (:model @state)
        m-as-characters (rest (str/split (str m) #""))]
    [:span (map-indexed n-to-image m-as-characters)]))

(defn button [display fn]
  [:button {:style {:background-color "white"} :on-click fn} [:img {:src (str "/img/nums/" display "-key.png")}]]
  )

(defn main []
  [:div
   (button "minus" decrement)
   (counter)
   (button "plus" increment)])

(defn init []
  (d/render [main] (.getElementById js/document "app")))