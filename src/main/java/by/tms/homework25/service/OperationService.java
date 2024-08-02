package by.tms.homework25.service;

import by.tms.homework25.model.Operation;

public class OperationService {
    public Operation execute(Operation operation) {
        switch (operation.getType()) {
            case "sum" -> operation.setResult(operation.getNum1() + operation.getNum2());
            case "sub" -> operation.setResult(operation.getNum1() - operation.getNum2());
            case "mul" -> operation.setResult(operation.getNum1() * operation.getNum2());
            case "div" -> operation.setResult(operation.getNum1() / operation.getNum2());
        }
        return operation;
    }

}
