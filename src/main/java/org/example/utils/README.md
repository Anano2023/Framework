### Running framework task tests

- Launch parameters for tests execution are stored in .properties files:
- There is a test of type `smoke`

- For example to run tests For Dev environment:

```commandline
 mvn clean test -Ddev 
```
For example to run tests For Prod environment:
```commandline
 mvn clean test -Dprod 
```

To run tests in `dev` environment with `smoke` tag

```commandline
 mvn clean test -Denv=dev -Dtests=smoke
```