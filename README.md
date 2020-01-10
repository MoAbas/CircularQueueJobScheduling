##### Circular Queue Job Scheduling ###### Jobs take turns to be processed in First-inFirst-out manner. ###### At each turn, one jub can run maximum 100 milliseconds (quantom time)
&nbsp;A) If the execution/remaining execution time for the job is less than 100 ms, it leaves the queue at the end of its time.<br/>
&nbsp;B) If the execution/remaining execution time for the job is 100 ms, it leaves the queue after the quantom time is over.<br/>
&nbsp;C) If the execution/remaining execution time for the job is more than 100 ms, the job is dequeued and enqueued back to the job queue and waits for its next turn.
