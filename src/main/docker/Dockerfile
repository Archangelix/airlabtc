FROM dockerhub.gemalto.com/gemalto/i386/alpine.java:3.9.4-19-9

USER root

# Copy libraries...
COPY ./tc-1.0-SNAPSHOT.jar $APP_LIB/app.jar

# Copy start script...
COPY ./docker-build/context/startServer.sh $APP_BIN

# Add permissions...
RUN chown -R trent:gemalto $APP_LIB \
    && chown -R trent:gemalto $APP_ETC \
    && chown -R trent:gemalto $APP_BIN \
    && chmod -R g+rx $APP_BIN

# Define entry point...
ENTRYPOINT ["bash", "startServer.sh"]
CMD [""]

# Run as bob...
USER bob
