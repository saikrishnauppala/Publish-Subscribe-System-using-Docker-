Implemented using Rendezvous Algorithm (RIP) :
Breaking the eventspace into subsets through hashing and the subsets are notified by associated broker.
Regularity is maintained by Distributed hash table

This project is a emulation of Real World's Kafkas PubSub Model. 

Build the docker images using 

docker build -t imagename pathOfDockerFile

Run Docker images on containers using two ways

Method1 : Run all the containers individually 

#Mysql Container
docker run -p 3306:3306 --name my-mysql -e MYSQL_ROOT_PASSWORD=root  -e MYSQL_DATABASE=ds  my-mysql

#for pubsub containers imagename is pubsuba1
docker run -it --rm -p 8080:8080 --name pubsuba1 pubsuba1   #PubSuba1 running on 8080 port

docker run -it --rm -p 4040:8080 --name pubsuba2 pubsuba1	#PubSuba2 running on 4040 port

Method2 : Build and Run a dockercomposefile.

Technology Stack:
Docker,JAVA,JSP,Servlet,JDBC,Mysql.
