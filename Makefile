all: source run

source:
	javac -d bin src/*.java

run:
	java -cp bin Main

clean:
	rm -R bin/*.class
