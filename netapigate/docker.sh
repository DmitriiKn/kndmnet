# build
docker build --build-arg JAR_FILE=build/libs/*.jar -t ru.kndmnet/netapigate .
# run
docker run -p 8000:8002 ru.kndmnet/netapigate --name netapigate