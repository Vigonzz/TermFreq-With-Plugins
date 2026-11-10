This program follows the Week 6 assignment for the Programming
Style, Plugins. Plugins focuses on keeping the main program as a 
"shell" thus not containing any of the important information.
The pro of a style like this is to modify and share the code with ease
making future implementations easy.

### Understanding config.properties:
Keeping the Style purpose in mind the way to create customization
is through the implementation of the config file called:
config.properties. The config file allows us to switch which plugin we want to use **The run command will always stay the same**, but it is 
important to stay in the folder of the project so for instance User/WeekSix ...
**Each plug in has a different purpose:**
- words1: 
- words2:
- frequencies1:
- frequencies2:


### How to run:
Please ensure you have java 11 or newer.

1. Open terminal and go to project:
   - cd/path/to/file/WeekSix
2. Build the interfaces
   - javac -d build/interfaces src/interfaces/TFWords.java
   src/interfaces/TFFreqs.java
   - jar cf lib/interfaces.jar -C build/interfaces .
3. Build main
   - javac -d build/main -cp lib/interfaces.jar src/main/Main.java
4. (Recall the plugins) Build each plugin into its own Jar
5. Choose your plugins **within the config file.** The final run command (later shown) will always be the same
    - To choose plugins go to a text editor, open config.properties and set 1 of the following:
        - **Words1 + Frequencies1 (Normal Term Freq program)**:
          words.jar = plugins/words1.jar
          words.class = plugins.Words1
          frequencies.jar = plugins/frequencies1.jar
          frequencies.class = plugins.Frequencies1
        - **Word2 + Frequencies1 (z-words)**:
          words.jar = plugins/words2.jar
          words.class = plugins.Words2
          frequencies.jar = plugins/frequencies1.jar
          frequencies.class = plugins.Frequencies1
        - **Words1 + Frequencies2 (Firs letter)**:
          words.jar = plugins/words1.jar
          words.class = plugins.Words1
          frequencies.jar = plugins/frequencies2.jar
          frequencies.class = plugins.Frequencies2
        - **Words2 + Frequencies2 (z-words by first letter)**:
          words.jar = plugins/words2.jar
          words.class = plugins.Words2
          frequencies.jar = plugins/frequencies2.jar
          frequencies.class = plugins.Frequencies2
5. Run according to your config,properties setting 
   - Normal Output:
      - javac -d build/plugins/words1 -cp lib/interfaces.jar src/plugins/Words1.java
      - jar cf plugins/words1.jar -C build/plugins/words1 .
      - java -cp build/main:lib/interfaces.jar main.Main ../pride-and-prejudice.txt
   - Non-stop words containing z:
     - javac -d build/plugins/words2 -cp lib/interfaces.jar src/plugins/Words2.java
     - jar cf plugins/words2.jar -C build/plugins/words2 .
     - java -cp build/main:lib/interfaces.jar main.Main ../pride-and-prejudice.txt
   - Count by first letter:
      - javac -d build/plugins/frequencies1 -cp lib/interfaces.jar src/plugins/Frequencies1.java
      - jar cf plugins/frequencies1.jar -C build/plugins/frequencies1 .
      - -cp build/main:lib/interfaces.jar main.Main ../pride-and-prejudice.txt
   - First Letter count:
     - javac -d build/plugins/frequencies2 -cp lib/interfaces.jar src/plugins/Frequencies2.java
     - jar cf plugins/frequencies2.jar -C build/plugins/frequencies2 .
     - java -cp build/main:lib/interfaces.jar main.Main ../pride-and-prejudice.txt
6. (Extra: Shows what each plugin needs to compile) 
   - words1:
      - javac -d build/plugins/words1 -cp lib/interfaces.jar src/plugins/Words1.java 
      - jar cf plugins/words1.jar -C build/plugins/words1 .
   - words2:
     - javac -d build/plugins/words2 -cp lib/interfaces.jar src/plugins/Words2.java
     - jar cf plugins/words2.jar -C build/plugins/words2 .
   - frequencies1:
     - javac -d build/plugins/frequencies1 -cp lib/interfaces.jar src/plugins/Frequencies1.java
     - jar cf plugins/frequencies1.jar -C build/plugins/frequencies1 .
   - frequencies2:
     - javac -d build/plugins/frequencies2 -cp lib/interfaces.jar src/plugins/Frequencies2.java
     - jar cf plugins/frequencies2.jar -C build/plugins/frequencies2 .

7. Already done in step 5 but just incase → run:
   - java -cp build/main:lib/interfaces.jar main.Main ../pride-and-prejudice.txt

Please ensure you have all necessary files such lib/ and plugins/ since
it is where the compiled files go into.

ALL code is created by me!!
This program uses AI Claude Chat to help step by step breakdown, understand material, and debug.
https://claude.ai/share/12c2a7b3-87ca-4b4f-8378-686de59b44c8