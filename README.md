# mvn-resource-spike


This is a spike to check how mvn resolves resource conflicts. Classes in `src/main/resources` are compiled separately (outside `mvn`). 
Then the project is build using `mvn package`.

Some observations: 

1. classes compiled during the build win over pre-compiled resources
2. if a `.class` file compiled during the build is included in the jar file, then inner classes of a class with the same name in `src/main/resources` are not included
3. if a `.class` file in `src/main/resources` has a name that does not clash with a class file compiled during the build and 2. does not apply, then this `.class` file is included

