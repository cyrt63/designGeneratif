rem mvn clean compile assembly:single
call mvn clean package
java -jar target\P_1_0_Bonjour_Couleur-0.0.1-SNAPSHOT-jar-with-dependencies.jar
pause