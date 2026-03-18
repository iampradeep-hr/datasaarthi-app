FROM node:20 AS build

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# 🔥 DEBUG (IMPORTANT)
RUN ls -R /app/dist

FROM nginx:alpine
COPY --from=build /app/dist/frontend /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]