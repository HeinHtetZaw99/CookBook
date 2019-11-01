package com.appbase;

public class ErrorVO {
    public enum TYPE {
        ERROR, NEUTRAL, POSITIVE, DIALOG
    }
    //close Type 1 for positive , 0 for negative
    private Object errorMsg = "";
    private TYPE errorType ;
    private boolean areDataNeededToBeCleared = false;

    public ErrorVO(Object msg, TYPE errorType) {
        this.errorMsg = msg;
        this.errorType = errorType;
    }

    public ErrorVO(Object errorMsg, TYPE errorType, boolean areDataNeededToBeCleared) {
        this.errorMsg = errorMsg;
        this.errorType = errorType;
        this.areDataNeededToBeCleared = areDataNeededToBeCleared;
    }


    public boolean areDataNeededToBeCleared() {
        return areDataNeededToBeCleared;
    }

    public void setAreDataNeededToBeCleared(boolean areDataNeededToBeCleared) {
        this.areDataNeededToBeCleared = areDataNeededToBeCleared;
    }

    public ErrorVO() {
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public TYPE getErrorType() {
        return errorType;
    }

    public void setErrorType(TYPE errorType) {
        this.errorType = errorType;
    }
}
