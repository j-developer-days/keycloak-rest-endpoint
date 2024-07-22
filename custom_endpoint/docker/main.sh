#!/bin/bash

DOCKER_COMPOSE_FILE=./docker-compose.yml

echo '1 - Docker compose UP as detached mode'
echo '2 - Docker compose list'
echo '3 - Keycloak log"s'
echo '4 - Docker compose DOWN & UP as detached mode'
echo '-----------------------------'
echo 'c | C - clear screen'
echo 'e | E - EXIT'


#******************************************************
if [ -z "$1" ]; then
  read -p "Enter your command number: " COMMAND_NUMBER
else
  COMMAND_NUMBER=$1
  DOCKER_COMPOSE_FILE=$2
fi
#******************************************************
echo "*********************************" $COMMAND_NUMBER
case "$COMMAND_NUMBER" in
   "1") docker compose -f $DOCKER_COMPOSE_FILE up -d --build
   ;;
   "2") docker compose -f $DOCKER_COMPOSE_FILE ps
   ;;
   "3") docker logs -f --details keycloak24
   ;;
   "4")
   pwd
   docker -D compose -f $DOCKER_COMPOSE_FILE down
   docker -D compose -f $DOCKER_COMPOSE_FILE up -d --build
   ;;
   "e"|"E") exit 1
   ;;
   "c"|"C") clear
   ;;
    *) ./main.sh
   ;;
esac

./main.sh