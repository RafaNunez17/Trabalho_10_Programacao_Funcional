; ALUNO: Rafael Vitagliano Tannenbaum Nuñez

; 1. Na aula disponível em: https://replit.com/@frankalcantara/ClojureAula2?v=1 foram destacadas diversas funções (expressões), como funções de primeira ordem, disponíveis em Clojure. Sua primeira tarefa será descrever cada uma destas funções e apresentar dois exemplos de uso de cada uma delas. Lembre-se os exemplos precisam ser utilizados de forma que o resutado da função possa ser visto no terminal.

; assoc
; Quando combinada com um mapa, retorna uma lista que apresenta o mapeamento de chaves e valores.

(println "\nFunção assoc; exemplo 1: " (->> (assoc {:a 1 :b 2 :c 3 :d 4} :e 5)))

(println "Função assoc; exemplo 2: " (->> (assoc [1 2 3] 0 "rafa")))

; dissoc 
; Função utilizada para remover chaves (e seus valores) de um mapa.

(println "\nFunção dissoc; exemplo 1: " (->> (dissoc {:a 1 :b 2 :c 3 :d 4} :d)))

(println "Função dissoc; exemplo 2: " (->> (dissoc {:a 1 :b 2 :c 3 :d 4} :a :c :d)))

; range
; Função utilizada para criar uma sequência de números. Podemos especificar o primeiro valor, o último valor e definir se o intervalo entre os números que formam a sequência.

(println "\nFunção range; exemplo 1: " (->> (range 10)))

(println "Função range; exemplo 2: " (->> (range -50 30 10)))

; map
; retorna uma sequência de números gerados a partir de uma aplicação.

(println "\nFunção map; exemplo 1: " (->> (map + [10 15 2] [8 12 7])))

(println "Função map; exemplo 2: " (->> (map + [10 15 2] (iterate inc 1))))

;inc
; Função que retorna um valor 1 unidade maior do que aquele passado como parâmetro.

(println "\nFunção inc; exemplo 1: " (->> (inc 20)))

(println "Função inc; exemplo 2: " (->> (inc 9.0)))

; filter
; Função que filtra itens dentro de uma lista.

(println "\nFunção filter; exemplo 1: " (->> (filter even? (range 5))))

(println "Função filter; exemplo 2: " (->> (filter odd? (range 5))))

; odd
; Usado para verificar o número passado como parâmetro é ímpar ou não.

(println "\nFunção odd; exemplo 1: " (->> (odd? 2)))

(println "Função odd; exemplo 2: " (->> (odd? 3)))

; into
; Função que retorna uma lista contendo os intens retirados de uma outra lista passada como parâmetro.

(println "\nFunção into; exemplo 1: " (->> (into () '(10 20 30))))

(println "Função into; exemplo 2: " (->> (into [15 25 35] '(10 20 30))))

; nth
; Função que retorna o valor no índice especificado.

(println "\nFunção nth; exemplo 1: " (->> (nth (list 10 15 20 25) 0)))

(println "Função nth; exemplo 2: " (->> (nth (list 10 15 20 25) 3)))

; conj 
; Função que retorna uma lista de itens conjugados.

(println "\nFunção conj; exemplo 1: " (->> (conj [10 20 30 40] 50)))

(println "Função conj; exemplo 2: " (->> (conj ["Rafael"] " Nunez")))

; sort
; Função que retorna uma sequência ordenada.

(println "\nFunção sort; exemplo 1: " (->> (sort [10 9 2 15 3])))

(println "Função sort; exemplo 2: " (->> (sort [9 8 7 6 5])))

; empty
; Função que retorna uma lista vazia.

(println "\nFunção empty; exemplo 1: " (->> (empty [10 9 2 15 3])))

(println "Função empty; exemplo 2: " (->> (empty '(7 29 1 2))))

; count
; Função usada para contar o número de elementos em uma lista.

(println "\nFunção count; exemplo 1: " (->> (count [10 9 2 15 3])))

(println "Função count; exemplo 2: " (->> (count [])))

; partition-by
; Função que divide uma sequência em  subsequências.

(println "\nFunção partition-by; exemplo 1: " (->> (partition-by even? [10 9 2 15 3])))

(println "Função partition-by; exemplo 2: " (->> (partition-by odd? [2 2 2 3 3 3 5 5 5])))

; 2. Utilizando a linguagem Clojure, crie uma função chamada ehPrimo que receba um inteiro e devolva True caso este inteiro seja verdadeiro e False caso contrário. 

(defn ehPrimo
  [numero]
  (loop [x 1 y []]
    (if (= x (+ numero 1)) (if (= (count y) 2) true false)
    (recur (inc x)
           (if (zero? (mod numero x))
                    (conj y x) y)))))

(println "\nExercício 2; Entrada: 5; Resultado: " (ehPrimo 5))
(println "Exercício 2; Entrada: 9; Resultado: " (ehPrimo 9))

; 3. Utilizando a linguagem Clojure, crie uma função chamada fatoresPrimos que receba um inteiro e devolva uma lista dos seus fatores primos. Decomposição em fatores primos é uma tarefa fundamental da aritmética.

(defn numeroPrimo 
  [a b]
  (if (= a b) true 
    (if (= (mod a b) 0) false 
      (numeroPrimo a (+ b 1)))))

(defn operacaoDivisao 
  [a b]
  (if (false? (numeroPrimo b 2)) (operacaoDivisao a (+ b 1))
    (if (= (mod a b) 0) b
      (operacaoDivisao a (+ b 1)))))

(defn fatoresPrimos 
  [numero]
  (if (true? (numeroPrimo numero 2)) 
    [numero] 
    (concat [(operacaoDivisao numero 2)] 
            (fatoresPrimos (/ numero (operacaoDivisao numero 2))))))

(println "\nExercício 3; Entrada: 15; Resultado: " (fatoresPrimos 15))
(println "Exercício 3; Entrada: 9; Resultado: " (fatoresPrimos 9))
(println "Exercício 3; Entrada: 27; Resultado: " (fatoresPrimos 27))

;4. Utilizando a linguagem Clojure, crie uma função chamada todosPrimos que receba dois valores inteiros e devolve todos os números primos que existam entre estes dois valores.

(defn todosPrimos 
  [a b] 
  (loop [x (range a (+ b 1)) y []]
      (if (empty? (rest x)) y 
        (recur (rest x)
               (if (ehPrimo (nth x 0)) 
                 (conj y (nth x 0)) y)))))

(println "\nExercício 4; Entrada: 1 10; Resultado: " (todosPrimos 1 10))
(println "Exercício 4; Entrada: 11 20; Resultado: " (todosPrimos 11 20))