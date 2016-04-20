(
 ;;
 ;; Integers
 ;;

 "number written (0..12, 16, 17)"
 #"(?i)(null|eins|zw(oe|o|ö)lf|zw(ei|o)|drei|vier|f(ue|u|ü)nf|sechs|sieben|acht|neun|zehn|elf|sechzehn|siebzehn)" 
;; zwo(e)lf, 12, before 2, like in English fourteen before four. 
;; Make sure the regex doesn't stop there
 {:dim :number
  :integer true
  :value (get {"null" 0 "eins" 1 "zwei" 2 "zwo" 2 "drei" 3 "vier" 4 "funf" 5 "fuenf" 5 "fünf" 5 "sechs" 6 "sieben" 7 "acht" 8 "neun" 9 "zehn" 10 "elf" 11 "zwolf" 12 "zwoelf" 12 "zwölf" 12 "sechzehn" 16 "siebzehn" 17}
(-> %1 :groups first .toLowerCase))}

 "integer (numeric)"
 #"(\d{1,100})"
 {:dim :number
  :integer true
  :value (Long/parseLong (first (:groups %1)))}

;;
;; Ordinal numbers
;;

 


)
