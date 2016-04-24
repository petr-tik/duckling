(
 ;;
 ;; Integers
 ;;

 "intergers written (0..10, 20, 30, 60, 70, 100)"
 #"(?i)(null|ein(s|e(r|m|n)?)|zw(ei|o)|drei(β|ss)ig|drei|vier|f(ue|u|ü)nf|sechs|sieben|acht|neun|zehn|zwanzig|sechzig|siebzig|hundert)" 
;; Make sure the regex doesn't stop on shorter words
;; zwo(e)lf, 12, before zwei, 2, like in English fourteen before four. 
;; drei(ss|β)ig, 30, before drei, 3
 {:dim :number
  :integer true
  :value (get {"null" 0 "einer" 1 "eine" 1 "eins" 1 "zwei" 2 "zwo" 2 "drei" 3 "vier" 4 "funf" 5 "fuenf" 5 "fünf" 5 "sechs" 6 "sieben" 7 "acht" 8 "neun" 9 "zehn" 10 "zwanzig" 20 "dreiβig" 30 "dreissig" 30 "sechzig" 60 "siebzig" 70 "hundert" 100} 
(-> %1 :groups first .toLowerCase))}

 "integers written (11, 12, 16, 17)"
 #"(?i)(elf|zw(oe|o|ö)lf|sechzehn|siebzehn)"
  {:dim :number
  :integer true
  :value (get {"elf" 11 "zwolf" 12 "zwoelf" 12 
               "zwölf" 12 "sechzehn" 16 "siebzehn" 17} 
(-> %1 :groups first .toLowerCase))}

 "integers written (13, 14, 15, 18, 19"
 [(integer 0 9) #"(?i)zehn"]
 {:dim :number
  :integer true
  :value (+ 10 (:value %1))}

 "integers (40, 50, 80, 90)"
 [(integer 4 9 #(#{40 50 80 90} (:value %))) #"(?i)zig"]
 {:dim :number
  :integer true
  :value (* (:value %1) 10)}

 "integer (numeric)"
 #"(\d{1,100})"
 {:dim :number
  :integer true
  :value (Long/parseLong (first (:groups %1)))}

;;
;; Ordinal numbers
;;

  "ordinals (first, third, seventh, eight)"
  #"(?i)(erste|dritte|siebte|achte)(s|r)?"
  {:dim :ordinal
   :value (get {"erste" 1 "dritte" 3 "siebte" 7 "achte" 8}
              (-> %1 :groups first .toLowerCase))}

)
