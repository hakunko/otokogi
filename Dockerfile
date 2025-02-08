# 1. Javaの公式イメージを使う（例: OpenJDK 17）
FROM openjdk:21-jdk

# 2. 作業ディレクトリを作成
WORKDIR /app

# 3. JARファイルをコンテナにコピー
COPY build/libs/otokogi-0.0.1-SNAPSHOT.jar app.jar

# 4. ポートを開放（Spring Bootのデフォルトは8080）
EXPOSE 8080

# 5. アプリケーションの起動コマンド
CMD ["java", "-jar", "app.jar"]
