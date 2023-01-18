# build environment
FROM maven:3.8.7-eclipse-temurin-17 as build
COPY ./ /home/app
COPY settings.xml /root/.m2/settings.xml
ARG SERVER_USERNAME
ARG SERVER_PASSWORD
RUN mvn -f /home/app/pom.xml clean verify

# build documentation
FROM node:alpine as docs
RUN npm install -g redoc-cli
COPY --from=build /home/app/openapi /home/app
RUN for file in /home/app/*.yaml; do redoc-cli build "$file" -o "${file/yaml/html}" --options.theme.logo.gutter=20px; done

# production environment
FROM nginx:stable-alpine
COPY --from=build /home/app/index.html /usr/share/nginx/html/docs/index.html
COPY --from=build /home/app/style.css /usr/share/nginx/html/docs/style.css
COPY --from=build /home/app/images/czertainly_color_H.svg /usr/share/nginx/html/docs/images/czertainly_color_H.svg
COPY --from=docs /home/app /usr/share/nginx/html/docs
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
