package com.magicsoft.customviewone.expression.composite;

import android.util.Log;

import java.util.ArrayList;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/22
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class Composite extends Component {
    private ArrayList<Component> componentList = new ArrayList<>();

    @Override
    public void operation() {
        Log.e("MMM", "this is composite " + this + " -------start");
        for (Component component : componentList) {
            component.operation();
        }
        Log.e("MMM", "this is composite " + this + " -------end");

    }

    public void add(Component child) {
        componentList.add(child);
    }

    public void remove(Component child) {
        componentList.remove(child);
    }

    public Component getChild(int position) {
        return componentList.get(position);
    }
}
