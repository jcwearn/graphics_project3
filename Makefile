compile:
	javac Driver.java BresenhamLineScan.java DataLine.java Matrix.java

Driver:
	javac Driver.java

DataLine:
	javac DataLines.java

clean:
	rm *.class

run:
	java Driver