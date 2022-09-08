(ns bunny.frontend.app4
  (:require [cljs-time.core :as t :refer [plus months weeks]])
  (:require ["react" :as react] ["react-dom" :as dom]))

(defn init []
  (dom/render
   (react/createElement "h2" nil (str "Hello, Bunny 🐰🐰🐰" 
                                      (plus (t/now) (months 1) (weeks 3))))
   (.getElementById js/document "app")))