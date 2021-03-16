package leetcode.q359;

import java.util.HashMap;

class Logger {
	
	private HashMap<String, Integer> logger = null;

	/** Initialize your data structure here. */
	public Logger() {
		logger = new HashMap<String, Integer>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		boolean canPrint = false;
		if(logger.get(message) == null) {
			logger.put(message, timestamp);
			canPrint = true;
		} else {
			Integer prevTime = logger.get(message);
			if(timestamp-prevTime >= 10) {
				logger.put(message, timestamp);
				canPrint = true;
			}
		}
		
		
		return canPrint;
	}
}
