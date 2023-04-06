FROM ubuntu:20.04

RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y curl
RUN curl -LO https://corretto.aws/downloads/latest/amazon-corretto-17-x64-linux-jdk.tar.gz
RUN tar -zxvf amazon-corretto-17-x64-linux-jdk.tar.gz  --output 'jdk-17_linux-x64'
RUN mv jdk-17_linux-x64 /usr/lib/jvm
RUN cd /usr/bin && ln -s /usr/lib/jvm/jdk-17_linux-x64/bin/java java
RUN rm amazon-corretto-17-x64-linux-jdk.tar.gz
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean

CMD ["java", "-version"]