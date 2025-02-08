# 基本の Java 21 イメージを指定
FROM openjdk:21-jdk

# 作業ディレクトリを設定
WORKDIR /app

# 必要なビルドツール（Gradle）をインストール
RUN apt-get update && apt-get install -y gradle

# アプリケーションコードをコピー
COPY . /app

# Gradle でアプリケーションをビルド
RUN ./gradlew clean build

# ビルドした JAR ファイルを指定して実行
CMD ["java", "-jar", "build/libs/otokogi-0.0.1-SNAPSHOT.jar"]

# アプリケーションがリスンするポートを公開
EXPOSE 8080

