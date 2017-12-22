package com.magicsoft.customviewone.expression;

import com.magicsoft.customviewone.expression.composite.Composite;
import com.magicsoft.customviewone.expression.composite.Leaf;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/22
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class Test {
    public static void component(){

        Composite root = new Composite();

        Leaf leaf1 = new Leaf();
        Composite branch = new Composite();
        root.add(leaf1);
        root.add(branch);

        Leaf leaf2 = new Leaf();
        branch.add(leaf2);

        root.operation();
    }
}
