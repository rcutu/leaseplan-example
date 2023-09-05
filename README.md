refactored:
- renamed CarsAPI class to something more specific for that endpoint DrinksProductClient
- used scenario outline in order to parametrize the tests for 4 available products / 2 unavailable
- defined more general steps in order to do checks on the responses
- added soft assertions
- removed gradle related files - since I decided to continue with mvn
- updates of maven.yml in order to trigger differently the CI/CD and to download the report

How to run the tests
- locally : simply run the TestRunner class -> the report should be generated in \target\site\serenity
- git actions: run the Maven Build workflow -> after it runs successfully an artifact should be generated that contains
the report