FROM node:18.16.0 as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:alpine
COPY --from=node /app/dist/angular-stock-price /usr/share/nginx/html