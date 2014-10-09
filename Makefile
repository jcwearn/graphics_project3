compile:
	javac Driver.java BresenhamLineScan.java LineTransformations.java DataLine.java

Driver:
	javac Driver.java

LineTransformations:
	javac LineTransformations.java

clean:
	rm *.class

run:
	java Driver