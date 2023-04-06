FROM corretto:20

WORKDIR /home/tomcat10

# Download and extract Apache Tomcat 10.1.7 distribution
ADD https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.7/bin/apache-tomcat-10.1.7.tar.gz /home/tomcat10/
RUN tar -xzf apache-tomcat-10.1.7.tar.gz --strip-components=1

# Remove downloaded archive file
RUN rm apache-tomcat-10.1.7.tar.gz

# Set Tomcat environment variables
ENV CATALINA_HOME=/home/tomcat10
ENV PATH=$PATH:$CATALINA_HOME/bin

# Expose Tomcat default port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]