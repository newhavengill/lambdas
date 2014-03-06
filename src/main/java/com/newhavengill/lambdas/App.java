package com.newhavengill.lambdas;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		runOnce();
	}
	
	/* Common Pattern  6 lines to return Wine */
	public static void runOnce() {
		
		/* Old Way.  Handle Wine Message */
		Processor.process(WineMessage.class, new Handler<Wine, WineMessage>() {
			
			@Override
			public Wine handle(WineMessage message) {
				return message.getWine();
			}
		});
		
		/* Old Way.  Repeat for Handler for Vineyard Message 
		Processor.process(VineyardMessage.class, new Handler<Vineyard, VineyardMessage>()
			@Override
			public Vineyard handle(VineyardMessage message) {
				return message.getWine();
			}
		});		*/
	
		/* Lambdas Pattern 3 lines */
		Processor.process(WineMessage.class, (WineMessage message) -> {
			return message.getWine();
		});
		
		/*  Type Inference 1 line
		Processor.process(WineMessage.class, (WineMessage message) -> message.getWine());
		*/

		/* Lamdba way to bring in Vineyard Message Handler 
		Handler<Vineyard, VineyardMessage> handler = VineyardMessage::getVineyard;
		Processor.process(VineyardMessage.class,handler);	
		*/
	}

}