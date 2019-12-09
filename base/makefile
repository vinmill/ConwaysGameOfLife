GameOfLife.class: GameOfLife.java Main.class LinkedMatrices.class
	javac -g GameOfLife.java

LinkedMatrices.class: LinkedMatrices.java Main.class Node.class
	javac -g LinkedMatrices.java

Node.class: Node.java Main.class
	javac -g Node.java

Configuration.class: Configuration.java Main.class
	javac -g Configuration.java

Main.class: Main.java
	javac -g Main.java

clean:
	rm *.class

run: Main.class
	java Main

debug: Main.class
	jdb Main