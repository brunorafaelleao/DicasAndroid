## Como criar/configurar um tema para um Arquivo Android
### 1) Definir as cores do projeto
1.1) O Android Studio tem um arquivo em que as cores são declaradas/definidas e fica na pasta app/src/main/res/values/colors.xml
1.2) Para definir/declarar uma nova cor, dentro de resources usar a tag <color name=
ex:
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="cor1">#FF157856</color>
    <color name="cor2">#23715A</color>

    <color name="corComplementar">#781538</color>
</resources>
```
### 2) Declarar as cores no arquivo dos Temas (themes.xml)
2.1) O Android Studio tem um arquivo de temas que fica em app/src/main/res/values/themes.xml
   Dentro desse arquivo os temas são atribuídos e geralmente ao criar um novo projeto ele fica com
   essa linha
```
<resources> xmlns:tools="http://schemas.android.com/tools"
    <!-- Base application theme. -->
    <style name="Theme.Malariamobile" parent="Theme.Material3.DayNight.NoActionBar">
```
- Isso significa que o tema do meu projeto herda cores e detalhes do tema padrão do Android que é o nosso tema "pai":
parent="Theme.Material3.DayNight.NoActionBar"

2.2) Mudar as cores de do tema de acordo com os nomes padrão
- Alguns nomes seguem uma regra ex: cor primária, secundária, complementar etc.
- No Android Studio os nomes são: colorPrimary, colorPrimaryVariant etc.
- Para mudar essas cores do tema usar a tag:
```
<item name=""></item>
```
- Cada cor deve ser declarada e a partir dessa inserção, a do tema pai deixa de ser usada (ela é sobrescrita):
- ex:
```
<resources> xmlns:tools="http://schemas.android.com/tools"
    <!-- Base application theme. -->
    <style name="Theme.Malariamobile" parent="Theme.Material3.DayNight.NoActionBar">

        <!--Tema base da aplicação-->
        <item name="colorPrimary">@color/cor1</item>
        <item name="colorPrimaryVariant">@color/corComplementar</item>

        <!--cor dentro dos elementos de cor primária ex: botão-->
        <item name="colorOnPrimary">@color/white</item>
    </style>
</resources>
```
- No exemplo acima, interpretamos que a cor principal é a "cor1" que foi definida no arquivo colors.xml
   
### 3) Mudar a cor da barra de status do App (barra superior que traz os ícones e info do aparelho (bateria, redes móveis, etc)
3.1) Por padrão a barra de status (statusBar) vem com a cor variante (colorPrimaryVariant), mas caso queira uma cor diferente, pode ser usado uma declarão dessa barra no arquivo themes.xml
ex:
```
<item name="android:statusBarColor">@color/corSecundaria</item>
```
