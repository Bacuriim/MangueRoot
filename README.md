
# 🛠️ Geração de Executável Nativo (.exe) com GraalVM

Este guia mostra como empacotar um projeto Spring Boot em um `.jar`, descompactá-lo e gerar um `.exe` com GraalVM `native-image`.

---

## ✅ Pré-requisitos

- Java 17 e Maven instalados
- GraalVM com `native-image` disponível no PATH
- `native-image` instalado (via `gu install native-image`)

---

## 📦 Etapa 1: Gerar o `.jar` com Maven

Abra o terminal na raiz do projeto e execute:

```bash
mvn clean package -DskipTests
```

Isso gerará o arquivo:

```bash
target/mangueroot-0.1.0.jar
```

---

## 📂 Etapa 2: Descompactar o `.jar` Spring Boot

Descompacte o `.jar` em uma pasta separada:

```bash
mkdir unpacked
cd unpacked
jar -xf ../target/mangueroot-0.1.0.jar
cd ..
```

Agora a estrutura do diretório `unpacked/` estará assim:

```text
unpacked/
├── BOOT-INF/
│   ├── classes/
│   └── lib/
├── META-INF/
└── org/
```

---

## ⚙️ Etapa 3: Gerar o `.exe` com `native-image`

Execute o comando abaixo para gerar o binário nativo:

```bash
native-image ^
  -cp "unpacked/BOOT-INF/classes;unpacked/BOOT-INF/lib/*" ^
  mangue.MangueRootApplication ^
  --no-fallback ^
  --static ^
  --install-exit-handlers ^
  -H:Name=MangueRoot
```

> No Linux ou WSL, substitua os `;` por `:` no classpath.

---

## 📁 Resultado

Ao final do processo, será gerado:

```bash
MangueRoot.exe
```

Você poderá executá-lo diretamente:

```bash
.\MangueRoot.exe
```

---

## 🧪 Dica para Testes

Certifique-se de que o `application.properties` ou `application.yml` esteja corretamente configurado dentro do `BOOT-INF/classes`.

---

## ✅ Conclusão

Agora você tem um binário nativo leve e rápido, ideal para distribuição sem necessidade de JVM!
