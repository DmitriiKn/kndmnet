# build
docker build --build-arg JAR_FILE=build/libs/*.jar -t ru.kndmnet/usernetserv .
# run
docker run -p 8001:8001 -e DB_HOST=192.168.0.106 -e DB_NAME=kndm_net_user_db -e DB_USER=postgres -e DB_PASS=postgres ru.kndmnet/usernetserv --name usersrv