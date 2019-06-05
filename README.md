Publish and Subscribe System using Docker.
This repository consists of two projects:<br>
1)Centralised Pub/Sub System.<br>
2)Distributed Pub/Sub System.<br>
Both the projects are Containerised using Docker.
Distributed Pub/Sub project emulates real world's Kafka's Pub/Sub Architecture.
In Realworld Pub-sub systems are seperated geographically so we are implementing different docker containers to simulate this.
In this distributed system brokers broadcast the events to subscribers as soon as a publisher publishes an event using RIP algorithm.
