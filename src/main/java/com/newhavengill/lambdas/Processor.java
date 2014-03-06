package com.newhavengill.lambdas;

import java.util.Arrays;

public class Processor {
	
	private static List<Message> MESSAGES = Arrays.asList(
		new VineyardMessage(new Vineyard("GoatFarm")),
		new WineMessage(new Wine("RedRedWine")),
		new VineyardMessage(new Vineyard("RedHouse")),
		new WineMessage(new Wine("Balsac")),
		new WineMessage(new Wine("BlueHills"))
	);
	
	public static void persist(Object obj) {
		System.out.println("Persist " + obj);
	}
	
	@SuppressWarnings("unchecked")
	public static <E extends Entity, M extends Message> 
	void process(Class<M> type, Handler<E,M> handler) {
		for (Message message : MESSAGES) {
			if (type.isAssignableFrom(message.getClass())) {
				E entity = handler.handle((M) message);
				persist(entity);
			}
		}
	}
}