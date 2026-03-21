# build environment
FROM maven:3.9.11-eclipse-temurin-21 AS build
COPY ./ /home/app
COPY settings.xml /root/.m2/settings.xml
RUN mvn -f /home/app/pom.xml clean verify

# build documentation
FROM node:alpine AS docs
RUN npm install -g @redocly/cli
COPY --from=build /home/app/openapi /home/app
COPY redocly-theme.yaml /home/app/config/redocly-theme.yaml
COPY images /home/app/images
RUN for file in /home/app/*.yaml; do redocly build-docs "$file" -o "${file/yaml/html}" --config=/home/app/config/redocly-theme.yaml; done

# production environment
FROM nginx:stable-alpine
COPY --from=build /home/app/index.html /usr/share/nginx/html/docs/index.html
COPY --from=build /home/app/style.css /usr/share/nginx/html/docs/style.css
COPY --from=build /home/app/images/ilm-logo.svg /usr/share/nginx/html/docs/images/ilm-logo.svg
COPY --from=docs /home/app /usr/share/nginx/html/docs
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
