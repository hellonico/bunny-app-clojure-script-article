(ns bunny.frontend.utils)

(defn set-props [o property-map]
  (doseq [[k v] property-map]
    (.setAttribute o (name k) v)))

(defn create-el [tag-name property-map]
  (let [el (.createElement js/document tag-name)]
    (set-props el property-map)
    el))