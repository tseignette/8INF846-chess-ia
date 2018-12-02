all: source jar

source:
	javac -d bin src/*.java

jar: source
	jar cef Main chessDestroyer.jar -C bin .

run:
	java -jar chessDestroyer.jar

clean:
	rm -R bin/*.class chessDestroyer.jar
