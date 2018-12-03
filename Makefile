all: source jar

source:
	javac -d bin src/chess/*.java src/chess/piece/*.java

jar: source
	jar cef chess.Main chessDestroyer.jar -C bin chess .

run:
	java -jar chessDestroyer.jar

clean:
	rm -R bin/chess chessDestroyer.jar
