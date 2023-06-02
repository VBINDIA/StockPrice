# Get Code
https://github.com/VBINDIA/StockPrice
# Maven build for springboot app
mvn clean install
# Create Docker image
docker build -t stock/java .
# Run docker springboot app on port 8500
docker stop java-app-stock
docker rm java-app-stock
docker run -d -p 8500:8500 --name java-app-stock stock/java
# Create angular app image
docker build -t stock/angular angular-stock-price/.
# Run docker angular app on port 80 in nginx 
docker stop angular-app-stock
docker rm angular-app-stock
docker run -d -it -p 80:80/tcp --name angular-app-stock stock/angular:latest
# UI Application URL
[localhost:80](http://localhost/)
# API url
ws://localhost:8500/stocks
