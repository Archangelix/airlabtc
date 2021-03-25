#!/bin/sh

cd $APP_VAR
java $JAVA_OPTS -jar $APP_LIB/app.jar --server.port=$HTTP_PORT
