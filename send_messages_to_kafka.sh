#!/bin/bash
cat src/main/resources/numbers.json |  docker-compose exec -T kafka sh -c "kafka-console-producer --broker-list localhost:9092 --topic trap_advisor_events"