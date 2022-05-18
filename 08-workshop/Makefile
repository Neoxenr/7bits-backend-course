.PHONY : build test start run

build: 
	mvn clean package

test: 
	mvn test

start: build run 

run: 
	java -jar ./target/eightworkshop-1.0-SNAPSHOT.jar
