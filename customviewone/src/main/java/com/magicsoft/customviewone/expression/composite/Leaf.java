package com.magicsoft.customviewone.expression.composite;

import android.util.Log;

public class Leaf extends Component{
    @Override
    public void operation() {
        Log.e("MMM", "this if leaf " + this);
    }
}