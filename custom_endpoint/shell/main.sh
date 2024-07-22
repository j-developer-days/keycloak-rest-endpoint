#!/bin/bash

#---------------------------------------------------
clean_install()
{
	clear && mvn --file ../pom.xml -U clean install
}
#---------------------------------------------------

#---------------------------------------------------
copy_jar_file()
{
	cp -v ../target/custom_endpoint.jar ../docker/keycloak/providers/
	ls -la ../docker/keycloak/providers/
}
#---------------------------------------------------

#---------------------------------------------------
jar_file_content()
{
	jar -tfv ../target/custom_endpoint.jar
}
#---------------------------------------------------

echo '1 - clean install and copy jar file'
echo '2 - sort pom'
echo ---------------------------------------------------
echo 'e | E - EXIT'
echo 'c | C - clear screen'

if [ -z $1 ]; then
    read COMMAND_NUMBER
  else
    COMMAND_NUMBER=$1
fi

case "$COMMAND_NUMBER" in
   "1") clean_install
        jar_file_content
        copy_jar_file
        ../docker/main.sh 4 ../docker/docker-compose.yml
   ;;
   "2") clear && mvn --file ../pom.xml -U com.github.ekryd.sortpom:sortpom-maven-plugin:2.15.0:sort
   		  sleep 1
		    find ../. -name '*pom.xml.bak' -delete
   ;;
   "e"|"E") exit 1
   ;;
   "c"|"C") clear
   ;;
    *) sh -e ./main.sh
   ;;
esac

echo "---------------------------------------------------------------------------------------------------"

sh -e ./main.sh