# FinCo
A Financial Company framework for our Advanced Software Development course at Maharishi International University.

# Build
to build use the terminal script `build.sh`
```shell script
chmod +x build.sh # use it only once to give executable permission to the file
./build.sh [bank|ccard]
```
and run with: `java -jar target/bank.jar` or `java -jar target/ccard.jar`

if using windows write the following commands
```shell script
mvn -Pbank clean package
mvn -Pccard clean package
```