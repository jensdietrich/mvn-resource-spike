# mvn-resource-spike


This is a spike to check how mvn resolves resource conflicts. Classes in `src/main/resources` are compiled separately (outside `mvn`). 
Then the project is build using `mvn package`.  Then to verify what is included, do the following:

1. unzip and inspect `target/mvnspike-1.0.0.jar `
2. run  `java -cp target/mvnspike-1.0.0.jar pck.Main`
3. inspect the classes in `target` with `javap -c`

Some observations: 

1. classes compiled during the build win over pre-compiled resources
2. if a `.class` file compiled during the build is included in the jar file, then inner classes of a class with the same name in `src/main/resources` are not included
3. if a `.class` file in `src/main/resources` has a name that does not clash with a class file compiled during the build and 2. does not apply, then this `.class` file is included

Versions used:

1.  `mvn -version`  >  Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
2.  `java -version` >  java version "11.0.11" 2021-04-20 LTS Java(TM) SE Runtime Environment 18.9 (build 11.0.11+9-LTS-194) Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.11+9-LTS-194, mixed mode)