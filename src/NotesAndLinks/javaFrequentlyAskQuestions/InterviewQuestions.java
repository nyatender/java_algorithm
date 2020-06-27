package NotesAndLinks.javaFrequentlyAskQuestions;

public class InterviewQuestions {
}

//Q25. What is Java String Pool?
//Java String pool refers to a collection of Strings which are stored in heap memory.
// In this, whenever a new object is created, String pool first checks whether the object is already present in the pool or not. If it is present, then the same reference is returned to the variable else new object will be created
// in the String pool and the respective reference will be returned.