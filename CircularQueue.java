package circularQueueSolution;


import java.util.Arrays;

/** This class hold the object constructor, enqueue and dequeue methods */
class CircularQueue{

        private int currentSize; //Current Circular Queue Size
        private final int maxSize = 3;
        private final Passenger[] circularQueueElements = new Passenger[maxSize];

        private int rear;//rear position of Circular queue(new element enqueued at rear).
        private int front; //front position of Circular queue(element will be dequeued from front).

        // Method to initialize each variable to "empty" and 0
        public CircularQueue() {

            for (int i = 0;i < circularQueueElements.length;i++){
                circularQueueElements[i] = new Passenger();
            }

            currentSize = 0;
            front = -1;
            rear = -1;

        }




         // Enqueue elements to rear.

        public void enqueue(Passenger passenger ){
            if (isFull()) {
                System.out.println("Circular Queue is full. Element cannot be added");
            }
            else {
                rear = (rear + 1) % circularQueueElements.length;
                circularQueueElements[rear] = passenger;
                currentSize++;

                if (front == -1) {
                    front = rear;
                }
            }
        }


         // Dequeue element from Front.

        public Passenger dequeue()  {
            Passenger deQueuedElement = new Passenger();
            if (isEmpty()) {
                System.out.println ("Circular Queue is empty. Element cannot be retrieved");
            }
            else {
                deQueuedElement = circularQueueElements[front];
                circularQueueElements[front] = new Passenger();
                front = (front + 1) % circularQueueElements.length;
                currentSize--;
            }
            return deQueuedElement;
        }


          //Check if queue is full.

        public boolean isFull() {
            return (currentSize == circularQueueElements.length);
        }


         // Check if Queue is empty.

        public boolean isEmpty() {
            return (currentSize == 0);
        }

        @Override
        public String toString() {
            return "\nCircularQueue [" + Arrays.toString(circularQueueElements) + "]\n";
        }


}



