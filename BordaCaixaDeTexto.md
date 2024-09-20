## Como criar uma caixa personalizada para um editText (caixa de texto ou input text)?

### 1) Criar um arquivo xml na pasta Drawable
- Após criar o arquivo usar a seguinte configuração:
```
  <?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="@android:color/transparent" />
    <stroke
        android:width="1dp"
        android:color="@color/cor1" />
    <corners android:radius="3dp" />
    <padding
        android:left="4dp"
        android:top="4dp"
        android:right="4dp"
        android:bottom="4dp" />
</shape>
```
a) a tag <shape é o corpo da borda

b) <solid é para indicar a cor ou tema do preenchimento

c) <stroke é linha e as propriedades: android:width="1dp" e android:color="@color/cor1" indicam a espessura da borda e a cor da mesma

d) <corners é o efeito do contorno, ou seja aplicar o efeito mais arredondado;
