package circularQueueScheduling;

public class CircularQueue<E> {

    private int currentSize; //Current Circular Queue Size
    private Job[] circularQueueElements;
    private int maxSize; //Circular Queue maximum size

    private int rear;//rear position of Circular queue(new element enqueued at rear).
    private int front; //front position of Circular queue(element will be dequeued from front).      

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (Job[]) new Job[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    /**
     * Enqueue elements to rear.
     * @param item
     */
    public void enqueue(Job item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;
            
            if (front == -1) {
                front = rear;
            }
        }
    }

    /**
     * Dequeue element from Front.
     * @return 
     */
    public Job dequeue() throws QueueEmptyException {
        Job deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }
    
    public Job getFront(){
        Job frontJob;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            frontJob = circularQueueElements[front];
        }
        return frontJob;
    }

    /**
     * Check if queue is full.
     * @return 
     */
    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    /**
     * Check if Queue is empty.
     * @return 
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        String str="";
        for(int i=0;i<circularQueueElements.length;i++){
            if(circularQueueElements[(front+i)%circularQueueElements.length]!=null){
                if((front+i)%circularQueueElements.length==front) str+=circularQueueElements[(front+i)%circularQueueElements.length].name;
                else str+=","+circularQueueElements[(front+i)%circularQueueElements.length].name;
            }
        }
        return str;
    }

}

class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }

}