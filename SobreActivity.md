## => O que é uma activity?
- Componente no android que representa a tela do app. Onde teremos itens (botões, menus, listas etc)
- Composta pela classe kotlin(arquivo.kt) e o arquivo xml

## => Navegar entre activities
- Para abrir uma nova activity, usamos o método **"startActivity"**.
```
startActivity( Intent(this, nomeDaClasse::class.java) )
```
- Precisa passar como parâmetro desse método um objeto **"Intent"**(Intenção)
```
Intent(contexto, classe)
```
### a) O que é contexto?
- Ponto de acesso a informações globais do app. ex: Qual activity queremos abrir? Onde quero executar a ação?
### b) Exemplo de navegação de uma activity para outra
- Vamos passar da activity main para a activity secundary em main vamos colocar o código:
```
val intent = Intent(this, secundaryActivity::class.java)
startActivity( intent)
```
Obs1: Nesse caso o startActivity pode ser inserido dentro de um setOnClickListener { }

Obs2: Conforme abrimos uma activity ela vai ficando sobre a outra formando uma **PILHA DE ACTIVITIES**

### C) Fechar uma activity
- Para fechar uma activity podemos usar o método **finish()**
  
ex:
```
val.setOnClickListener{
finish()
}
```
Obs: O exemplo acima é para uma ação de clique em botão para fechar

## => Ciclo de Vida de uma activity
### 1) onCreate()
- Chamado para configurações e construir o layout. Aqui podemos colocar um widget de carregamento, por exemplo
- Exibe o carregando
- Primeiro a ser chamado, cria a activity, é executado apenas uma vez até a activity ser destruída. Concluído, chama o onStart
### 2) onStart()
- Quando os dados estão carregados propriamente na tela
- Pega os dados
- Define que a activity está em processo de inicialização e torna visível a activity.
### 3) onResume()
- Escondo o carregando
- Deixa definitivamente o app pronto pra uso.
- Aqui ativa as funcionalidades
- A activity fica na parte superior da pilha. Aqui há a interação com usuário até que este feche ou saia da tela
### 4) onPause
- A activity fica em espera caso alguma  outra funcionalidade sobreponha o app como uma ligação telefônica
### 5) onStop
- chamado quando a activity fica invisível ao usuário. O app libera recursos que não precisam ficar mais disponíveis.
### 6) onRestart
- A activity sai do estado de espera/pausado onPause() ou onStop() e volta ao uso
- Depois dele sempre vem o onStart() e incia novamente o ciclo

### Exemplo de ciclos
  
![image](https://github.com/user-attachments/assets/34b9ec60-db54-49ee-a033-c4ac998264da)











