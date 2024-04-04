package com.camunda.bpm.camunda_bpm.delegate;

public class Main {
	 public static void main(String[] args) {
	        SaveContratDelegate saveContratDelegate = new SaveContratDelegate();
	        try {
	            saveContratDelegate.execute(null); 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
