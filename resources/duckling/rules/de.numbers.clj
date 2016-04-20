(
 ;;
 ;; Integers
 ;;

 "number written (0..12, 16, 17)"
 #"(?i)(null|eins|zw(ei|o)|drei|vier|f(ue|u|ü)nf|sechs|sieben|acht|neun|zehn|elf|zw(oe|o|ö)lf|sechzehn|siebzehn)"
 {:dim :number
  :integer true
  :value (get {"null" 0 "eins" 1 "zwei" 2 "zwo" 2 "drei" 3 "vier" 4 "funf" 5 "fuenf" 5 "fünf" 5 "sechs" 6 "sieben" 7 "acht" 8 "neun" 9 "zehn" 10 "elf" 11 "zwolf" 12 "zwoelf" 12 "zwölf" 12 "sechzehn" 16 "siebzehn" 17}
(-> %1 :groups first .toLowerCase))}


)
