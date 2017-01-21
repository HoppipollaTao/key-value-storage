FROM java:8
EXPOSE 8080
ADD /target/key-value-storage.jar key-value-storage.jar
ENTRYPOINT ["java","-jar","key-value-storage.jar"]