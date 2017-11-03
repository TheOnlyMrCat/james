package com.dockdev.james;

/**
 * The abstract form of a response for {@link James}
 * @author TheOnlyMrCat
 *
 */

public abstract class SpeechResponse {

	protected String speech;
	
	SpeechResponse(String speech) {
		this.speech = speech;
	}
	
	public static class AskSpeechResponse extends SpeechResponse {

		@SuppressWarnings("unused")
		private String prompt;
		
		public AskSpeechResponse(String speech, String reprompt) {
			super(speech);
			prompt = reprompt;
		}
		
		public AskSpeechResponse(String speech) {
			this(speech, speech);
		}
		
		public AskSpeechResponse() {
			this("", "");
		}

		@Override
		public void speak() {
			
		}

		@Override
		public void calculate() {
			
		}
		
	}
	
	public static class TellSpeechResponse extends SpeechResponse {

		public TellSpeechResponse(String speech) {
			super(speech);
		}
		
		public TellSpeechResponse() {
			this("");
		}

		@Override
		public void speak() {
			
		}

		@Override
		public void calculate() {
			
		}
		
	}
	
	public static class ActSpeechResponse extends SpeechResponse {
		
		@SuppressWarnings("unused")
		private String action;
		
		public ActSpeechResponse(String action, String speech) {
			super(speech);
			this.action = action;
		}
		
		public ActSpeechResponse(String action) {
			this(action, action);
		}
		
		public ActSpeechResponse() {
			this("");
		}

		@Override
		public void speak() {
			
		}
		
		public void doAction() {
			
		}

		@Override
		public void calculate() {
			
		}
	}

	public abstract void calculate();
	public abstract void speak();
	
	public static SpeechResponse getSpeechResponse(String text) {
		String type = "";
		switch (type) {
			case "question": return new AskSpeechResponse();
			case "response": return new TellSpeechResponse();
			case "action": return new ActSpeechResponse();
			default: return null;
		}
	}
}
