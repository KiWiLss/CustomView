package com.magicsoft.customviewone.expression.expression;

import android.content.Context;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/22
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public abstract class AbstractExpression {

    /**
     * 抽象的解析方法
     * @param context 上下文环境对象
     */
    public abstract void interpret(Context context);

}
