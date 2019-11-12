(ns task-cabinet-server.service.utils
  (:require[buddy.hashers :as hashers]))

;; https://funcool.github.io/buddy-hashers/latest/
(defn check-password
  "check password
  args:
  -  user: a map contains hashed-password (from db)
  -  password: raw password
  returns:
  user or user
  "
  [user password]
  (if  (hashers/check password (:password user))
    user nil))

(defn hash-password
  "hash password
  args:
  - password: raw password
  returns:
  hashed-password
  "
  [password]
  (hashers/derive password))

