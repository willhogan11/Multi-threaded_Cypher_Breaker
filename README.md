# Multi-threaded_Cypher_Breaker
* Name: Will Hogan
* Year: 3rd Year
* Module: Object Oriented Programming
* Lecturer: John Healy
* Assignment: "A Multi Threaded Cypher-Breaker"
* Submission Date: Sunday 10th January 2016 12 Midnight

##Outline
This is a Multi threaded Cypher breaker using Java as the programming language with the Eclipse IDE. The idea is that a user enteres plain text into the console, it will then be encrypted. and then Cypher breaker will attempt to break it by using threads to Compare Key value pairs from the Quad Grams Text File against those Reuslts outputted from the blocking queue. The best or highest scoring key should be very similar or the same as the originally encrytped plain text that the user entered.  

##Contents
The Applications contains 11 classes, of which two are Interfaces.

####Class Information
| Class  | Description |
|:------:|:---------------------------------------------:|
|**Consumer** | Consumer threads that are responsible for taking results from a Result Blocking Queue |
|**Decryptor** | Responsible for putting result objects onto the BlockingQueue |
|**FileParser** | Reads the Key Value pairs from the 4grams.txt into a ConcurrentHashMap |
|**PoisonResult** | Deals with Poisoning a Blocking Queue, that effectively stops it |
|**QuadGramMap** | Compares each quad gram from the 4grams.txt against the Result returned from decryption |
|**RailFence** | Basic implementation of the Rail Fence Cypher using a 2D char array |
|**Result** | Creates a Result object that contains best match plain text, key and score of the decryption effort |
|**TextScorer** | Statically declares a Quad Gram Size of 4, the size of each Key in the 4grams.txt file |
|**Runner** | Contains the main method the run the application |  
|**Resultable**| Interface that contains purely declarative methods |
|**Poisonable**| Interface that contains purely declarative methods |


####Application File Information
| Name  | Description |
|:------:|:---------------------------------------------:|
| *railfence.jar* | A java archive containing my API, Created using AntBuild in Eclipse |
| *src*| A directory that contains the packaged source code for the application |
| *design.png*| This is a UML diagram that displays the relationships between each class in the application |
| *docs* | A directory that contains the JavaDocs for my Application | 
| *build.xml* | An ant build script that compiles the source code in the *src* directory and builds the JAR archive railfence.jar |
| *4grams.txt* | Contains Quad gram text segments(Split into 4 characters) in order from least to most used in the English Language |

##Instructions for use
* Download this project as zip and unpackage to your workspace. 
* Open up a Command Prompt and navigate to specified location of downloaded and unpackaged application
* Run the following command ```java -cp ./railfence.jar ie.gmit.sw.Runner```
* Enter the message you want to Send to be encrypted and press return

The one with the best score will be the one closest, if not the same as the original plain text. Check the screenshots folder for visual reference. 
