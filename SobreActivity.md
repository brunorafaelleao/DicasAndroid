## O que é uma activity?
- Componente no android que representa a tela do app. Onde teremos itens (botões, menus, listas etc)
- Composta pela classe kotlin(arquivo.kt) e o arquivo xml

## Navegar entre activities
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
