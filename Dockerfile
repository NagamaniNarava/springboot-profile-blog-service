From tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/*.jar /usr/local/tomcat/webapps/ROOT.jar
CMD ["catalina.sh","run"]	