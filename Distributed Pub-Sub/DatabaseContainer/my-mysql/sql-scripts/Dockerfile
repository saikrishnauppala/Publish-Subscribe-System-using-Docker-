FROM mysql
ENV MYSQL_DATABASE=ds
ENV MYSQL_ROOT_PASSWORD=root
COPY ./ /docker-entrypoint-initdb.d/
EXPOSE 3306