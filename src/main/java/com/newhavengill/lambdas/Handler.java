package com.newhavengill.lambdas;

public interface Handler<E extends Entity, M extends Message> {
	public E handle(M message);
}