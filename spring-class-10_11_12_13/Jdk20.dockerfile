FROM ubuntu:latest

WORKDIR /home/jdk20

# Download and extract Amazon Corretto 20 JDK
ADD https://corretto.aws/downloads/latest/amazon-corretto-20-x64-linux-jdk.tar.gz /home/jdk20/
RUN tar -xzf amazon-corretto-20-x64-linux-jdk.tar.gz --strip-components=1


# Remove downloaded archive file
RUN rm amazon-corretto-20-x64-linux-jdk.tar.gz


# Set JDK environment variables
ENV JAVA_HOME=/home/jdk20
ENV PATH=$PATH:$JAVA_HOME/bin

# Verify installation
RUN ["java", "-version"]

# Run command
CMD ["bash"]