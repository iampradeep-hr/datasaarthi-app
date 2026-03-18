FROM node:20 AS build

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# The new builder puts files here by default:
FROM nginx:alpine
COPY --from=build /app/dist/datasaarthi-ui/browser /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]