package com.magicsoft.customviewone.expression.qiaojie;

public class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void refinedOperation() {
        //对 Abstraction 中的 operation 方法进行扩展

    }

    @Override
    public void operation() {
        super.operation();
    }
}