# Multi-threaded_Cypher_Breaker
* Name: Will Hogan
* Year: 3rd Year
* Module: Object Oriented Programming
* Lecturer: John Healy
* Assignment: "A Multi Threaded Cypher-Breaker"
* Submission Date: Sunday 10th January 2016

##Outline
This is a Multi threaded Cypher breaker using Java as the programming language with the Eclipse IDE. Essentiall what it does is....

##Contents
The Applications contains 11 classes, of which two are Interfaces.

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

