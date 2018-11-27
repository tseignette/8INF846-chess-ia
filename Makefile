all: source run

source:
	javac -d bin src/*.java

run:
	java -cp bin Main

jar:
	jar cf chessDestroyer.jar bin/*.class

clean:
	rm -R bin/*.class
